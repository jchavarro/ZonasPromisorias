package utp.edu.co.zonaspromisorias.model.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CoordenadasPoligonoId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_catastral", referencedColumnName = "id_catastral", insertable = false, updatable = false)
    @JoinColumn(name = "numero_lote", referencedColumnName = "numero_lote", insertable = false, updatable = false)
    private LoteEntity lote;

    @Column(name = "coordenada_x")
    private BigDecimal coordenadaX;

    @Column(name = "coordenada_y")
    private BigDecimal coordenadaY;

}
