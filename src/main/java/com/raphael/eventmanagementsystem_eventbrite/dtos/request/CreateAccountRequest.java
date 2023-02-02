package com.raphael.eventmanagementsystem_eventbrite.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CreateAccountRequest {
    private String email;
    private String confirmEmail;
    private String firstName;
    private String lastName;
    private String password;

}
