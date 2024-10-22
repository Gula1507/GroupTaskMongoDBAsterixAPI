package org.example.grouptaskmongodbasterixapi;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record CharacterDTO(
        String name,
        int age,
        String profession

) {
}
