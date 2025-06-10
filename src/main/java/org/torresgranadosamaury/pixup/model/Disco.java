package org.torresgranadosamaury.pixup.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "TBL_DISCO")
public class Disco extends Catalogo {

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "PRECIO", nullable = false)
    private Float precio;

    @Column(name = "EXISTENCIA", nullable = false)
    private Integer existencia;

    @Column(name = "DESCUENTO", nullable = false)
    private Float descuento;

    @Column(name = "FECHA_LANZAMIENTO", nullable = false)
    private LocalDate fechaLanzamiento;

    @Column(name = "IMAGEN", nullable = false, length = 255)
    private String imagen;

    @Column(name = "TBL_ARTISTA_ID", nullable = false)
    private Integer idArtista;

    @Column(name = "TBL_DISQUERA_ID", nullable = false)
    private Integer idDisquera;

    @Column(name = "TBL_GENERO_MUSICAL_ID", nullable = false)
    private Integer idGeneroMusical;
}
