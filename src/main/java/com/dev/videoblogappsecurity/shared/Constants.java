package com.dev.videoblogappsecurity.shared;

public class Constants {

    //HTTP CODES
    public static final int HTTP_CODE_NOT_FOUND=404;
    public static final int HTTP_CODE_JWT_EXPIRED = 512;


    //CODES
    public static final int CODE_WHEN_EXCEPTION_FETCHING_SECRET=513;
    public static final int CODE_WHEN_USER_ALREADY_EXISTS=514;
    public static final int CODE_WHEN_EXCEPTION_SAVING_USER=515;


    //GENERAL MESSAGES
    public static final String ERROR_MESSAGE_WHEN_INCORRECT_PASS="Password incorrecto";
    public static final String ERROR_MESSAGE_WHEN_INCORRECT_REQUEST="Error en el request";
    public static final String ERROR_MESSAGE_WHEN_CLIENTE_DOES_NOT_EXIST= "Cliente no existe";
    public static final String ERROR_MESSAGE_WHEN_CLIENTE_ALREADY_EXISTS= "Cliente ya existe";
    public static final String ERROR_MESSAGE_WHEN_JWT_EXPIRED= "Json Web token has expired";
    public static final String SUCCESS_MESSAGE = "Registro satisfactorio";
}
