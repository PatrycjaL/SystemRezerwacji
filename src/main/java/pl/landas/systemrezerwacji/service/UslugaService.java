package pl.landas.systemrezerwacji.service;

import org.springframework.stereotype.Service;
import pl.landas.systemrezerwacji.dto.UslugaRequest;
import pl.landas.systemrezerwacji.model.Firma;
import pl.landas.systemrezerwacji.model.Usluga;
import pl.landas.systemrezerwacji.repository.FirmaRepository;
import pl.landas.systemrezerwacji.repository.UslugaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UslugaService {

    private final UslugaRepository uslugaRepository;
    private final FirmaRepository firmaRepository;

    public UslugaService(UslugaRepository uslugaRepository, FirmaRepository firmaRepository) {
        this.uslugaRepository = uslugaRepository;
        this.firmaRepository = firmaRepository;
    }

    public Usluga dodajUsluge(Long firmaId, UslugaRequest request) {
        Optional<Firma> firma = firmaRepository.findById(firmaId);

        if (firma.isEmpty()) {
            throw new IllegalArgumentException("Firma o podanym ID nie istnieje.");
        }

        Usluga usluga = new Usluga(
                request.nazwa(),
                request.cena(),
                request.czasTrwania(),
                firma.get()
        );
        return uslugaRepository.save(usluga);
    }

    public List<Usluga> pobierzWszystkieUslugi(Long firmaId) {
        return uslugaRepository.findByFirmaId(firmaId);
    }

    public List<Usluga> pobierzAktywneUslugi(Long firmaId) {
        return uslugaRepository.findByFirmaIdAndAktywna(firmaId, true);
    }

    public Optional<Usluga> pobierzUslugePoId(Long firmaId, Long id) {
        return uslugaRepository.findByIdAndFirmaId(id, firmaId);
    }

    public Optional<Usluga> edytujUsluge(Long firmaId, Long id, UslugaRequest request) {
        Optional<Usluga> usluga = uslugaRepository.findByIdAndFirmaId(id, firmaId);

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

    public Optional<Usluga> dezaktywujUsluge(Long firmaId, Long id) {
        Optional<Usluga> usluga = uslugaRepository.findByIdAndFirmaId(id, firmaId);

        if (usluga.isPresent()) {
            Usluga istniejacaUsluga = usluga.get();
            istniejacaUsluga.dezaktywujUsluge();
            Usluga zapisanaUsluga = uslugaRepository.save(istniejacaUsluga);
            return Optional.of(zapisanaUsluga);
        }
        return Optional.empty();
    }
}
