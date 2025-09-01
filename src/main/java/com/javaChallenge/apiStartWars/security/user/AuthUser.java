package com.javaChallenge.apiStartWars.security.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
