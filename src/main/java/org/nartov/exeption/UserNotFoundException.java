package org.nartov.exeption;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long userId) {
        super("User not found with id: "  + userId);
    }
}
