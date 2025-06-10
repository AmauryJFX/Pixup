package org.torresgranadosamaury.pixup.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "TBL_CANCION")
public class Cancion extends Catalogo {

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "DURACION", nullable = false)
    private Integer duracionSegundos;

    @Column(name = "TBL_DISCO_ID", nullable = false)
    private Integer idDisco;
}
