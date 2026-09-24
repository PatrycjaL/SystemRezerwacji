package pl.landas.systemrezerwacji.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.landas.systemrezerwacji.dto.FirmaRequest;
import pl.landas.systemrezerwacji.dto.FirmaResponse;
import pl.landas.systemrezerwacji.dto.FirmaUpdateRequest;
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
        FirmaResponse response = mapujNaResponse(firma);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public List<FirmaResponse> pobierzFirmyWlasciciela(@RequestParam Long wlascicielId) {
        return firmaService.pobierzFirmyWlasciciela(wlascicielId).stream()
                .map(firma -> mapujNaResponse(firma))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FirmaResponse> pobierzFirmePoId(@PathVariable Long id) {
        Firma firma = firmaService.pobierzFirmePoId(id);
        FirmaResponse response = mapujNaResponse(firma);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FirmaResponse> edytujFirme(@PathVariable Long id, @Valid @RequestBody FirmaUpdateRequest request) {
        Firma firma = firmaService.edytujFirme(id, request);
        FirmaResponse response = mapujNaResponse(firma);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FirmaResponse> dezaktywujFirme(@PathVariable Long id) {
        Firma firma = firmaService.dezaktywujFirme(id);
        FirmaResponse response = mapujNaResponse(firma);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    private FirmaResponse mapujNaResponse(Firma firma) {
        return new FirmaResponse(
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
    }
}
