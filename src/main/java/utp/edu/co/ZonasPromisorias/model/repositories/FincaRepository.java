package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;

import java.util.List;

public interface FincaRepository extends JpaRepository<FincaEntity, Integer> {

    List<FincaEntity> findByProductorNitProductor(Integer nitProductor);
}
