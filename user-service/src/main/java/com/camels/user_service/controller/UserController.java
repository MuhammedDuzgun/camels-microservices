package com.camels.user_service.controller;

import com.camels.user_service.dto.SaveUserDto;
import com.camels.user_service.dto.UpdateUserDto;
import com.camels.user_service.entity.User;
import com.camels.user_service.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;

    @PostMapping("/save-user")
    public ResponseEntity<SaveUserDto> saveUser(@RequestBody SaveUserDto saveUserDto) {
        SaveUserDto savedUserDto = userService.saveUser(saveUserDto);
        return savedUserDto != null ? ResponseEntity.ok(savedUserDto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/update-user/{id}")
    public ResponseEntity<UpdateUserDto> updateUser(@RequestBody UpdateUserDto updateUserDto,
                                                    @PathVariable(name = "id") Long id) {
        UpdateUserDto updatedUserDto = userService.updateUser(updateUserDto, id);
        return updatedUserDto != null ? ResponseEntity.ok(updatedUserDto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getMyProfile(@PathVariable(name = "id") Long id) {
        User user = userService.getMyProfile(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "Deleted User";
    }

}
