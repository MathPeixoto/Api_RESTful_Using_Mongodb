package br.com.matheuspeixoto.apimongodb.repository;

import br.com.matheuspeixoto.apimongodb.web.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
