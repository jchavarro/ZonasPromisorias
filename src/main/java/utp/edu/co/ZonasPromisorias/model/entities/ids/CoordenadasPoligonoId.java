package utp.edu.co.ZonasPromisorias.model.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordenadasPoligonoId implements Serializable {
    private Integer idCatastral;
    private Integer numeroLote;
    private BigDecimal coordenadaX;
    private BigDecimal coordenadaY;

}
