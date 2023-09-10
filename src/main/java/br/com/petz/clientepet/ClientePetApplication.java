package br.com.petz.clientepet;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@SpringBootApplication
public class ClientePetApplication {
    @GetMapping
    public String getHomeTeste() {
        return "Cliete - Pet - API - Home";
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientePetApplication.class, args);
    }

}
