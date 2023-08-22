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
public class CoordenadasDto {

    private Integer idCatastral;

    private Integer numeroLote;

    private BigDecimal coordenadaX;

    private BigDecimal coordenadaY;
}
