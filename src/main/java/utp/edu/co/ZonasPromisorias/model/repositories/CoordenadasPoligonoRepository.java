package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utp.edu.co.zonaspromisorias.model.entities.CoordenadasPoligonoEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.CoordenadasPoligonoId;

import java.util.List;
import java.util.Optional;

public interface CoordenadasPoligonoRepository extends JpaRepository<CoordenadasPoligonoEntity, CoordenadasPoligonoId> {

    List<CoordenadasPoligonoEntity>
    findByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(Integer idCatastral, Integer numeroLote);

    void deleteByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(Integer idCatastral, Integer numeroLote);
}
