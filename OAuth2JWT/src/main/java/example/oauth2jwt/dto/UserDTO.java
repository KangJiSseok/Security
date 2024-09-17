package example.oauth2jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserDTO {

    private String username;
    private String name;
    private String role;

    public UserDTO(String username, String name, String role) {
        this.username = username;
        this.name = name;
        this.role = role;
    }
}
