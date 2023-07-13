package utp.edu.co.ZonasPromisorias.model.entities;


import utp.edu.co.ZonasPromisorias.model.entities.ids.CoordenadasPoligonoId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "coordenadas_poligono")
public class CoordenadasPoligonoEntity {
    @EmbeddedId
    private CoordenadasPoligonoId id;

    @Column(name = "coordenada_x")
    private BigDecimal coordenadaX;

    @Column(name = "coordenada_y")
    private BigDecimal coordenadaY;

    @ManyToOne
    @JoinColumn(name = "id_catastral", referencedColumnName = "id_catastral", insertable = false, updatable = false)
    private LoteEntity lote;

}
