package com.kishan.Electroinc.store.ElectronicStore.dtos;

import com.kishan.Electroinc.store.ElectronicStore.validate.ImageNameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {


    private String userId;

    @Size(min = 3,max = 15,message = "Invalid name !!")
    private String name;
    @Email(message = "Invalid Email!!")
    private String email;
    @NotBlank(message = "password Required")
    private String password;
    @Size(min = 3,max = 10 ,message = "Invalid Gender")
    private String gender;

    @NotBlank
    private String about;

    @ImageNameValid
    private String imageName;

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

    public String getAbout() {
        return about;
    }

    public UserDto() {
    }

    public String getImageName() {
        return imageName;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDto(String userId, String name, String email, String password, String gender, String about, String imageName) {
        this.userId = userId;

        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.about = about;
        this.imageName = imageName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
