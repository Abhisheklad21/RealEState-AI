package com.realestate.payload;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String username;
    private String name;
    private String email;
    private String password;

}
