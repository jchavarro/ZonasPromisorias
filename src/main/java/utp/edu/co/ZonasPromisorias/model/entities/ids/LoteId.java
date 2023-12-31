package utp.edu.co.zonaspromisorias.model.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class LoteId implements Serializable {
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_catastral")
    private FincaEntity finca;

    @Column(name = "numero_lote")
    private Integer numeroLote;

}
