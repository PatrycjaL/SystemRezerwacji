package pl.landas.systemrezerwacji.service;

import org.springframework.stereotype.Service;
import pl.landas.systemrezerwacji.dto.UslugaRequest;
import pl.landas.systemrezerwacji.model.Usluga;
import pl.landas.systemrezerwacji.repository.UslugaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UslugaService {

    private final UslugaRepository uslugaRepository;

    public UslugaService(UslugaRepository uslugaRepository) {
        this.uslugaRepository = uslugaRepository;
    }

    public Usluga dodajUsluge(UslugaRequest request) {

        Usluga usluga = new Usluga(
                request.nazwa(),
                request.cena(),
                request.czasTrwania()
        );
        return uslugaRepository.save(usluga);
    }

    public List<Usluga> pobierzWszystkieUslugi() {
        return uslugaRepository.findAll();
    }

    public List<Usluga> pobierzAktywneUslugi() {
        return uslugaRepository.findByAktywna(true);
    }

    public Optional<Usluga> pobierzUslugePoId(Long id) {
        return uslugaRepository.findById(id);
    }

    public Optional<Usluga> edytujUsluge(Long id, UslugaRequest request) {
        Optional<Usluga> usluga = uslugaRepository.findById(id);

        if (usluga.isPresent()) {
            Usluga istniejacaUsluga = usluga.get();
            istniejacaUsluga.setNazwa(request.nazwa());
            istniejacaUsluga.setCena(request.cena());
            istniejacaUsluga.setCzasTrwania(request.czasTrwania());
            Usluga zapisanaUsluga = uslugaRepository.save(istniejacaUsluga);
            return Optional.of(zapisanaUsluga);
        }
        return Optional.empty();
    }

    public Optional<Usluga> dezaktywujUsluge(Long id) {
        Optional<Usluga> usluga = uslugaRepository.findById(id);

        if (usluga.isPresent()) {
            Usluga istniejacaUsluga = usluga.get();
            istniejacaUsluga.dezaktywujUsluge();
            Usluga zapisanaUsluga = uslugaRepository.save(istniejacaUsluga);
            return Optional.of(zapisanaUsluga);
        }
        return Optional.empty();
    }
}
