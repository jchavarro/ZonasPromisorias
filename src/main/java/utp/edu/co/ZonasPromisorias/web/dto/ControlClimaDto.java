package utp.edu.co.zonaspromisorias.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ControlClimaDto {

    private Integer idCatastral;

    private Integer numeroLote;

    private String fecha;

    private BigDecimal temperatura;

    private BigDecimal humedadRelativa;

    private BigDecimal precipitacion;

    private BigDecimal radiacionSolar;

    private BigDecimal direccionViento;

    private BigDecimal velocidadViento;

    private BigDecimal humedadSuelo;

    private BigDecimal temperaturaSuelo;
}
