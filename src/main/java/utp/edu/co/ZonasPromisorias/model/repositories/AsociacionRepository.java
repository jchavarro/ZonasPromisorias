package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.edu.co.zonaspromisorias.model.entities.AsociacionEntity;

@Repository
public interface AsociacionRepository extends JpaRepository<AsociacionEntity, Integer> {
}
