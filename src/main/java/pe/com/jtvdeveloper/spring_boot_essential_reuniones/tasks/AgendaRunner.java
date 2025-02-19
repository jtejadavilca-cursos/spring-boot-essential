package pe.com.jtvdeveloper.spring_boot_essential_reuniones.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.ReunionService;

@Slf4j
@Order(2)
@Component
public class AgendaRunner implements ApplicationRunner {
    @Autowired
    private ReunionService reunionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Agenda de reuniones");
        this.reunionService.getAllReuniones()
                .forEach(reunion -> log.info(reunion.toString()));
        log.info("Fin de la agenda de reuniones");
    }
}
