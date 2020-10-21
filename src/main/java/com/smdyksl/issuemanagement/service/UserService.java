package com.smdyksl.issuemanagement.service;

import com.smdyksl.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);
    User getByUsername(String username);

    Page<User> getAllPageable(Pageable pageable);
}
