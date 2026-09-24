package pl.landas.systemrezerwacji.service;

import org.springframework.stereotype.Service;
import pl.landas.systemrezerwacji.dto.FirmaRequest;
import pl.landas.systemrezerwacji.exception.WlascicielNieIstniejeException;
import pl.landas.systemrezerwacji.model.Firma;
import pl.landas.systemrezerwacji.model.Wlasciciel;
import pl.landas.systemrezerwacji.repository.FirmaRepository;
import pl.landas.systemrezerwacji.repository.WlascicielRepository;


@Service
public class FirmaService {

    private final FirmaRepository firmaRepository;
    private final WlascicielRepository wlascicielRepository;

    public FirmaService(FirmaRepository firmaRepository, WlascicielRepository wlascicielRepository) {
        this.firmaRepository = firmaRepository;
        this.wlascicielRepository = wlascicielRepository;
    }

    public Firma dodajFirme(FirmaRequest request) {
        Wlasciciel wlasciciel = wlascicielRepository
                .findById(request.wlascicielId())
                .orElseThrow(() -> new WlascicielNieIstniejeException("Właściciel o podanym ID nie istnieje."));

        Firma firma = new Firma(
                request.nazwaFirmy(),
                request.adresFirmy(),
                request.nipFirmy(),
                request.telefonFirmy(),
                request.emailFirmy(),
                wlasciciel,
                request.trybDzialaniaFirmy()

        );
            return firmaRepository.save(firma);
    }
}
