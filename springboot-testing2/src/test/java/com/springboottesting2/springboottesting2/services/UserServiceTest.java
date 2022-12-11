package com.springboottesting2.springboottesting2.services;

import com.springboottesting2.springboottesting2.models.User;
import com.springboottesting2.springboottesting2.repository.IRepository;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private IRepository repository;
    @InjectMocks
    private UserService underTest;
    private User newUser;

    @BeforeEach
    void Setup(){
        MockitoAnnotations.openMocks(this);
        newUser = new User(

                "Pedro",
                "pedrocf",
                "12345678",
                "Paco@gmail.com"
        );
    }

    @Test
    void findAll_shouldReturnAListOfUsers() {
        lenient().when(repository.findAll()).thenReturn(Arrays.asList(newUser));

        assertNotNull(underTest.FindAllUsers());
    }

    @Test
    void findAllById_shouldReturnAUser() {
        lenient().when(repository.findById(1L)).thenReturn(Optional.of(new User()));

        Optional<User> userSelected = Optional.ofNullable(underTest.FindUserById(1L));
        assertTrue(userSelected.isPresent());
        assertEquals(new User(), userSelected.get());
    }

    @Test
    void SaveUser_shouldReturnAUser() {
        lenient().when(repository.save(any())).thenReturn(newUser);

        assertNotNull(underTest.SaveUser(newUser));
    }

    @Test
    void DeleteUser_shouldReturnNothingAndDeleteTheUser(){
        doNothing().when(repository).deleteById(1L);

        underTest.DeleteUser(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}