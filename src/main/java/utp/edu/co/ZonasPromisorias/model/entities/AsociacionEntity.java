package utp.edu.co.ZonasPromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asociacion")
public class AsociacionEntity {
    @Id
    @Column(name = "nit_asociacion")
    private Integer nitAsociacion;

    @Column(name = "nombre_asociacion")
    private String nombreAsociacion;

    @Column(name = "direccion_asociacion")
    private String direccionAsociacion;

    @Column(name = "telefono_asociacion")
    private String telefonoAsociacion;

    @Column(name = "observaciones_asociacion")
    private String observacionesAsociacion;

    @OneToMany(mappedBy = "asociacion")
    List<AsociacionProductorEntity> asociacionProductor;
}