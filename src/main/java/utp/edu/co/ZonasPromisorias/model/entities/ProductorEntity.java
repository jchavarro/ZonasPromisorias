package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "productor")
public class ProductorEntity implements Serializable {
    @Id
    @Column(name = "nit_productor")
    private Integer nitProductor;
    @Column(name = "nombre_productor")
    private String nombreProductor;
    @Column(name = "apellidos_productor")
    private String apellidosProductor;
    @Column(name = "direccion_productor")
    private String direccionProductor;
    @Column(name = "telefono_productor")
    private String telefonoProductor;
    @Column(name = "imagen_productor")
    private String imagenProductor;
    @Column(name = "observaciones_productor")
    private String observacionesProductor;
    @OneToMany(mappedBy = "productor")
    private List<AsociacionProductorEntity> asociacionProductor;
}
