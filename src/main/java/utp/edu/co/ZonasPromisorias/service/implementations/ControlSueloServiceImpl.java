package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.BadRequestException;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.ControlSueloEntity;
import utp.edu.co.zonaspromisorias.model.repositories.ControlSueloRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.ControlSueloService;
import utp.edu.co.zonaspromisorias.service.utils.factories.ControlSueloFactory;
import utp.edu.co.zonaspromisorias.web.dto.ControlSueloDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static utp.edu.co.zonaspromisorias.service.utils.factories.ControlSueloFactory.crearControlSueloEntityPorControlSueloDto;
import static utp.edu.co.zonaspromisorias.service.utils.factories.ControlSueloFactory.crearControlSueloId;

@Service
@AllArgsConstructor
@Slf4j
public class ControlSueloServiceImpl implements ControlSueloService {

    @Autowired
    private ControlSueloRepository controlSueloRepository;

    @Override
    public List<ControlSueloDto> obtenerTodos(Integer idCatastral, Integer numeroLote) {
        log.info("Consulta de todos los ControlSuelo");
        List<ControlSueloDto> controlSueloDtos = controlSueloRepository
                .findByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(idCatastral, numeroLote)
                .stream()
                .map(ControlSueloFactory::crearControlSueloDtoPorControlSueloEntity)
                .collect(Collectors.toList());
        if (!controlSueloDtos.isEmpty()) return controlSueloDtos;
        else throw new NotFoundException("No se encontraron ControlSuelo para el lote: " + numeroLote);
    }

    @Override
    public List<ControlSueloDto> obtenerTodos() {
        log.info("Consulta de todos los ControlSuelo");
        List<ControlSueloDto> controlSueloDtos = controlSueloRepository
                .findAll()
                .stream()
                .map(ControlSueloFactory::crearControlSueloDtoPorControlSueloEntity)
                .collect(Collectors.toList());
        if (!controlSueloDtos.isEmpty()) return controlSueloDtos;
        else throw new NotFoundException("No se encontraron ControlSuelo");
    }

    @Transactional(rollbackOn = BadRequestException.class)
    @Override
    public List<ControlSueloDto> guardarControlSuelo(List<ControlSueloDto> controlSueloDto) {
        log.info("Creacion de ControlSuelo {}", controlSueloDto);
        return controlSueloDto.stream()
                .map(controlSuelo -> controlSueloRepository
                        .save(crearControlSueloEntityPorControlSueloDto(controlSuelo)))
                .map(ControlSueloFactory::crearControlSueloDtoPorControlSueloEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean eliminarControlSuelo(Integer idCatastral, Integer numeroLote, String fecha) {
        log.info("Eliminacion de ControlSuelo : " + idCatastral + " " + numeroLote + " " + fecha);
        ControlSueloEntity controlSueloEntity = controlSueloRepository
                .findById(crearControlSueloId(idCatastral, numeroLote, fecha))
                .orElseThrow(() -> new NotFoundException(
                        "No se encontraron ControlSuelo para " + idCatastral + " " + numeroLote + " " + fecha));
        controlSueloRepository.delete(controlSueloEntity);
        return Boolean.TRUE;
    }
}
