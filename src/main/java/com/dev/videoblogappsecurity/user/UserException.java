package com.dev.videoblogappsecurity.user;

import lombok.Data;

@Data
public class UserException extends RuntimeException{

    private final int code;

    public UserException(int codeResponse){
        this.code = codeResponse;
    }



}
