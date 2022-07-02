package br.com.matheuspeixoto.apimongodb.dto;

import br.com.matheuspeixoto.apimongodb.web.domain.User;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * DTO class.
 *
 * @author mathe
 */
@Data
public class UserDto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id private String id;
  private String name;
  private String email;

  /**
   * Constructor responsible for making the map from User to UserDto.
   *
   * @param user Type: User
   */
  public UserDto(User user) {
    id = user.getId();
    name = user.getName();
    email = user.getEmail();
  }
}
