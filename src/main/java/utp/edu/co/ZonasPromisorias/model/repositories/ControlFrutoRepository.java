package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.ControlFrutoEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlFrutoId;

public interface ControlFrutoRepository extends JpaRepository<ControlFrutoEntity, ControlFrutoId> {
}
