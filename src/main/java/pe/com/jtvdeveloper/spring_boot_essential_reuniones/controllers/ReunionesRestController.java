package pe.com.jtvdeveloper.spring_boot_essential_reuniones.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Reunion;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.ReunionService;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionesRestController {

    private final ReunionService reunionService;

    public ReunionesRestController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }

    @GetMapping
    public List<Reunion> getAllReuniones() {
        return this.reunionService.getAllReuniones();
    }
}
