package utp.edu.co.zonaspromisorias.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.ids.CoordenadasPoligonoId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "coordenadas_poligono")
public class CoordenadasPoligonoEntity implements Serializable {
    @EmbeddedId
    private CoordenadasPoligonoId id;

}
