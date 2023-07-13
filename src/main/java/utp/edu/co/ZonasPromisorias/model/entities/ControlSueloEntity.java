package utp.edu.co.ZonasPromisorias.model.entities;

import utp.edu.co.ZonasPromisorias.model.entities.ids.ControlSueloId;

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
@Table(name = "control_suelo")
@IdClass(ControlSueloId.class)
public class ControlSueloEntity {
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

    @Column(name = "medida_ph")
    private BigDecimal medidaPh;

    @Column(name = "materia_organica")
    private BigDecimal materiaOrganica;

    @Column(name = "elemento_k")
    private BigDecimal elementoK;

    @Column(name = "elemento_ca")
    private BigDecimal elementoCa;

    @Column(name = "elemento_mg")
    private BigDecimal elementoMg;

    @Column(name = "elemento_na")
    private BigDecimal elementoNa;

    @Column(name = "elemento_p")
    private BigDecimal elementoP;

}
