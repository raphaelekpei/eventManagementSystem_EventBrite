package com.raphael.eventmanagementsystem_eventbrite.data.model;

import com.raphael.eventmanagementsystem_eventbrite.Enum.Category;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Event {
    private String eventId;
    private String theme;
    private String location;
    private Category category;

}
