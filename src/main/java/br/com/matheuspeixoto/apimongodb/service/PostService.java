package br.com.matheuspeixoto.apimongodb.service;

import br.com.matheuspeixoto.apimongodb.repository.PostRepository;
import br.com.matheuspeixoto.apimongodb.service.exception.ObjectNotFoundException;
import br.com.matheuspeixoto.apimongodb.web.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> searchTitle(String text) {
        return postRepository.searchTitle(text);
    }
}
