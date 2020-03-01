package com.example.repository;

import com.example.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepos extends JpaRepository<CustomUser, Integer> {
    CustomUser findByEmail(@Param("email") String email);
    boolean existsByEmail(@Param("email") String email);
    CustomUser queryByEmailAndFirstName(@Param("email") String email, @Param("firstName") String firstName);
}
