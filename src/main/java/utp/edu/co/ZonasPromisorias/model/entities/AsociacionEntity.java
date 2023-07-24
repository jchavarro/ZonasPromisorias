package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asociacion")
public class AsociacionEntity implements Serializable {
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "asociaciones")
    private List<ProductorEntity> productores;
}