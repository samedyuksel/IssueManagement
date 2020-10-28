package com.smdyksl.issuemanagement.service;

import com.smdyksl.issuemanagement.dto.UserDto;
import com.smdyksl.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
