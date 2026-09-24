package pl.landas.systemrezerwacji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.landas.systemrezerwacji.model.Usluga;

import java.util.List;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
    List<Usluga> findByAktywna(Boolean aktywna);
}
