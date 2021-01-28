package uz.sadirbaev.h2example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sadirbaev.h2example.entity.ERole;
import uz.sadirbaev.h2example.entity.RoleEntity;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    Optional<RoleEntity> findByName(ERole name);
}
