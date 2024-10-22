package org.example.grouptaskmongodbasterixapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterService {
    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> findByProfessionAndAge(String profession, Integer age) {
        return repository.findByProfessionAndAge(profession, age);
    }

    public List<Character> findByProfession(String profession) {
        return repository.findByProfession(profession);
    }

    public List<Character> findByAge(Integer age) {
        return repository.findByAge(age);
    }

    public List<Character> findAll() {
        return repository.findAll();
    }

    public void save(Character character) {
        repository.save(character);
    }

    public Optional<Character> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Character create(CharacterDTO characterDTO) {
        Character newCharacter = Character.builder().id(UUID.randomUUID().toString())
                .name(characterDTO.name())
                .age(characterDTO.age())
                .profession(characterDTO.profession()).build();
        repository.save(newCharacter);
        return newCharacter;
    }

    public Character getCharacterById(String id) {
        return repository.getCharacterById(id).
                orElseThrow(() -> new RuntimeException("There is no character with this id: " + id));
    }
}
