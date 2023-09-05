package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.BadRequestException;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.ControlClimaEntity;
import utp.edu.co.zonaspromisorias.model.repositories.ControlClimaRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.ControlClimaService;
import utp.edu.co.zonaspromisorias.service.utils.factories.ControlClimaFactory;
import utp.edu.co.zonaspromisorias.web.dto.ControlClimaDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static utp.edu.co.zonaspromisorias.service.utils.factories.ControlClimaFactory.crearControlClimaEntityPorClimaDto;
import static utp.edu.co.zonaspromisorias.service.utils.factories.ControlClimaFactory.crearControlClimaId;


@Slf4j
@AllArgsConstructor
@Service
public class ControlClimaServiceImpl implements ControlClimaService {

    @Autowired
    private ControlClimaRepository controlClimaRepository;

    @Override
    public List<ControlClimaDto> obtenerControlClimaPorId(Integer idCatastral) {
        log.info("Consulta de todos los ControlClima");
        List<ControlClimaDto> controlClimaDtos = controlClimaRepository
                .findByIdLoteIdFincaIdCatastral(idCatastral)
                .stream()
                .map(ControlClimaFactory::crearControlClimaDtoPorClimaEntity)
                .collect(Collectors.toList());
        if (!controlClimaDtos.isEmpty()) return controlClimaDtos;
        else throw new NotFoundException("No se encontró control clima por " + idCatastral);
    }

    @Transactional(rollbackOn = BadRequestException.class)
    @Override
    public List<ControlClimaDto> crearControlClima(List<ControlClimaDto> controlClimaDto) {
        log.info("Creacion de control CLima: {} ", controlClimaDto);
        return controlClimaDto.stream()
                .map(controlClima -> controlClimaRepository
                        .save(crearControlClimaEntityPorClimaDto(controlClima)))
                .map(ControlClimaFactory::crearControlClimaDtoPorClimaEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean eliminarControlClima(Integer idCatastral, Integer numeroLote, String fecha) {
        log.info("Eliminacion de ControlClima : " + idCatastral + " " + numeroLote + " " + fecha);
        ControlClimaEntity controlClimaEntity = controlClimaRepository
                .findById(crearControlClimaId(idCatastral, numeroLote, fecha))
                .orElseThrow(() -> new NotFoundException(
                        "No se encontraron ControlClima para " + idCatastral + " " + numeroLote + " " + fecha));
        controlClimaRepository.delete(controlClimaEntity);
        return Boolean.TRUE;
    }

    @Override
    public List<ControlClimaDto> obtenerTodos() {
        log.info("Consulta de todos los ControlClima");
        List<ControlClimaDto> controlClimaDtos = controlClimaRepository
                .findAll()
                .stream()
                .map(ControlClimaFactory::crearControlClimaDtoPorClimaEntity)
                .collect(Collectors.toList());
        if (!controlClimaDtos.isEmpty()) return controlClimaDtos;
        else throw new NotFoundException("No se encontraron ControlClima");
    }
}
