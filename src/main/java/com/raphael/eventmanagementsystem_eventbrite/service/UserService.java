package com.raphael.eventmanagementsystem_eventbrite.service;

import com.raphael.eventmanagementsystem_eventbrite.data.model.User;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.CreateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.LoginRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.UpdateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.CreateAccountResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.LoginResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.UpdateAccountResponse;

import java.util.List;

public interface UserService {
    CreateAccountResponse signup(CreateAccountRequest createAccountRequest);
    LoginResponse login(LoginRequest loginRequest);

    User getAccountById(String userId);
    User getAccountByEmail(String email);
    List<User> getAllAccount();

    UpdateAccountResponse updateAccountDetails(String userId, UpdateAccountRequest updateAccountRequest);


    void deleteAccount(String userId);

    void deleteAllAccount();
}
