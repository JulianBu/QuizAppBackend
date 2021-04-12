package com.quizapi.backend.Persistency.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "USER")
public class User implements Serializable {
    private static final long serialVersionUID = -6400758504290942030L;

    @Id
    @GeneratedValue
    @Column(name = "USERID", unique = true)
    private long userId;

    @NonNull
    @Size(min = 4, max = 20, message = "Username should be between 4 and 20 characters")
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NonNull
    @Size(min = 4, max = 20, message = "Password should be between 4 and 20 characters")
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USERSCORE")
    private int score;

}
