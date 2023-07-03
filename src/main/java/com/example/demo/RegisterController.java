package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class RegisterController {
    private final RegisterRepository registerRepository;

    public RegisterController(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody Register register) {

        //Odczyt z bazy czy rekordy juz istnieja
        boolean userMailExist = registerRepository.existsByUserMail(register.getUserMail());
        boolean userNickNameExist = registerRepository.existsByUserNickName(register.getUserNickName());

        // Zapis danych do bazy
        if (userMailExist || userNickNameExist){
            return ("Podany login lub email jest już zarejestrowany.");
        } else {
            registerRepository.save(register);

            String alertMessage = "Rejestracja zakończona sukcesem!";
            String redirectUrl = "/welcomePage_V1";

            return "redirect:" + redirectUrl + "?message=" + URLEncoder.encode(alertMessage, StandardCharsets.UTF_8);
        }

    }
    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        // Sprawdź, czy użytkownik o podanej nazwie użytkownika i haśle istnieje w bazie danych
        boolean validation = registerRepository.existsByUserMailAndUserPassword(login.getUserMail(), login.getUserPassword());
        System.out.println(validation);
        System.out.println(login.getUserMail());

        if (validation) {
            // Użytkownik istnieje, wykonaj odpowiednie akcje, np. zaloguj go
            System.out.println("welhu");
            return "redirect:/welcomePage_V1";
        } else {
            // Użytkownik nie istnieje, wyświetl odpowiedni komunikat błędu
            return "Nieprawidłowy login lub hasło";
        }
    }

    @GetMapping("/welcomePage_V1")
    public String welcomePage() {
        return "welcomePage";
    }
}
