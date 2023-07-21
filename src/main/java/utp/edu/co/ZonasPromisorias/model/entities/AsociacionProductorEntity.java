package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.AsociacionProductorId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asociacion_productor")
public class AsociacionProductorEntity implements Serializable {
    @EmbeddedId
    private AsociacionProductorId id;

    @ManyToOne
    @MapsId("nit_asociacion")
    @JoinColumn(name = "nit_asociacion")
    private AsociacionEntity asociacion;

    @ManyToOne
    @MapsId("nit_productor")
    @JoinColumn(name = "nit_productor")
    private ProductorEntity productor;
}
