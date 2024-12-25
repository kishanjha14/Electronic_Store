package com.kishan.Electroinc.store.ElectronicStore.services.impl;

import com.kishan.Electroinc.store.ElectronicStore.Repositorys.UserRepository;
import com.kishan.Electroinc.store.ElectronicStore.dtos.PageableResponse;
import com.kishan.Electroinc.store.ElectronicStore.dtos.UserDto;
import com.kishan.Electroinc.store.ElectronicStore.services.Userservices;
import com.kishan.Electroinc.store.ElectronicStore.entities.User;
import com.kishan.Electroinc.store.ElectronicStore.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements Userservices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);
        //dto toEntity mapping
        User user = dtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        // entity to dto mapping
        UserDto newDto = entityToDto(savedUser);
        return newDto;
    }

    @Override
    public UserDto update(UserDto userDto, String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not Found with given id"));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        user.setGender(userDto.getGender());
        user.setImageName(userDto.getImageName());
        userRepository.save(user);
        return entityToDto(user);
    }

    @Override
    public void deleteUser(String userId) {
    User user =  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not Found with given id"));
        userRepository.delete(user) ;
    }

    @Override
    public PageableResponse<UserDto> getAllUser(int pageNumber , int pageSize, String sortBy , String sortDir){
        Sort sort = (sortDir.equalsIgnoreCase("Asc"))?(Sort.by(sortBy).ascending()) :(Sort.by(sortBy).descending());
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<User> page =  userRepository.findAll(pageable);
        List<User> users = page.getContent();
        List<UserDto> dtoList = users.stream()
                .map(user -> entityToDto(user))
                .collect(Collectors.toList());
        PageableResponse<UserDto> response = new PageableResponse<>();
        response.setContent(dtoList);
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalPages(page.getTotalPages());
        response.setTotalElements(page.getTotalElements());
        response.setLastPage(page.isLast());
        return response;
    }


    @Override
    public UserDto getUserById(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with given user Id"));
        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email)      {
        User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Not find any user with this email"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> dto = users.stream()
                .map(user -> entityToDto(user))
                .collect(Collectors.toList());
        return dto;
    }



    private UserDto entityToDto(User savedUser) {
//        UserDto  userDto = UserDto.builder()
//                .userId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .gender(savedUser.getGender())
//                .about(savedUser.getAbout())
//                .ImageName(savedUser.getImageName())
//                .build();
        return mapper.map(savedUser,UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
//        User user = User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getAbout())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//                .ImageName(userDto.getImageName())
//                .build();
        return mapper.map(userDto,User.class);

    }

}
