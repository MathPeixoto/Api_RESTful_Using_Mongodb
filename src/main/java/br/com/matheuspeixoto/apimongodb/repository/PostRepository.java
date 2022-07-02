package br.com.matheuspeixoto.apimongodb.repository;

import br.com.matheuspeixoto.apimongodb.web.domain.Post;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Post repository interface.
 *
 * @author mathe
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  /**
   * Method responsible for searching a post in mongodb by his title using a custom query.
   *
   * @param text Type: String. Is the title that is searched
   * @return A List of posts that contains the title required
   */
  @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);

  /**
   * It does the same thing that the method above, but using the method query name. This name is
   * available in the mongodb documentation.
   *
   * @param text Type: String. Title that is required.
   * @return A List of posts that contains the title required
   */
  List<Post> findByTitleContainingIgnoreCase(String text);

  /**
   * Method responsible for searching the posts that contains the text that was passed as parameter
   * and it's between a minimum date and a maximum date. The text can be in the title, body or
   * comments.
   *
   * @param text Type: String
   * @param minDate Type: Date
   * @param maxDate Type: Date
   * @return A List of Posts that has been found with the required parameters
   */
  @Query(
      "{ $and: [ {date: {$gte: ?1}},"
          + " {date: {$lte: ?2}},"
          + " {$or: [{ 'title': { $regex: ?0, $options: 'i' }},"
          + "{ 'body': { $regex: ?0, $options: 'i' }},"
          + "{ 'comments.text': { $regex: ?0, $options: 'i' }}"
          + "]"
          + "}"
          + "]"
          + "}") // ?0 = text, ?1 = minDate, ?2 = maxDate
  List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
