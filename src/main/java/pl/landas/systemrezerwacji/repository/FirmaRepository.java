package pl.landas.systemrezerwacji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.landas.systemrezerwacji.model.Firma;

import java.util.List;

public interface FirmaRepository extends JpaRepository<Firma, Long> {

    List<Firma> findByWlascicielId(Long wlascicielId);
}
