package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;

import java.util.List;

public interface LoteRepository extends JpaRepository<LoteEntity, LoteId> {

    List<LoteEntity> findByidFincaIdCatastral(Integer idCatastral);
}
