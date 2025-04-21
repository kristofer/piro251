package rocks.zipcode.piro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rocks.zipcode.piro.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
