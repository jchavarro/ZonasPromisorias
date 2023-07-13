package utp.edu.co.ZonasPromisorias.model.entities;

import utp.edu.co.ZonasPromisorias.model.entities.ids.LoteId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lote")
public class LoteEntity {
    @EmbeddedId
    private LoteId id;

    @Column(name = "nombre_lote")
    private String nombreLote;

    @ManyToOne
    @JoinColumn(name = "id_catastral", insertable = false, updatable = false)
    private FincaEntity finca;

}
