package utp.edu.co.ZonasPromisorias.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import utp.edu.co.ZonasPromisorias.model.entities.ProductorEntity;

@Repository
public interface ProductorRepository extends CrudRepository<ProductorEntity, Integer> {
}
