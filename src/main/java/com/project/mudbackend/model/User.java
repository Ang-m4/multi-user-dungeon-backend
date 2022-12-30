package com.project.mudbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long id;

    @Column(name = "user_nickname")
    String nickname;

    @Column(name = "user_password")
    String password;

    @Column(name = "user_role")
    String role;

    @OneToOne
    Character character;

}
