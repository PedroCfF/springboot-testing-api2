package com.springboottesting2.springboottesting2.repository;

import com.springboottesting2.springboottesting2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<User, Long> {

}
