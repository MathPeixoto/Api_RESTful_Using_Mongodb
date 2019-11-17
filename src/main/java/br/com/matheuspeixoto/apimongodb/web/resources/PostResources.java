package br.com.matheuspeixoto.apimongodb.web.resources;

import br.com.matheuspeixoto.apimongodb.service.PostService;
import br.com.matheuspeixoto.apimongodb.web.domain.Post;
import br.com.matheuspeixoto.apimongodb.web.resources.util.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResources {
    private final PostService postService;

    public PostResources(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = Url.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
