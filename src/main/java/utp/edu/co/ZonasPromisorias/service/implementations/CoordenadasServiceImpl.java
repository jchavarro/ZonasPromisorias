package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.BadRequestException;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.CoordenadasPoligonoEntity;
import utp.edu.co.zonaspromisorias.model.repositories.CoordenadasPoligonoRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.CoordenadasService;
import utp.edu.co.zonaspromisorias.service.utils.factories.CoordenadaFactory;
import utp.edu.co.zonaspromisorias.web.dto.CoordenadasDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static utp.edu.co.zonaspromisorias.service.utils.factories.CoordenadaFactory.crearCoordenadaEntityPorCoordenadaDto;

@Slf4j
@Service
@AllArgsConstructor
public class CoordenadasServiceImpl implements CoordenadasService {

    @Autowired
    private CoordenadasPoligonoRepository coordenadasPoligonoRepository;

    @Override
    public List<CoordenadasDto> obtenerCoordenadasPorIdCatastral(Integer idCatastral) {
        log.info("Consulta de Coordenadas : " + idCatastral );
        List<CoordenadasDto> coordenadasDtos =  coordenadasPoligonoRepository
                .findByIdLoteIdFincaIdCatastral(idCatastral)
                .stream()
                .map(CoordenadaFactory::crearCoordenadaDtoPorCoordenadaEntity)
                .collect(Collectors.toList());
        if (!coordenadasDtos.isEmpty()) return coordenadasDtos;
        else throw new NotFoundException("No se encontraron coordenadas para la finca: " + idCatastral);
    }

    @Override
    public List<CoordenadasDto> obtenerCoordenadasPorIdCatastral(Integer idCatastral, Integer numeroLote) {
        log.info("Consulta de Coordenadas : " + idCatastral + " " + numeroLote);
        List<CoordenadasDto> coordenadasDtos =  coordenadasPoligonoRepository
                .findByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(idCatastral, numeroLote)
                .stream()
                .map(CoordenadaFactory::crearCoordenadaDtoPorCoordenadaEntity)
                .collect(Collectors.toList());
        if (!coordenadasDtos.isEmpty()) return coordenadasDtos;
        else throw new NotFoundException("No se encontraron coordenadas para el lote: " + numeroLote);
    }

    @Override
    @Transactional(rollbackOn = BadRequestException.class)
    public List<CoordenadasDto> guardarCoordenadas(List<CoordenadasDto> coordenadasDto) {
        log.info("CoordenadasDto: {}", coordenadasDto);
        return coordenadasDto.stream()
                .map(coordenada ->
                        coordenadasPoligonoRepository.save(crearCoordenadaEntityPorCoordenadaDto(coordenada)))
                .map(CoordenadaFactory::crearCoordenadaDtoPorCoordenadaEntity)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackOn = BadRequestException.class)
    @Override
    public Boolean eliminarCoordenadas(Integer idCatastral, Integer numeroLote) {
        log.info("Eliminacion de Coordenadas : " + idCatastral + " " + numeroLote);
        List<CoordenadasPoligonoEntity> coordenadasPoligonoEntities = coordenadasPoligonoRepository
                .findByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(idCatastral, numeroLote);
        if (!coordenadasPoligonoEntities.isEmpty()) {
            coordenadasPoligonoRepository
                    .deleteByIdLoteIdFincaIdCatastralAndIdLoteIdNumeroLote(idCatastral, numeroLote);
            return Boolean.TRUE;
        }
        else throw new NotFoundException("No se encontraron coordenadas para el lote: " + numeroLote);
    }
}
