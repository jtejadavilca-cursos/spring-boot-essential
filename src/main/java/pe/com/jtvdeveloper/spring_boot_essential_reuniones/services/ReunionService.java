package pe.com.jtvdeveloper.spring_boot_essential_reuniones.services;

import org.springframework.stereotype.Service;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.data.ReunionRepository;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Reunion;

import java.util.List;
import java.util.Optional;

@Service
public class ReunionService {
    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones() {
        return this.reunionRepository.findAll();
    }

    public Optional<Reunion> getById(Long id) {
        return this.reunionRepository.findById(id);
    }
}
