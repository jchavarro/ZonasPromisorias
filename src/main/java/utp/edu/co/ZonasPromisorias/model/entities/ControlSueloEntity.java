package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlSueloId;

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
@Table(name = "control_suelo")
public class ControlSueloEntity implements Serializable {

    @EmbeddedId
    private ControlSueloId id;

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

    @Column(name = "elemento_n")
    private BigDecimal elementoN;

    @Column(name = "elemento_al")
    private BigDecimal elementoAl;

    @Column(name = "elemento_co")
    private BigDecimal elementoCo;

    @Column(name = "porcentaje_min")
    private BigDecimal porcentajeMin;

}
