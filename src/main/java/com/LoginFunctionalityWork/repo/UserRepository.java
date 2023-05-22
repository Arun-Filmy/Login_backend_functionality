package com.LoginFunctionalityWork.repo;

import com.LoginFunctionalityWork.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
    List<UserDetails> findByEmail(String email);
}
