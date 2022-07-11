package com.digitalbooking.proyecto.repository;

import com.digitalbooking.proyecto.model.UserEntity;
import com.digitalbooking.proyecto.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
