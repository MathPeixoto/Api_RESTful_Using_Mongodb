package br.com.matheuspeixoto.apimongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class.
 *
 * @author mathe
 */
@SpringBootApplication
public class ApiMongoApplication {

  /**
   * Entry point.
   *
   * @param args Type: Array of String
   */
  public static void main(String[] args) {
    SpringApplication.run(ApiMongoApplication.class, args);
  }
}
