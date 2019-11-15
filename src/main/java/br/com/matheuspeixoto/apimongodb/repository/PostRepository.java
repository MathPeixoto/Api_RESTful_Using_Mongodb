package br.com.matheuspeixoto.apimongodb.repository;

import br.com.matheuspeixoto.apimongodb.web.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
