package com.example.testtaskforamazon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    String id;

    @Indexed
    String login;

    String password;

    Role role;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
