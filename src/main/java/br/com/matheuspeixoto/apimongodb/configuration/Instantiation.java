package br.com.matheuspeixoto.apimongodb.configuration;

import br.com.matheuspeixoto.apimongodb.repository.UserRepository;
import br.com.matheuspeixoto.apimongodb.web.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;

    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        User maria = User.builder().name("Maria Brown").email("maria@gmail.com").build();
        User alex = User.builder().name("Alex Green").email("alex@gmail.com").build();
        User bob = User.builder().name("Bob Grey").email("bob@gmail.com").build();
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
