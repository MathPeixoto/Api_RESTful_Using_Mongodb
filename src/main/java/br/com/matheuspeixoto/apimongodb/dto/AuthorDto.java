package br.com.matheuspeixoto.apimongodb.dto;

import br.com.matheuspeixoto.apimongodb.web.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
