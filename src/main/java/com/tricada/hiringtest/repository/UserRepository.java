package com.tricada.hiringtest.repository;

import com.tricada.hiringtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
