package br.com.matheuspeixoto.apimongodb.configuration;

import br.com.matheuspeixoto.apimongodb.dto.AuthorDto;
import br.com.matheuspeixoto.apimongodb.dto.CommentDto;
import br.com.matheuspeixoto.apimongodb.repository.PostRepository;
import br.com.matheuspeixoto.apimongodb.repository.UserRepository;
import br.com.matheuspeixoto.apimongodb.web.domain.Post;
import br.com.matheuspeixoto.apimongodb.web.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        User maria = User.builder().name("Maria Brown").email("maria@gmail.com").build();
        User alex = User.builder().name("Alex Green").email("alex@gmail.com").build();
        User bob = User.builder().name("Bob Grey").email("bob@gmail.com").build();
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        postRepository.deleteAll();
        Post postOne = Post.builder()
                .id(null)
                .date(simpleDateFormat.parse("21/03/2018"))
                .title("On a trip")
                .body("I'm going to travel to Sao Paulo. Regards")
                .author(new AuthorDto(maria))
                .build();
        Post postTwo = Post.builder()
                .id(null)
                .date(simpleDateFormat.parse("23/03/2018"))
                .title("Good Morning")
                .body("I woke up happy today!")
                .author(new AuthorDto(maria))
                .build();

        CommentDto commentOne = CommentDto.builder()
                .text("Good trip, bro")
                .date(simpleDateFormat.parse("21/03/2018"))
                .authorDto(new AuthorDto(alex))
                .build();
        CommentDto commentTwo = CommentDto.builder()
                .text("Enjoy")
                .date(simpleDateFormat.parse("22/03/2018"))
                .authorDto(new AuthorDto(bob))
                .build();
        CommentDto commentThree = CommentDto.builder()
                .text("Have a nice day")
                .date(simpleDateFormat.parse("23/03/2018"))
                .authorDto(new AuthorDto(alex))
                .build();

        postOne.setComments(Arrays.asList(commentOne, commentTwo));
        postTwo.setComments(Collections.singletonList(commentThree));

        postRepository.saveAll(Arrays.asList(postOne, postTwo));

        maria.setPosts(Arrays.asList(postOne, postTwo));
        userRepository.save(maria);
    }
}
