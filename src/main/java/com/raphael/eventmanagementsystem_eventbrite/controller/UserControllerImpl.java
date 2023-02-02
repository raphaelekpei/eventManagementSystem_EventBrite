package com.raphael.eventmanagementsystem_eventbrite.controller;

import com.raphael.eventmanagementsystem_eventbrite.data.model.User;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.CreateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.LoginRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.UpdateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.CreateAccountResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.LoginResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.UpdateAccountResponse;
import com.raphael.eventmanagementsystem_eventbrite.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("eventbrite.com/users")
public class UserControllerImpl implements UserController{
    @Autowired
    private final UserService userService;

    @Override
    @PostMapping("/signup")
    public CreateAccountResponse signup(CreateAccountRequest createAccountRequest) {
        return userService.signup(createAccountRequest);
    }

    @Override
    @PostMapping("/login")
    public LoginResponse login(LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @Override
    @GetMapping("/get/{userId}")
    public User getAccountById(@PathVariable String userId) {
        return userService.getAccountById(userId);
    }

    @Override
    @GetMapping("/get/{email}")
    public User getAccountByEmail(@PathVariable String email) {
        return userService.getAccountByEmail(email);
    }

    @Override
    @GetMapping("/get-all")
    public List<User> getAllAccount() {
        return userService.getAllAccount();
    }
    @Override
    public UpdateAccountResponse updateAccountDetails(String userId, UpdateAccountRequest updateAccountRequest) {
        return userService.updateAccountDetails(userId, updateAccountRequest);
    }

    @Override
    @DeleteMapping("/delete/{userId}")
    public String deleteAccount(@PathVariable String userId) {
        userService.deleteAccount(userId);
        return "successfully deleted";
    }

    @Override
    @DeleteMapping("/delete-all")
    public String deleteAllAccount() {
        userService.deleteAllAccount();
        return "successfully deleted";
    }
}
