package com.spring.userability.repository;

import com.spring.userability.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserabilityRepository extends JpaRepository<User, Long> {
}
