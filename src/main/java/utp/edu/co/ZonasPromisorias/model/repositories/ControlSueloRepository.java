package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.ControlSueloEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlSueloId;

public interface ControlSueloRepository extends JpaRepository<ControlSueloEntity, ControlSueloId> {
}
