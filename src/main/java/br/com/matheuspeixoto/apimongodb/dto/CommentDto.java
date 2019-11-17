package br.com.matheuspeixoto.apimongodb.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private String text;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private AuthorDto authorDto;
}
