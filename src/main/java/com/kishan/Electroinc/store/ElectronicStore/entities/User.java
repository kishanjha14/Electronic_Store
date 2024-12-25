package com.kishan.Electroinc.store.ElectronicStore.entities;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="users")
@Builder
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email", unique = true)
    private String email;
    @Column(name = "user_password",unique = true)
    private String password;
    private String gender;
    @Column(length = 1000)
    private String about;

    @Column(name = "user_image_name")
    private String imageName;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getImageName() {
        return imageName;
    }

    public User(String userId, String name, String email, String password, String gender, String about, String imageName) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.about = about;
        this.imageName = imageName;
    }

    public String getAbout() {
        return about;
    }

    public User(){
    }
}
