package com.kishan.Electroinc.store.ElectronicStore.controller;

import com.kishan.Electroinc.store.ElectronicStore.dtos.PageableResponse;
import com.kishan.Electroinc.store.ElectronicStore.dtos.UserDto;
import com.kishan.Electroinc.store.ElectronicStore.services.Userservices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final Userservices userservices;

    @Autowired
    public UserController(Userservices userservices) {
        this.userservices = userservices;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
       UserDto userDto1 = userservices.createUser(userDto);
       return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }

    @PatchMapping("/{userId}")
    public  ResponseEntity<UserDto> updateUser(@Valid  @PathVariable String userId,@RequestBody  UserDto userDto)
    {
    UserDto userDto1 = userservices.update(userDto,userId);
    return  new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId)
    {
        userservices.deleteUser(userId);
        return new ResponseEntity<>("user is deleted Successfully",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PageableResponse<UserDto>> getAllUser(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
             @RequestParam(value = "pageSize",defaultValue = "10",required = false  ) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "name",required = false  ) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false  ) String sortDir

            )
    {
        return new ResponseEntity<>(userservices.getAllUser(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId)
    {
        return new ResponseEntity<>(userservices.getUserById(userId),HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
    {
        return new ResponseEntity<>(userservices.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/keyword/{keywords}")
    public ResponseEntity <List<UserDto>> searchUser(@PathVariable String keywords)
    {
        return new ResponseEntity<>(userservices.searchUser(keywords),HttpStatus.OK);
    }

}
