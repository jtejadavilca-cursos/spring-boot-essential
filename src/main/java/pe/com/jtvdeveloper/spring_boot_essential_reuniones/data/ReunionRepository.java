package pe.com.jtvdeveloper.spring_boot_essential_reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jtvdeveloper.spring_boot_essential_reuniones.models.Reunion;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {
}
