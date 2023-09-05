package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.BadRequestException;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.ControlFrutoEntity;
import utp.edu.co.zonaspromisorias.model.repositories.ControlFrutoRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.ControlFrutoService;
import utp.edu.co.zonaspromisorias.service.utils.factories.ControlFrutoFactory;
import utp.edu.co.zonaspromisorias.web.dto.ControlFrutoDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static utp.edu.co.zonaspromisorias.service.utils.factories.ControlFrutoFactory.crearControlFrutoEntityPorControlFrutoDto;
import static utp.edu.co.zonaspromisorias.service.utils.factories.ControlFrutoFactory.crearControlFrutoId;

@AllArgsConstructor
@Service
@Slf4j
public class ControlFrutoServiceImpl implements ControlFrutoService {

    @Autowired
    private ControlFrutoRepository controlFrutoRepository;

    @Override
    public List<ControlFrutoDto> obtenerControlFrutoPorId(Integer idCatastral) {
        log.info("Consulta de todos los ControlFruto");
        List<ControlFrutoDto> controlFrutoDtos = controlFrutoRepository
                .findByIdLoteIdFincaIdCatastral(idCatastral)
                .stream()
                .map(ControlFrutoFactory::crearControlFrutoDtoPorControlFrutoEntity)
                .collect(Collectors.toList());
        if (!controlFrutoDtos.isEmpty()) return controlFrutoDtos;
        else throw new NotFoundException
                ("No se encontraron ControlFruto para la finca: " + idCatastral);
    }

    @Transactional(rollbackOn = BadRequestException.class)
    @Override
    public List<ControlFrutoDto> crearControlFruto(List<ControlFrutoDto> controlFrutoDto) {
        log.info("Creacion de ControlFruto {}", controlFrutoDto);
        return controlFrutoDto.stream()
                .map(controlFruto -> controlFrutoRepository
                        .save(crearControlFrutoEntityPorControlFrutoDto(controlFruto)))
                .map(ControlFrutoFactory::crearControlFrutoDtoPorControlFrutoEntity)
                .collect(Collectors.toList());
    }


    @Override
    public Boolean eliminarControlFruto(Integer idCatastral, Integer numeroLote, String fecha) {
        log.info("Eliminacion de ControlFruto : " + idCatastral + " " + numeroLote + " " + fecha);
        ControlFrutoEntity controlFrutoEntity = controlFrutoRepository
                .findById(crearControlFrutoId(idCatastral, numeroLote, fecha))
                .orElseThrow(() -> new NotFoundException(
                        "No se encontraron ControlFruto para " + idCatastral + " " + numeroLote + " " + fecha));
        controlFrutoRepository.delete(controlFrutoEntity);
        return Boolean.TRUE;
    }

    @Override
    public List<ControlFrutoDto> obtenerTodos() {
        log.info("Consulta de todos los ControlFruto");
        List<ControlFrutoDto> controlFrutoDtos = controlFrutoRepository
                .findAll()
                .stream()
                .map(ControlFrutoFactory::crearControlFrutoDtoPorControlFrutoEntity)
                .collect(Collectors.toList());
        if (!controlFrutoDtos.isEmpty()) return controlFrutoDtos;
        else throw new NotFoundException("No se encontraron ControlFruto");
    }
}
