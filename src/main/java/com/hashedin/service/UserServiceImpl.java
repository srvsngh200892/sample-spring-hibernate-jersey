


package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.User;
import com.hashedin.repository.UserRepository;


@Service("UserService")
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository UserRepository;


    public User find(Long UserId)
    {
        // Returns the User for given UserId.
        return UserRepository.find(UserId);
    }


    @Transactional
    public User save(User User)
    {
        // Saves the given User object and returns the same.
        UserRepository.save(User);
        return User;
    }


    @Override
    public List<User> findAll()
    {
        // Returns all the Users in our system.
        return UserRepository.findAll();
    }


    @Override
    public User update(User User, Long UserId)
    {
        // Updates the User with the given UserId;
        return null;
    }


    @Transactional
    public User delete(Long UserId)
    {
        // Deletes the User with the give UserId and returns the same.
        return UserRepository.delete(UserId);
    }

}
