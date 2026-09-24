package pl.landas.systemrezerwacji.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.landas.systemrezerwacji.dto.UslugaRequest;
import pl.landas.systemrezerwacji.model.Usluga;
import pl.landas.systemrezerwacji.service.UslugaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uslugi")
public class UslugaController {
    private final UslugaService uslugaService;

    public UslugaController(UslugaService uslugaService) {
        this.uslugaService = uslugaService;
    }

    @PostMapping
    public ResponseEntity<Usluga> dodajUsluge(@Valid @RequestBody UslugaRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(uslugaService.dodajUsluge(request));
    }

    @GetMapping
    public List<Usluga> pobierzWszystkieUslugi() {
        return uslugaService.pobierzWszystkieUslugi();
    }

    @GetMapping("/aktywne")
    public List<Usluga> pobierzAktywneUslugi() {
        return uslugaService.pobierzAktywneUslugi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usluga> pobierzUslugePoId(@PathVariable Long id) {
        Optional<Usluga> usluga = uslugaService.pobierzUslugePoId(id);

        if (usluga.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usluga.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usluga> edytujUsluge(@PathVariable Long id, @Valid @RequestBody UslugaRequest request) {
        Optional<Usluga> zaktualizowanaUsluga = uslugaService.edytujUsluge(id, request);

        if (zaktualizowanaUsluga.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(zaktualizowanaUsluga.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usluga> dezaktywujUsluge(@PathVariable Long id) {
        Optional<Usluga> dezaktywowanaUsluga = uslugaService.dezaktywujUsluge(id);

        if (dezaktywowanaUsluga.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dezaktywowanaUsluga.get());
    }
}
