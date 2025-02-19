package pe.com.jtvdeveloper.spring_boot_essential_reuniones.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "asistentes")
@Entity
@Table(name = "reunion")
public class Reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String asunto;
    private ZonedDateTime fecha;

    @ManyToMany
    @JoinTable(
            name = "asistente",
            joinColumns = @JoinColumn(name = "reunion_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<Persona> asistentes;

    public void addAsistente(Persona persona) {
//

    }
}
