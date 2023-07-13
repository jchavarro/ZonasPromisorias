package utp.edu.co.ZonasPromisorias.model.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LoteId implements Serializable {
    @Column(name = "id_catastral")
    private Integer idCatastral;

    @Column(name = "numero_lote")
    private Integer numeroLote;

}
