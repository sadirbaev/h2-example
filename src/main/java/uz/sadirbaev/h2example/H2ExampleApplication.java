package uz.sadirbaev.h2example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uz.sadirbaev.h2example.entity.ERole;
import uz.sadirbaev.h2example.entity.RoleEntity;
import uz.sadirbaev.h2example.entity.UserEntity;
import uz.sadirbaev.h2example.repository.RoleRepository;
import uz.sadirbaev.h2example.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class H2ExampleApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(H2ExampleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		writeToDatabase();
		System.out.println(userRepository.findAll());
	}

	public void writeToDatabase(){
		RoleEntity roleEntity = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//		roleRepository.save(roleEntity);
		Set<RoleEntity> roleEntitySet = new HashSet<>();
		roleEntitySet.add(roleEntity);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserEntity userEntity = new UserEntity("bakhit", encoder.encode("password"));
		userEntity.setRoles(roleEntitySet);
		System.out.println(userEntity);
		userRepository.save(userEntity);
	}
}
