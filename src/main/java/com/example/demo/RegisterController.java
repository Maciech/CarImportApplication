package com.example.demo;

import org.springframework.web.bind.annotation.*;

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
            return ("Zapisano dane do bazy.");
        }

    }
}
