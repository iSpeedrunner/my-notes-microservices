package com.iSpeedrunner.notes_service.exception;


public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String message) {
        super(message);
    }
}
