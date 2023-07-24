package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.ControlClimaEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlClimaId;

public interface ControlClimaRepository extends JpaRepository<ControlClimaEntity, ControlClimaId> {
}
