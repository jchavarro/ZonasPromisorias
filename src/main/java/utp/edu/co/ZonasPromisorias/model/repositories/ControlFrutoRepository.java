package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.ControlFrutoEntity;
import utp.edu.co.zonaspromisorias.model.entities.CoordenadasPoligonoEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlFrutoId;

import java.util.Date;
import java.util.List;

public interface ControlFrutoRepository extends JpaRepository<ControlFrutoEntity, ControlFrutoId> {
    List<ControlFrutoEntity>
    findByIdLoteIdFincaIdCatastral(Integer idCatastral);

    void deleteByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLoteAndIdFecha(Integer idCatastral, Integer numeroLote,
                                                                         Date fecha);

}
