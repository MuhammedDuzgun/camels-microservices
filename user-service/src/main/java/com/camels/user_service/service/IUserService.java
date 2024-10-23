package com.camels.user_service.service;

import com.camels.user_service.dto.SaveUserDto;
import com.camels.user_service.dto.UpdateUserDto;
import com.camels.user_service.entity.User;

public interface IUserService {
    SaveUserDto saveUser(SaveUserDto saveUserDto);
    UpdateUserDto updateUser(UpdateUserDto updateUserDto, Long id);
    User getMyProfile(Long id);
    void deleteUser(Long id);
}
