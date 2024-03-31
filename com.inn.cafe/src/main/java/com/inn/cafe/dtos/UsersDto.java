package com.inn.cafe.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UsersDto {

    private String name;

    private String contactNumber;

    private String email;

    private String password;



}
