package pl.landas.systemrezerwacji.service;

import org.springframework.stereotype.Service;
import pl.landas.systemrezerwacji.model.Usluga;
import pl.landas.systemrezerwacji.repository.UslugaRepository;

@Service
public class UslugaService {

    private final UslugaRepository uslugaRepository;

    public UslugaService(UslugaRepository uslugaRepository) {
        this.uslugaRepository = uslugaRepository;
    }

    public Usluga dodajUsluge(Usluga usluga) {
        return uslugaRepository.save(usluga);
    }
}
