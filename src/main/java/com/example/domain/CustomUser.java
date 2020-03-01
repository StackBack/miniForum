package com.example.domain;

import com.example.Roles;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.servlet.View;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@Table(name = "users")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({Views.Public.class})
    private int id;
    @JsonView({Views.Public.class})
    private String email;
    @JsonView({Views.Public.class})
    private String firstName;
    @JsonView({Views.Public.class})
    private String secondName;
    @JsonView(Views.Internal.class)
    private String password;
    @Enumerated(EnumType.STRING)
    @JsonView({Views.Internal.class})
    private Roles role;
}
