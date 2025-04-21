package rocks.zipcode.piro.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Piro entity.
 * Used to transfer Piro data between layers, especially for API responses,
 * decoupling the API representation from the database entity.
 */
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates no-args constructor
@AllArgsConstructor // Generates all-args constructor
public class PiroDTO {

    private Long id;
    private String title;
    private String description;
    private String s3UrlToVideo;
    private String imageName;
    private String location;
    private LocalDateTime created;
    private Set<String> tagNames; // Simplified representation of associated tags (e.g., just names)
    private Long ownerId;         // Simplified representation of the owner (e.g., just the ID)
    // Optionally, you could include ownerUsername or a full UserDTO if needed

}