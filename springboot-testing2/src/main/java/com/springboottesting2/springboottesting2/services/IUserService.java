package com.springboottesting2.springboottesting2.services;

import com.springboottesting2.springboottesting2.models.User;

import java.util.List;

public interface IUserService {

    public List<User> FindAllUsers();
    public User FindUserById(Long id);
    public User SaveUser(User user);
    public User UpdateUser(User user, long id);
    public void DeleteUser(long id);
}
