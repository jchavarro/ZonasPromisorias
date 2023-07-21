package utp.edu.co.zonaspromisorias.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.AsociacionProductorId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asociacion_productor")
@IdClass(AsociacionProductorId.class)
public class AsociacionProductorEntity {
    @Id
    @ManyToOne
    @MapsId("nitAsociacion")
    @JoinColumn(name = "nit_asociacion")
    private AsociacionEntity asociacion;

    @Id
    @ManyToOne
    @MapsId("nitProductor")
    @JoinColumn(name = "nit_productor")
    private ProductorEntity productor;

}
