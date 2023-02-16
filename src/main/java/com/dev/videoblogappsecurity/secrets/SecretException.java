package com.dev.videoblogappsecurity.secrets;

import lombok.Data;

@Data
public class SecretException extends Exception{

    private final int code;

    public SecretException(int code){
        this.code= code;
    }
}
