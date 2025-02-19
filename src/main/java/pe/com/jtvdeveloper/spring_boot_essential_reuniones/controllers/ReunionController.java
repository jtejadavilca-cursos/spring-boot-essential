package pe.com.jtvdeveloper.spring_boot_essential_reuniones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Persona;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Reunion;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.ReunionService;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {

    private final ReunionService reunionService;

    public ReunionController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }

    @GetMapping
    public String getAllReuniones(Model model) {
        model.addAttribute("reuniones", this.reunionService.getAllReuniones());
        return "reuniones";
    }
}
