package com.raphael.eventmanagementsystem_eventbrite.controller;

import com.raphael.eventmanagementsystem_eventbrite.data.model.User;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.CreateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.LoginRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.UpdateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.CreateAccountResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.LoginResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.UpdateAccountResponse;

import java.util.List;

public interface UserController {
    public CreateAccountResponse signup(CreateAccountRequest createAccountRequest);

    public LoginResponse login(LoginRequest loginRequest);
    public UpdateAccountResponse updateAccountDetails(String userId, UpdateAccountRequest updateAccountRequest);

    public User getAccountById(String userId);
    public User getAccountByEmail(String email);
    public List<User> getAllAccount();


    public String deleteAccount(String userId);
    public String deleteAllAccount();
}
