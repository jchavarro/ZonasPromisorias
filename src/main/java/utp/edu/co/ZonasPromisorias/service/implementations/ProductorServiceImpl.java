package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.ProductorEntity;
import utp.edu.co.zonaspromisorias.model.repositories.ProductorRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.ProductorService;
import utp.edu.co.zonaspromisorias.web.dto.ProductorDto;

import static utp.edu.co.zonaspromisorias.service.utils.factories.ProductorFactory.crearProductorEntityPorProductorDto;

@Service
@AllArgsConstructor
@Slf4j
public class ProductorServiceImpl implements ProductorService {

    /**
     * Permite la conversión de un objeto a otro que tenga atributos en común.
     */
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProductorRepository productorRepository;

    @Override
    public ProductorDto obtenerProductorPorId(Integer id) {
        log.info("Consulta de Productor : " + id);
        return mapper.map(productorRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("No se ha encontrado el productor: " + id)),
                ProductorDto.class);
    }

    @Override
    public ProductorDto guardarProductor(ProductorDto productorDto) {
        log.info("Creacion de Productor : " + productorDto.getNitProductor());
        if (Boolean.TRUE.equals(productorRepository.existsByNombreUsuario(productorDto.getNombreUsuario()))) {
            throw new NotFoundException("El nombre de usuario ya existe: "
                    + productorDto.getNombreUsuario());
        }
        ProductorEntity productor = productorRepository
                .save(crearProductorEntityPorProductorDto(productorDto));
        return mapper.map(productor, ProductorDto.class);
    }

    @Override
    public ProductorDto actualizarProductor(ProductorDto productorDto) {
        log.info("Actualizacion de Productor : " + productorDto.getNitProductor());
        productorRepository.findById(productorDto.getNitProductor())
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el productor: "
                        + productorDto.getNitProductor()));
        return mapper.map(productorRepository.save(mapper.map(productorDto, ProductorEntity.class)),
                ProductorDto.class);
    }

    @Override
    public Boolean eliminarProductor(Integer id) {
        log.info("Eliminacion de Productor : " + id);
        productorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el productor: " + id));
        productorRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private Boolean validateProductor(final ProductorDto productorDto) {
        return productorDto.getNitProductor() != null && productorDto.getNombreProductor() != null;
    }
}
