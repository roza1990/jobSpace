package com.example.jobspace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "email.error")
    @Column
    @Size(min =2,max = 10)
    private String name;
    @Column
    @Size(min =2,max = 10)
    private String surname;
    @Column
    @Size(min=5,max = 9)
    private String number;
    @Column
    @Email
    private String email;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private String password;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "pic_url")
    @Size(min = 5)
    private String picUrl;

    public User(String name, String surname, String number, String email,
        Gender gender, String password, UserType userType,String picUrl) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.userType = userType;
        this.picUrl=picUrl;
    }
}
