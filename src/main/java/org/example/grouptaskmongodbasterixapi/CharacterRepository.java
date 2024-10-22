package org.example.grouptaskmongodbasterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends MongoRepository<Character, String> {
    List<Character> findByProfession(String profession);

    List<Character> findByAge(Integer age);

    List<Character> findByProfessionAndAge(String profession, Integer age);

    Optional<Character> getCharacterById(String id);

}