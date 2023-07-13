package utp.edu.co.ZonasPromisorias.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "finca")
public class FincaEntity {
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

    @Column(name = "imagen_finca")
    private String imagenFinca;

    @Column(name = "observaciones_finca")
    private String observacionesFinca;

    @ManyToOne
    @JoinColumn(name = "nit_productor", foreignKey = @ForeignKey(name = "fk_finca_productor"))
    private ProductorEntity productor;

}
