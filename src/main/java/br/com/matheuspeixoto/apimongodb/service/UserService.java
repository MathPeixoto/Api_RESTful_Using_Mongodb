package br.com.matheuspeixoto.apimongodb.service;

import br.com.matheuspeixoto.apimongodb.repository.UserRepository;
import br.com.matheuspeixoto.apimongodb.service.exception.ObjectNotFoundException;
import br.com.matheuspeixoto.apimongodb.web.domain.User;
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

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
