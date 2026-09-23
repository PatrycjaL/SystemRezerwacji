package pl.landas.systemrezerwacji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.landas.systemrezerwacji.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
}
