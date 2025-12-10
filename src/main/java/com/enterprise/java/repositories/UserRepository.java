package com.enterprise.java.repositories;

import com.enterprise.java.models.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository for user
public interface UserRepository extends JpaRepository<MyUserDetails, Integer> {
    public MyUserDetails findByUsername(String username);
}
