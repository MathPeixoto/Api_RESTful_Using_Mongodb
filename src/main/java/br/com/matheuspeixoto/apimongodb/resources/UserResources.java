package br.com.matheuspeixoto.apimongodb.resources;

import br.com.matheuspeixoto.apimongodb.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = User.builder().id("1").name("Maria Brown").email("maria@gmail.com").build();
        User alex = User.builder().id("2").name("Alex Green").email("alex@gmail.com").build();
        return new ResponseEntity<>(Arrays.asList(maria, alex), HttpStatus.OK);
    }
}
