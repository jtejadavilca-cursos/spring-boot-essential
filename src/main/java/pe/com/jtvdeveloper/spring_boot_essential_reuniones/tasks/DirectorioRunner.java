package pe.com.jtvdeveloper.spring_boot_essential_reuniones.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.PersonaService;

@Slf4j
@Order(1)
@Component
public class DirectorioRunner implements CommandLineRunner {
    @Autowired
    private PersonaService personaService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Directorio de personas");
        this.personaService.getAllPersonas()
                .forEach(persona -> log.info(persona.toString()));
        log.info("Fin del directorio de personas");
    }
}
