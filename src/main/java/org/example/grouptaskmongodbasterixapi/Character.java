package org.example.grouptaskmongodbasterixapi;

import lombok.Builder;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@With
@Document(collection = "asterixCharacter")
public record Character(
        @Id String id,
        String name,
        int age,
        String profession
) {

}
