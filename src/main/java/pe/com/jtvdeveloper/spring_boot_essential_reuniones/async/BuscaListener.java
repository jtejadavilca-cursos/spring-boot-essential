package pe.com.jtvdeveloper.spring_boot_essential_reuniones.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Persona;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Reunion;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.PersonaService;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.services.ReunionService;

import java.util.Optional;

@Slf4j
@Component
public class BuscaListener {
    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String mensaje) {
        try {
            InfoBusca infoBusca = mapper.readValue(mensaje, InfoBusca.class);
            Optional<Persona> persona = personaService.getById(infoBusca.getIdAsistente());

            if(persona.isEmpty()) {
                log.warn("Persona {} no encontrada", infoBusca.getIdAsistente());
            }

            Optional<Reunion> reunion = reunionService.getById(infoBusca.getIdReunion());

            if(reunion.isEmpty()) {
                log.warn("Reunión {} no encontrada", infoBusca.getIdReunion());
            }
            if(persona.isEmpty() || reunion.isEmpty()) {
                return;
            }

            log.info("{} {} tiene una reunión a las {}", persona.get().getNombre(), persona.get().getApellidos(), reunion.get().getFecha());
        } catch (JsonProcessingException e) {
            log.warn("Mensaje incorrecto", e);
        }
    }
}
