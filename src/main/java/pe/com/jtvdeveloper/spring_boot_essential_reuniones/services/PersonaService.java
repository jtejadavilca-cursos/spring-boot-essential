package pe.com.jtvdeveloper.spring_boot_essential_reuniones.services;

import org.springframework.stereotype.Service;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.data.PersonaRepository;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Persona;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return this.personaRepository.findAll();
    }

    public Optional<Persona> getById(Long id) {
        return this.personaRepository.findById(id);
    }
}
