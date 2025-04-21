package rocks.zipcode.piro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rocks.zipcode.piro.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
