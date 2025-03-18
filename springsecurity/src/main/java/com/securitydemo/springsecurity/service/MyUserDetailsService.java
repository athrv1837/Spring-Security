package com.securitydemo.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitydemo.springsecurity.model.User;
import com.securitydemo.springsecurity.model.UserPrincipal;
import com.securitydemo.springsecurity.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepo.findByUsername(username);
       if(user == null){
        System.out.println("user not foond");
        throw new UsernameNotFoundException("User not found");
       }
       return new UserPrincipal(user);
    }
    
}
