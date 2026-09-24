package pl.landas.systemrezerwacji.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.landas.systemrezerwacji.dto.FirmaRequest;
import pl.landas.systemrezerwacji.dto.FirmaResponse;
import pl.landas.systemrezerwacji.model.Firma;
import pl.landas.systemrezerwacji.service.FirmaService;

@RestController
@RequestMapping("/firmy")
public class FirmaController {

    private final FirmaService firmaService;

    public FirmaController(FirmaService firmaService) {
        this.firmaService = firmaService;
    }

    @PostMapping
    public ResponseEntity<FirmaResponse> dodajFirme(@Valid @RequestBody FirmaRequest request) {
        Firma firma = firmaService.dodajFirme(request);
        FirmaResponse response = new FirmaResponse(
                firma.getId(),
                firma.getNazwaFirmy(),
                firma.getAdresFirmy(),
                firma.getNip(),
                firma.getNumerTelefonuFirmy(),
                firma.getEmailFirmy(),
                firma.isAktywna(),
                firma.getWlasciciel().getId(),
                firma.getTrybDzialaniaFirmy()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
