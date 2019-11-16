package br.com.matheuspeixoto.apimongodb.dto;

import br.com.matheuspeixoto.apimongodb.web.domain.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
