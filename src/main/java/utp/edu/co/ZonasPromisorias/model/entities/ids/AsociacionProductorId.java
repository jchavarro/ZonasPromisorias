package utp.edu.co.zonaspromisorias.model.entities.ids;

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
public class AsociacionProductorId implements Serializable {

    @Column(name = "nit_asociacion")
    private Integer nitAsociacion;

    @Column(name = "nit_productor")
    private Integer nitProductor;

}
