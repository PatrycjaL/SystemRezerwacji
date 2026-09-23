package pl.landas.systemrezerwacji.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.landas.systemrezerwacji.service.UslugaService;

@RestController
@RequestMapping("/uslugi")
public class UslugaController {
    private final UslugaService uslugaService;

    public UslugaController(UslugaService uslugaService) {
        this.uslugaService = uslugaService;
    }
}
