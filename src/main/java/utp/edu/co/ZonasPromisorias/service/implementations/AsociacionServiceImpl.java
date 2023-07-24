package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.AsociacionEntity;
import utp.edu.co.zonaspromisorias.model.repositories.AsociacionRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.AsociacionService;
import utp.edu.co.zonaspromisorias.web.dto.AsociacionDto;

@Service
@AllArgsConstructor
@Slf4j
public class AsociacionServiceImpl implements AsociacionService {

    /**
     * Permite la conversión de un objeto a otro que tenga atributos en común.
     */
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Override
    public AsociacionDto obtenerAsociacionPorId(final Integer id) {
        log.info("Consulta de Asociacion : " + id);
        return mapper.map(asociacionRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("No se ha encontrado la asociacion: " + id)),
                AsociacionDto.class);
    }

    @Override
    public AsociacionDto guardarAsociacion(final AsociacionDto asociacionDto) {
        log.info("Creacion de Asociacion : " + asociacionDto.getNitAsociacion());
        if (Boolean.TRUE.equals(validateAsociacion(asociacionDto))) {
            return mapper.map(asociacionRepository
                    .save(mapper.map(asociacionDto, AsociacionEntity.class)), AsociacionDto.class);
        } else throw new NotFoundException("Los campos de nit y nombre son obligatorios "
                    + asociacionDto.getNitAsociacion());
    }

    @Override
    public AsociacionDto actualizarAsociacion(final AsociacionDto asociacionDto) {
        log.info("Actualizacion de Asociacion : " + asociacionDto.getNitAsociacion());
        asociacionRepository.findById(asociacionDto.getNitAsociacion())
                .orElseThrow(() -> new NotFoundException("No se ha encontrado la asociacion: "
                        + asociacionDto.getNitAsociacion()));
        return mapper.map(asociacionRepository.save(mapper.map(asociacionDto, AsociacionEntity.class)),
                AsociacionDto.class);
    }

    @Override
    public Boolean eliminarAsociacion(Integer id) {
        log.info("Eliminacion de Asociacion : " + id);
        asociacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado la asociacion: " + id));
        asociacionRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private Boolean validateAsociacion(final AsociacionDto asociacionDto) {
        return asociacionDto.getNitAsociacion() != null &&
                asociacionDto.getNombreAsociacion() != null;
    }
}
