package com.smdyksl.issuemanagement.service.impl;

import com.smdyksl.issuemanagement.entity.User;
import com.smdyksl.issuemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserRepository userRepository;

}
