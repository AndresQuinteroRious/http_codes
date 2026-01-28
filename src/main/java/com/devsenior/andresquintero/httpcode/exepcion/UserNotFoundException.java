package com.devsenior.andresquintero.httpcode.exepcion;



public class UserNotFoundException  extends RuntimeException{
public  UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException () {
      
        super("el usuario  no fue encontrado en el sistema");
   }
}
