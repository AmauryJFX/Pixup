package org.torresgranadosamaury.pixup.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "TBL_GENERO_MUSICAL")
public class GeneroMusical extends Catalogo {

    @Column(name = "DESCRIPCION", length = 20, nullable = false)
    private String descripcion;
}
