package com.raphael.eventmanagementsystem_eventbrite.service;

import com.raphael.eventmanagementsystem_eventbrite.data.model.User;
import com.raphael.eventmanagementsystem_eventbrite.data.repository.UserRepository;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.CreateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.LoginRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.request.UpdateAccountRequest;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.CreateAccountResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.LoginResponse;
import com.raphael.eventmanagementsystem_eventbrite.dtos.response.UpdateAccountResponse;
import com.raphael.eventmanagementsystem_eventbrite.exceptions.UserManagementException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;


    @Override
    public CreateAccountResponse signup(CreateAccountRequest createAccountRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(createAccountRequest.getEmail());
        if (optionalUser.isPresent()){
            throw new UserManagementException("user with the email" + createAccountRequest.getEmail() + " already exist");
        }
        User user = new User(
            createAccountRequest.getEmail(),
            createAccountRequest.getConfirmEmail(),
            createAccountRequest.getFirstName(),
            createAccountRequest.getLastName(),
            createAccountRequest.getPassword()
        );
        userRepository.save(user);
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setMessage("your account have been created successfully");
        return createAccountResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isEmpty()){
            throw new UserManagementException("email or password incorrect");
        }
        User user = optionalUser.get();
        if (user.getPassword().equals(loginRequest.getPassword())){
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage("you are successfully logged in");
            return loginResponse;
        }
        throw new UserManagementException("email or password incorrect");
    }

    @Override
    public User getAccountById(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public User getAccountByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("email not found");
        }
        return optionalUser.get();
    }

    @Override
    public List<User> getAllAccount() {
        return userRepository.findAll();
    }

    @Override
    public UpdateAccountResponse updateAccountDetails(String userId, UpdateAccountRequest updateAccountRequest) {
       Optional<User> optionalUser = userRepository.findById(userId);
       if (optionalUser.isEmpty()){
           throw new UserManagementException("user not found");
       }
       User user = optionalUser.get();
       if (!updateAccountRequest.getEmail().equals(user.getEmail())){
           user.setEmail(updateAccountRequest.getEmail());
       }
       if (!updateAccountRequest.getPassword().equals(user.getPassword())){
           user.setPassword(updateAccountRequest.getPassword());
       }
       if (!updateAccountRequest.getFirstName().equals(user.getFirstName())){
           user.setFirstName(updateAccountRequest.getFirstName());
       }
       if (!updateAccountRequest.getLastName().equals(user.getLastName())){
           user.setLastName(updateAccountRequest.getLastName());
       }
       UpdateAccountResponse updateAccountResponse = new UpdateAccountResponse();
       updateAccountResponse.setMessage("your account details have been successfully updated");
        return updateAccountResponse;
    }

    @Override
    public void deleteAccount(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user with the id "+ userId + " does not exist");
        }
        User user = optionalUser.get();
        userRepository.delete(user);
    }

    @Override
    public void deleteAllAccount() {
        userRepository.deleteAll();
    }


}
