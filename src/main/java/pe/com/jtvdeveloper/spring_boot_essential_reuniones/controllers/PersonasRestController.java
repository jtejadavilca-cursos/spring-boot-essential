package pe.com.jtvdeveloper.spring_boot_essential_reuniones.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Persona;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonasRestController {

    private final PersonaService personaService;

    public PersonasRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return this.personaService.getAllPersonas();
    }
}
