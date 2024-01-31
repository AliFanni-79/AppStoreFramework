package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String userId;
    private String username;
    private String email;
    private String password; // Hashed and salted for security

    // Constructors, getters, setters, and additional methods
}
