package pl.landas.systemrezerwacji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.landas.systemrezerwacji.model.Wlasciciel;

public interface WlascicielRepository extends JpaRepository<Wlasciciel, Long> {
    boolean existsByEmail(String email);
}
