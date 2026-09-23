package pl.landas.systemrezerwacji.service;

import org.springframework.stereotype.Service;


@Service
public class RezerwacjaService {

    public boolean czyRezerwacjaIstnieje(int id) {
        if (id == 1) {
            return true;
        }
        return false;
    }


}
