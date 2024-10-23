package com.camels.user_service.service.impl;

import com.camels.user_service.dto.SaveUserDto;
import com.camels.user_service.dto.UpdateUserDto;
import com.camels.user_service.entity.User;
import com.camels.user_service.repository.IUserRepository;
import com.camels.user_service.service.IUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public SaveUserDto saveUser(SaveUserDto saveUserDto) {
        User user = modelMapper.map(saveUserDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, SaveUserDto.class);
    }

    @Override
    public UpdateUserDto updateUser(UpdateUserDto updateUserDto, Long id) {
        User user = userRepository.findById(id).get();
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setEmail(updateUserDto.getEmail());
        user.setPassword(updateUserDto.getPassword());
        user.setPhone(updateUserDto.getPhone());

        user = userRepository.save(user);
        return modelMapper.map(user, UpdateUserDto.class);
    }

    @Override
    public User getMyProfile(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
