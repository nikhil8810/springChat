package com.strange.chat.service;

import com.strange.chat.model.User;
import com.strange.chat.dto.UserRequestDto;
import com.strange.chat.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
} 