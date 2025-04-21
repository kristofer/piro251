package rocks.zipcode.piro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rocks.zipcode.piro.domain.Piro;
import rocks.zipcode.piro.domain.User;
import rocks.zipcode.piro.dto.PiroDTO;
import rocks.zipcode.piro.repository.PiroRepository;

@Service
public class PiroService {
    @Autowired
    private PiroRepository piroRepository;

     @Transactional(readOnly = true) // Good practice for read operations
    public List<PiroDTO> findAllDTOs() {
        return piroRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    private PiroDTO mapToDTO(Piro piro) {
        PiroDTO dto = new PiroDTO();
        dto.setId(piro.getId());
        dto.setTitle(piro.getTitle()); // Map title
        dto.setDescription(piro.getDescription()); // Map description
        dto.setS3UrlToVideo(piro.getS3UrlToVideo()); // Map video URL
        dto.setImageName(piro.getImageName()); // Map image name
        dto.setLocation(piro.getLocation()); // Map location
        dto.setCreated(piro.getCreated()); // Map creation timestamp

        // Ensure tags are loaded before mapping
        // Check if tags collection is initialized (might be null if not loaded and no @Data on Piro)
        // if (piro.getTags() != null) {
        //     dto.setTagNames(piro.getTags().stream()
        //                         .map(Tag::getName) // Assuming Tag has getName()
        //                         .collect(Collectors.toSet()));
        // } else {
            dto.setTagNames(java.util.Collections.emptySet()); // Assign empty set if tags are null
//        }


        // Map owner ID, handling potential null owner
        User owner = piro.getOwner(); // Get the owner User object
        if (owner != null) {
            dto.setOwnerId(owner.getId()); // Assuming User has getId()
        } else {
            dto.setOwnerId(null); // Set ownerId to null if Piro has no owner
        }

        return dto;
    }

    public Piro save(Piro piro) {
        return piroRepository.save(piro);
    }

    public void deleteById(Long id) {
        piroRepository.deleteById(id);
    }
}
