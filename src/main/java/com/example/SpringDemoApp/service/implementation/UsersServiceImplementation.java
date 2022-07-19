package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.Users;
import com.example.SpringDemoApp.repository.UsersRepository;
import com.example.SpringDemoApp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersServiceImplementation implements UsersService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


    }
}
