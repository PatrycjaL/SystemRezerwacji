package pl.landas.systemrezerwacji.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.landas.systemrezerwacji.dto.FirmaRequest;
import pl.landas.systemrezerwacji.dto.FirmaResponse;
import pl.landas.systemrezerwacji.model.Firma;
import pl.landas.systemrezerwacji.service.FirmaService;

import java.util.List;

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

    @GetMapping
    public List<FirmaResponse> pobierzFirmyWlasciciela(@RequestParam Long wlascicielId) {
        return firmaService.pobierzFirmyWlasciciela(wlascicielId).stream()
                .map(firma -> new FirmaResponse(
                        firma.getId(),
                        firma.getNazwaFirmy(),
                        firma.getAdresFirmy(),
                        firma.getNip(),
                        firma.getNumerTelefonuFirmy(),
                        firma.getEmailFirmy(),
                        firma.isAktywna(),
                        firma.getWlasciciel().getId(),
                        firma.getTrybDzialaniaFirmy()
                ))
                .toList();
    }
}
