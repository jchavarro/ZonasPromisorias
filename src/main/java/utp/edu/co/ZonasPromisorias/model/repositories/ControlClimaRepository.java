package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.ControlClimaEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlClimaId;

import java.util.Date;
import java.util.List;

public interface ControlClimaRepository extends JpaRepository<ControlClimaEntity, ControlClimaId> {
    List<ControlClimaEntity>
    findByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(Integer idCatastral, Integer numeroLote);

    void deleteByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLoteAndIdFecha(Integer idCatastral, Integer numeroLote,
                                                                         Date fecha);
}
