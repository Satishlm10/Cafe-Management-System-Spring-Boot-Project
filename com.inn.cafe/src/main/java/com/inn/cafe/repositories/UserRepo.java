package com.inn.cafe.repositories;

import com.inn.cafe.Entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByEmailId(@Param("email") String email);
}
