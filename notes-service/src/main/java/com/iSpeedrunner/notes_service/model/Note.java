package com.iSpeedrunner.notes_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
    private String roomId;
}
