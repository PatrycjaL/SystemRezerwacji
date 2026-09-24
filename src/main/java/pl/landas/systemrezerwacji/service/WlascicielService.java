package pl.landas.systemrezerwacji.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.landas.systemrezerwacji.dto.WlascicielRequest;
import pl.landas.systemrezerwacji.exception.EmailJuzIstniejeException;
import pl.landas.systemrezerwacji.model.Wlasciciel;
import pl.landas.systemrezerwacji.repository.WlascicielRepository;

@Service
public class WlascicielService {

    private final WlascicielRepository wlascicielRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public WlascicielService(WlascicielRepository wlascicielRepository, BCryptPasswordEncoder passwordEncoder) {
        this.wlascicielRepository = wlascicielRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Wlasciciel dodajWlasciciela(WlascicielRequest request) {
        if(wlascicielRepository.existsByEmail(request.email())) {
            throw new EmailJuzIstniejeException("Właściciel z tym adresem e-mail już istnieje.");
        }

        String hashHasla = passwordEncoder.encode(request.haslo());

        Wlasciciel wlasciciel = new Wlasciciel(request.imie(), request.nazwisko(), request.email(), hashHasla);
        return wlascicielRepository.save(wlasciciel);
    }
}
