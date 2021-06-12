package com.flight.flightsearch.service;


import com.flight.flightsearch.model.Audience;
import com.flight.flightsearch.repository.AudienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService{
    
    @Autowired
    private AudienceRepo audienceRepo;


    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // return new User("foo","foo",new ArrayList<>());
        Audience audience = this.audienceRepo.findByUsername(userName);
        GrantedAuthority authority=new SimpleGrantedAuthority(audience.getRole());
        return new User(audience.getUsername(),audience.getPassword(),new ArrayList<>());
    }
}
