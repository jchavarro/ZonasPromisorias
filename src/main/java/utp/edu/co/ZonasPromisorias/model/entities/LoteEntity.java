package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lote")
public class LoteEntity implements Serializable {
    @EmbeddedId
    private LoteId id;

    @Column(name = "nombre_lote")
    private String nombreLote;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "id.lote", orphanRemoval = true)
    private List<CoordenadasPoligonoEntity> coordenadasPoligono;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "id.lote", orphanRemoval = true)
    private List<ControlSueloEntity> controlesSuelo;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "id.lote", orphanRemoval = true)
    private List<ControlFrutoEntity> controlesFruto;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "id.lote", orphanRemoval = true)
    private List<ControlClimaEntity> controlesClima;

}
