package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.Users;
import com.example.SpringDemoApp.repository.UsersRepository;
import com.example.SpringDemoApp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImplementation implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users myUser = usersRepository.findByEmail(username);
        if(myUser!=null) {
            User securityUser = new User(myUser.getEmail(), myUser.getPassword(), myUser.getRoles());
            return securityUser;
        }

        throw new UsernameNotFoundException("User Name not found");

    }
}
