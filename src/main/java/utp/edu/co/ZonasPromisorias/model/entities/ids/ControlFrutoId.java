package utp.edu.co.ZonasPromisorias.model.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlFrutoId implements Serializable {
    private LoteId lote;
    private Integer numeroLote;
    private Date fecha;
}
