package com.hoaxify.ws.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="userss")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String displayname;
    private String password;

}
