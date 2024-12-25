package com.kishan.Electroinc.store.ElectronicStore.services;


import com.kishan.Electroinc.store.ElectronicStore.dtos.PageableResponse;
import com.kishan.Electroinc.store.ElectronicStore.dtos.UserDto;
//import lombok.Builder;

import java.util.List;

public interface  Userservices {

    UserDto createUser(UserDto userDto);

   UserDto update(UserDto userDto, String userId);

    void deleteUser(String userId);

    PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy , String sortDir);

    UserDto getUserById(String userId);

    UserDto getUserByEmail(String email);

    List<UserDto> searchUser(String keyword);
}
