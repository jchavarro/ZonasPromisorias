package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "finca")
public class FincaEntity implements Serializable {
    @Id
    @Column(name = "id_catastral")
    private Integer idCatastral;

    @Column(name = "nombre_finca")
    private String nombreFinca;

    @Column(name = "ubicacion_finca")
    private String ubicacionFinca;

    @Column(name = "direccion_finca")
    private String direccionFinca;

    @Column(name = "hectareas_finca")
    private String hectareasFinca;

    @Column(name = "nombre_imagen")
    private String nombreImagen;

    @Column(name = "tipo_imagen")
    private String tipoImagen;

    @Column(name = "datos_imagen_finca")
    private byte[] datosImagenFinca;

    @Column(name = "observaciones_finca")
    private String observacionesFinca;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "id.finca", orphanRemoval = true)
    private List<LoteEntity> lotes;

    @ManyToOne
    @JoinColumn(name = "nit_productor", foreignKey = @ForeignKey(name = "fk_finca_productor"))
    private ProductorEntity productor;

}
