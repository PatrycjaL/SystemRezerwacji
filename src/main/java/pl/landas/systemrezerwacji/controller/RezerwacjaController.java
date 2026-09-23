package pl.landas.systemrezerwacji.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.landas.systemrezerwacji.model.Rezerwacja;
import pl.landas.systemrezerwacji.service.RezerwacjaService;

import java.util.List;

@RestController
@RequestMapping("/rezerwacje")
public class RezerwacjaController {

    private final RezerwacjaService rezerwacjaService;

    public RezerwacjaController(RezerwacjaService rezerwacjaService) {
        this.rezerwacjaService = rezerwacjaService;
    }

    @GetMapping
    public List<Rezerwacja> pobierzWszystkieRezerwacje() {
        return List.of();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> pobierzRezerwacjePoId(@PathVariable int id) {
        if (!rezerwacjaService.czyRezerwacjaIstnieje(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Nie znaleziono rezerwacji o ID: " + id);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Znaleziono rezerwację o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> dodajRezerwacje(@RequestBody String dane) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Otrzymano dane: " + dane);
    }

}
