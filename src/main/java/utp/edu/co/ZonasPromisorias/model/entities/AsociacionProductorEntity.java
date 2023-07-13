package utp.edu.co.ZonasPromisorias.model.entities;

import utp.edu.co.ZonasPromisorias.model.entities.ids.AsociacionProductorId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
