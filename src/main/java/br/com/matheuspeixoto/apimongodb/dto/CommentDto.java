package br.com.matheuspeixoto.apimongodb.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class.
 *
 * @author mathe
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Getter @Setter private String text;
  @Getter @Setter private Date date;
  @Getter @Setter private AuthorDto authorDto;
}
