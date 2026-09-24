package pl.landas.systemrezerwacji.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.landas.systemrezerwacji.dto.WlascicielRequest;
import pl.landas.systemrezerwacji.dto.WlascicielResponse;
import pl.landas.systemrezerwacji.model.Wlasciciel;
import pl.landas.systemrezerwacji.service.WlascicielService;

@RestController
@RequestMapping("/wlasciciele")
public class WlascicielController {

    private final WlascicielService wlascicielService;

    public WlascicielController(WlascicielService wlascicielService) {
        this.wlascicielService = wlascicielService;
    }

    @PostMapping
    public ResponseEntity<WlascicielResponse> dodajWlasciciela(@Valid @RequestBody WlascicielRequest request) {
        Wlasciciel wlasciciel = wlascicielService.dodajWlasciciela(request);
        WlascicielResponse response = new WlascicielResponse(
                wlasciciel.getId(),
                wlasciciel.getImie(),
                wlasciciel.getNazwisko(),
                wlasciciel.getEmail()
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }
}