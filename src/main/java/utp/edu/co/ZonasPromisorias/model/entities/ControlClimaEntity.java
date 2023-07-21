package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlClimaId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "control_clima")
@IdClass(ControlClimaId.class)
public class ControlClimaEntity implements Serializable {
    @EmbeddedId
    private ControlClimaId id;

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
