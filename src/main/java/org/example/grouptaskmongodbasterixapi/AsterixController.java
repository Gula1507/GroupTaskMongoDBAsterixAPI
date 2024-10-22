package org.example.grouptaskmongodbasterixapi;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asterix/characters")

public class AsterixController {
    private final CharacterService characterService;

    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }

//    implement a endpoint in the AsterixController that returns a Character based on its id.

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
        return characterService.getCharacterById(id);
    }

//    implement a endpoint in the AsterixController that deletes a Character based on its id.

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterService.deleteById(id);
    }

    @PostMapping("/create")
    public Character createCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.create(characterDTO);
    }

//    implement a endpoint in the AsterixController that updates a Character based on its id.

    @PutMapping("/{id}")
    public void updateCharacter(@PathVariable String id, @RequestBody Character character) {
        Optional<Character> existingCharacter = characterService.findById(id);
        if (existingCharacter.isPresent()) {
            characterService.save(character);
        }

    }

    //Bonus 21.10
    @GetMapping
    public List<Character> getCharacters(@RequestParam(required = false) String profession,
                                         @RequestParam(required = false) Integer age) {
        if (profession != null && age != null) {
            return characterService.findByProfessionAndAge(profession, age);
        } else if (profession != null) {
            return characterService.findByProfession(profession);
        } else if (age != null) {
            return characterService.findByAge(age);
        } else {
            return characterService.findAll();
        }
    }

}
