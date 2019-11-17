package br.com.matheuspeixoto.apimongodb.web.resources;

import br.com.matheuspeixoto.apimongodb.dto.UserDto;
import br.com.matheuspeixoto.apimongodb.service.UserService;
import br.com.matheuspeixoto.apimongodb.web.domain.Post;
import br.com.matheuspeixoto.apimongodb.web.domain.User;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserResources {
  private final UserService userService;

  public UserResources(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> findAll() {
    List<User> userList = userService.findAll();
    List<UserDto> userDtoList = userList.stream().map(UserDto::new).collect(Collectors.toList());
    return new ResponseEntity<>(userDtoList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> findById(@PathVariable String id) {
    UserDto userDTO = new UserDto(userService.findById(id));
    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDto userDTO) {
    User user = userService.fromDTO(userDTO);
    user = userService.insert(user);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody UserDto userDTO, @PathVariable String id) {
    User user = userService.fromDTO(userDTO);
    user.setId(id);
    userService.update(user);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{id}/posts")
  public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
    User user = userService.findById(id);
    return new ResponseEntity<>(user.getPosts(), HttpStatus.OK);
  }
}
