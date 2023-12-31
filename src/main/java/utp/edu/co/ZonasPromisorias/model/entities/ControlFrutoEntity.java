package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlFrutoId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "control_fruto")
public class ControlFrutoEntity implements Serializable {
    @EmbeddedId
    private ControlFrutoId id;

    @Column(name = "tamano")
    private BigDecimal tamano;

    @Column(name = "clasificacion_cf")
    private BigDecimal clasificacionCf;

    @Column(name = "materia_seca")
    private BigDecimal materiaSeca;

    @Column(name = "contenido_humedad")
    private BigDecimal contenidoHumedad;

    @Column(name = "elemento_ca")
    private BigDecimal elementoCa;

}
