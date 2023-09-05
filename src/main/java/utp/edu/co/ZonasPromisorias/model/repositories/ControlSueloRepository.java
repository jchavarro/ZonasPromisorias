package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.ControlSueloEntity;
import utp.edu.co.zonaspromisorias.model.entities.CoordenadasPoligonoEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlSueloId;

import java.util.Date;
import java.util.List;

public interface ControlSueloRepository extends JpaRepository<ControlSueloEntity, ControlSueloId> {
    List<ControlSueloEntity>
    findByIdLoteIdFincaIdCatastral(Integer idCatastral);

    void deleteByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLoteAndIdFecha(Integer idCatastral, Integer numeroLote,
                                                                         Date fecha);
}
