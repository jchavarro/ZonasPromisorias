package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.CoordenadasPoligonoEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.CoordenadasPoligonoId;

public interface CoordenadasPoligonoRepository extends JpaRepository<CoordenadasPoligonoEntity, CoordenadasPoligonoId> {
}
