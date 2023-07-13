package utp.edu.co.ZonasPromisorias.model.entities;

import utp.edu.co.ZonasPromisorias.model.entities.ids.ControlFrutoId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "control_fruto")
@IdClass(ControlFrutoId.class)
public class ControlFrutoEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_catastral", referencedColumnName = "id_catastral")
    private LoteEntity lote;

    @Id
    @Column(name = "numero_lote")
    private Integer numeroLote;

    @Id
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "tamano")
    private BigDecimal tamano;

    @Column(name = "perfiles_acidos_grasos")
    private BigDecimal perfilesAcidosGrasos;

    @Column(name = "materia_seca")
    private BigDecimal materiaSeca;

    @Column(name = "contenido_humedad")
    private BigDecimal contenidoHumedad;

    @Column(name = "elemento_ca")
    private BigDecimal elementoCa;

}
