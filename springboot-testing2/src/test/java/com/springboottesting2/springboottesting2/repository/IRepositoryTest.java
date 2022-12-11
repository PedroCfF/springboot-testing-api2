package com.springboottesting2.springboottesting2.repository;

import com.springboottesting2.springboottesting2.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IRepositoryTest {

    @Autowired
    IRepository underTest;

    @AfterEach
    void TearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentExistsById() {

        User newUser = new User(
                "Juan",
                "Juanpalomo",
                "12734634",
                "juan@gmail.com"
        );

        assertThat(underTest.findAll()).isNotNull();
    }

}