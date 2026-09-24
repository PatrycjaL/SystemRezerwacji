package pl.landas.systemrezerwacji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.landas.systemrezerwacji.model.Usluga;

import java.util.List;
import java.util.Optional;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
    List<Usluga> findByFirmaId(Long firmaId);
    List<Usluga> findByFirmaIdAndAktywna(Long firmaId, Boolean aktywna);
    Optional<Usluga> findByIdAndFirmaId(Long id, Long firmaId);
}
