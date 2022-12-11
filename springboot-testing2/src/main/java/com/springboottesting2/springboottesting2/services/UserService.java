package com.springboottesting2.springboottesting2.services;

import com.springboottesting2.springboottesting2.models.User;
import com.springboottesting2.springboottesting2.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private IRepository repository;

    UserService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> FindAllUsers() {
        return repository.findAll();
    }

    @Override
    public User FindUserById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public User SaveUser(User user) {
        repository.save(user);
        return user;
    }

    @Override
    public User UpdateUser(User user, long id) {
        User selectedUser=repository.findById(id).get();
        selectedUser=user;
        repository.save(selectedUser);
        return selectedUser;
    }

    @Override
    public void DeleteUser(long id) {
        repository.deleteById(id);
    }
}
