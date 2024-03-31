package com.inn.cafe.service.serviceImpl;

import com.inn.cafe.Entities.Users;
import com.inn.cafe.constants.CafeConstants;
import com.inn.cafe.dtos.UsersDto;
import com.inn.cafe.repositories.UserRepo;
import com.inn.cafe.service.UserService;
import com.inn.cafe.utlis.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signUp {}",requestMap);
        try {
            if (validateSignUpMap(requestMap)) {

                Users users = userRepo.findByEmailId(requestMap.get("email"));

                if (Objects.isNull(users)) {

                    userRepo.save(getUsersFromDto(getUserDtoFromMap(requestMap)));
                    return CafeUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);

                } else {

                    return CafeUtils.getResponseEntity("Email already exist.", HttpStatus.BAD_REQUEST);

                }
            } else {

                return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){

            ex.printStackTrace();

        }
           return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String, String> requestMap){
        if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email") && requestMap.containsKey("password")){
            return true;
        }
        return false;
    }

    private UsersDto getUserDtoFromMap(Map<String,String > requestMap){

        UsersDto userdto = modelMapper.map(requestMap, UsersDto.class);
        return userdto;
    }

    private Users getUsersFromDto(UsersDto usersDto){
        Users users = this.modelMapper.map(usersDto, Users.class);
        users.setStatus("false");
        users.setRole("User");
        return users;
    }
}
