package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
        if (userMailExist || userNickNameExist) {
            return ("Podany login lub email jest już zarejestrowany.");
        } else {
            registerRepository.save(register);
            String alertMessage = "Rejestracja zakończona sukcesem!";
            return alertMessage;
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
            return "Zalogowano pomyślnie";
        } else {
            // Użytkownik nie istnieje, wyświetl odpowiedni komunikat błędu
            return "Nieprawidłowy login lub hasło";
        }
    }

    // @GetMapping("/")
    public RedirectView redirectToWelcomePage() {
        // Przekierowanie na inny adres
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/welcomePage_V2.html"); // Adres, na który zostanie przekierowana strona
        return redirectView;
    }


    @GetMapping("/welcomePage_V1")
    public String welcomePage() {
        return "welcomePage";
    }

    // @GetMapping("/calculator")
    // public String example(@RequestBody Calculator calculator, Model model) {
    //     double value = calculator.getCarBid();
    //     model.addAttribute("doubleValue", value);
    //     model.addAttribute("doubleValueOutput", value);
    //     return "example"; // Nazwa widoku HTML
    // }

    @GetMapping("/calculator")
    public String welcomePage(Model model) {
        double doubleValue = 3.14; // Przykładowa wartość double
        model.addAttribute("doubleValue", doubleValue); // Przekazanie wartości do modelu

        return "calculator";
    }
}
