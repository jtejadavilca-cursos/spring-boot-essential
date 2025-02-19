package pe.com.jtvdeveloper.spring_boot_essential_reuniones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public String getAllPersonas(Model model) {
        model.addAttribute("personas", this.personaService.getAllPersonas());
        return "personas";
    }
}
