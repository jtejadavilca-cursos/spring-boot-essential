package pe.com.jtvdeveloper.spring_boot_essential_reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
