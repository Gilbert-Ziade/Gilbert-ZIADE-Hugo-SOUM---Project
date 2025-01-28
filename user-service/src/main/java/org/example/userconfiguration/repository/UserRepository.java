package org.example.userconfiguration.repository;

import org.example.userconfiguration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);


    void deleteById(Long id);

    Optional<User> findByEmailAndPassword(String email, String password);
}
