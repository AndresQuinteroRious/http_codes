package com.devsenior.andresquintero.httpcode.service;

import java.util.List;

import com.devsenior.andresquintero.httpcode.dto.UserDto;
import com.devsenior.andresquintero.httpcode.dto.UserRequest;

public interface UserService {

    List<UserDto> getAll();

    UserDto getByUsername(String username);
    UserDto getByEmail(String email);

    UserDto create(UserRequest user);

   

    void delete(String username);


}
