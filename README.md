# System Rezerwacji Usług

Projekt aplikacji do zarządzania rezerwacjami usług, realizowany w ramach praktyk studenckich na kierunku Informatyka.

Celem projektu jest stworzenie systemu umożliwiającego małym firmom i jednoosobowym działalnościom gospodarczym zarządzanie usługami, pracownikami, dostępnością oraz rezerwacjami klientów.

## Technologie

Projekt tworzony jest z wykorzystaniem:

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- Maven
- REST API
- SQL
- Git
- GitHub

## Aktualnie zrealizowane funkcjonalności

### Rejestracja właściciela

System umożliwia rejestrację właściciela firmy.

Podczas rejestracji:

- sprawdzana jest poprawność przekazanych danych,
- sprawdzana jest unikalność adresu e-mail,
- hasło jest bezpiecznie hashowane,
- tworzony jest użytkownik będący właścicielem firmy.

### Zarządzanie firmą

Właściciel może zarządzać danymi swojej firmy.

Zaimplementowano między innymi:

- tworzenie firmy,
- pobieranie danych firmy,
- pobieranie firm należących do właściciela,
- edycję danych firmy,
- dezaktywację firmy.

### REST API

Aplikacja posiada kontrolery REST odpowiedzialne za komunikację z systemem.

W projekcie wykorzystywane są między innymi metody HTTP:

- GET
- POST
- PUT
- DELETE

Odpowiedzi API wykorzystują odpowiednie kody statusów HTTP.

### Walidacja danych

Dane przesyłane do aplikacji są walidowane przed ich przetworzeniem.

Do komunikacji pomiędzy API a warstwą logiki biznesowej wykorzystywane są obiekty DTO.

### Obsługa błędów

Projekt posiada mechanizm obsługi wyjątków pozwalający na zwracanie czytelnych informacji o błędach występujących podczas wykonywania operacji.

## Struktura projektu

Kod aplikacji został podzielony na warstwy:

- `controller` – obsługa żądań HTTP i REST API,
- `service` – logika biznesowa aplikacji,
- `repository` – komunikacja z bazą danych,
- `model` – encje i modele danych,
- `dto` – obiekty służące do przesyłania danych,
- `exception` – obsługa wyjątków,
- `config` – konfiguracja aplikacji.

Taki podział pozwala zachować czytelną strukturę projektu oraz oddzielić poszczególne odpowiedzialności aplikacji.

## Planowane funkcjonalności

Projekt będzie dalej rozwijany. Planowane jest dodanie między innymi:

- zarządzania pracownikami,
- zarządzania usługami,
- określania dostępności pracowników,
- obsługi przedziałów czasowych i slotów,
- tworzenia rezerwacji przez klientów,
- sprawdzania konfliktów terminów,
- zmiany i anulowania rezerwacji,
- historii zmian statusów rezerwacji,
- powiadomień e-mail,
- tokenów umożliwiających klientowi zarządzanie rezerwacją bez zakładania konta,
- testów automatycznych.

## Kontrola wersji

Projekt rozwijany jest z wykorzystaniem systemu kontroli wersji Git oraz platformy GitHub.

Poszczególne funkcjonalności tworzone są na osobnych gałęziach, a następnie łączone z główną gałęzią projektu za pomocą Pull Requestów.

Historia commitów przedstawia kolejne etapy rozwoju aplikacji.

## Status projektu

Projekt jest w trakcie rozwoju.

Aktualna wersja obejmuje podstawową architekturę aplikacji, rejestrację właściciela oraz zarządzanie firmą poprzez REST API.

Projekt został rozpoczęty w ramach praktyk studenckich i będzie dalej rozwijany po ich zakończeniu.
