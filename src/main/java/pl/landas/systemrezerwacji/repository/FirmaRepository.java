package pl.landas.systemrezerwacji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.landas.systemrezerwacji.model.Firma;

public interface FirmaRepository extends JpaRepository<Firma, Long> {
}
