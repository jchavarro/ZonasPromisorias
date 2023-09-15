package utp.edu.co.zonaspromisorias.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ControlFrutoDto {

    private Integer idCatastral;

    private Integer numeroLote;

    private String fecha;

    private BigDecimal tamano;

    private BigDecimal clasificacionCf;

    private BigDecimal materiaSeca;

    private BigDecimal contenidoHumedad;

    private BigDecimal elementoCa;

}
