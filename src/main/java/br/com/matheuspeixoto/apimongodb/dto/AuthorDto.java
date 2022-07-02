package br.com.matheuspeixoto.apimongodb.dto;

import br.com.matheuspeixoto.apimongodb.web.domain.User;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO class.
 *
 * @author mathe
 */
public class AuthorDto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Getter @Setter private String id;
  @Getter @Setter private String name;

  /** Empty constructor, required for spring boot. */
  public AuthorDto() {}

  /**
   * Constructor responsible for making the map from User to AuthorDto class.
   *
   * @param user Type: User
   */
  public AuthorDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }
}
