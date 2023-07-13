package utp.edu.co.ZonasPromisorias.model.entities;

import utp.edu.co.ZonasPromisorias.model.entities.ids.ControlClimaId;

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
@Table(name = "control_clima")
@IdClass(ControlClimaId.class)
public class ControlClimaEntity {
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

    @Column(name = "temperatura")
    private BigDecimal temperatura;

    @Column(name = "humedad_relativa")
    private BigDecimal humedadRelativa;

    @Column(name = "precipitacion")
    private BigDecimal precipitacion;

    @Column(name = "radiacion_solar")
    private BigDecimal radiacionSolar;

    @Column(name = "direccion_viento")
    private BigDecimal direccionViento;

    @Column(name = "velocidad_viento")
    private BigDecimal velocidadViento;
}
