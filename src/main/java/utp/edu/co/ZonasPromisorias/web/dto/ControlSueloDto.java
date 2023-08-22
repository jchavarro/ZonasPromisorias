package utp.edu.co.zonaspromisorias.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ControlSueloDto {

    private Integer idCatastral;

    private Integer numeroLote;

    private String fecha;

    private BigDecimal medidaPh;

    private BigDecimal materiaOrganica;

    private BigDecimal elementoK;

    private BigDecimal elementoCa;

    private BigDecimal elementoMg;

    private BigDecimal elementoNa;

    private BigDecimal elementoP;
}
