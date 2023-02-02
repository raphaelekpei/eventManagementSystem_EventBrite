package com.raphael.eventmanagementsystem_eventbrite.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String confirmEmail;
    private String password;
    private LocalDateTime dateRegistered = LocalDateTime.now();
    @DBRef
    private List<Event> eventList = new ArrayList<>();

    public User(String firstName, String lastName, String email, String confirmEmail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
    }
}
