package rocks.zipcode.piro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rocks.zipcode.piro.domain.Piro;

public interface PiroRepository extends JpaRepository<Piro, Long> {
}
