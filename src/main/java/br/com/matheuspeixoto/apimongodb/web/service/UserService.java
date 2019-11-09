package br.com.matheuspeixoto.apimongodb.web.service;

import br.com.matheuspeixoto.apimongodb.domain.User;
import br.com.matheuspeixoto.apimongodb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
