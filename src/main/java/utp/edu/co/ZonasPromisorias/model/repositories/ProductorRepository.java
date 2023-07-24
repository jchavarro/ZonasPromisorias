package utp.edu.co.zonaspromisorias.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.edu.co.zonaspromisorias.model.entities.ProductorEntity;

@Repository
public interface ProductorRepository extends JpaRepository<ProductorEntity, Integer> {
}
