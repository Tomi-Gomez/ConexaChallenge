package com.javaChallenge.apiStartWars.exception;

public class StarwarsNotFoundException extends RuntimeException{

    public StarwarsNotFoundException(String message) {
        super(message);
    }
}
