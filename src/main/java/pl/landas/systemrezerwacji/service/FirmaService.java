package pl.landas.systemrezerwacji.service;

import org.springframework.stereotype.Service;
import pl.landas.systemrezerwacji.dto.FirmaRequest;
import pl.landas.systemrezerwacji.dto.FirmaUpdateRequest;
import pl.landas.systemrezerwacji.exception.FirmaNieIstniejeException;
import pl.landas.systemrezerwacji.exception.WlascicielNieIstniejeException;
import pl.landas.systemrezerwacji.model.Firma;
import pl.landas.systemrezerwacji.model.Wlasciciel;
import pl.landas.systemrezerwacji.repository.FirmaRepository;
import pl.landas.systemrezerwacji.repository.WlascicielRepository;

import java.util.List;


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

    public List<Firma> pobierzFirmyWlasciciela(Long wlascicielId) {
        return firmaRepository.findByWlascicielId(wlascicielId);
    }

    public Firma pobierzFirmePoId(Long firmaId) {
        return firmaRepository.findById(firmaId)
                .orElseThrow(() -> new FirmaNieIstniejeException("Firma o podanym ID nie istnieje."));
    }

    public Firma edytujFirme(Long firmaId, FirmaUpdateRequest request) {
        Firma firma = pobierzFirmePoId(firmaId);

        firma.setNazwaFirmy(request.nazwaFirmy());
        firma.setAdresFirmy(request.adresFirmy());
        firma.setNip(request.nipFirmy());
        firma.setNumerTelefonuFirmy(request.telefonFirmy());
        firma.setEmailFirmy(request.emailFirmy());
        firma.zmienTrybDzialaniaFirmy(request.trybDzialaniaFirmy());

        return firmaRepository.save(firma);
    }

    public Firma dezaktywujFirme(Long firmaId) {
        Firma firma = pobierzFirmePoId(firmaId);
        firma.dezaktywujFirme();
        return firmaRepository.save(firma);
    }
}
