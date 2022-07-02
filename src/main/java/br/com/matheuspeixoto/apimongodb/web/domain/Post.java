package br.com.matheuspeixoto.apimongodb.web.domain;

import br.com.matheuspeixoto.apimongodb.dto.AuthorDto;
import br.com.matheuspeixoto.apimongodb.dto.CommentDto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Post implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id private String id;
  private Date date;
  private String title;
  private String body;
  private AuthorDto author;
  private List<CommentDto> comments;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Post post = (Post) o;
    return Objects.equals(id, post.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
