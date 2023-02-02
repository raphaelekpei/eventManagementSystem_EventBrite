package com.raphael.eventmanagementsystem_eventbrite.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
