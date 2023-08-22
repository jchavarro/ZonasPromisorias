package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;
import utp.edu.co.zonaspromisorias.model.repositories.LoteRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.LoteService;
import utp.edu.co.zonaspromisorias.service.utils.factories.LoteFactory;
import utp.edu.co.zonaspromisorias.web.dto.FincaDto;
import utp.edu.co.zonaspromisorias.web.dto.LoteDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utp.edu.co.zonaspromisorias.service.utils.factories.LoteFactory.crearLoteDtoPorLoteEntity;
import static utp.edu.co.zonaspromisorias.service.utils.factories.LoteFactory.crearLoteEntityPorLoteDto;

@Service
@Slf4j
@AllArgsConstructor
public class LoteServiceImpl implements LoteService {

    /**
     * Permite la conversión de un objeto a otro que tenga atributos en común.
     */
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LoteRepository loteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public LoteDto obtenerLotePorId(Integer idCatastral, Integer numeroLote) {
        log.info("Consulta de Lote : " + idCatastral + " " + numeroLote);
        LoteEntity loteEntity = loteRepository.findById(LoteId.builder()
                        .finca(FincaEntity.builder().idCatastral(idCatastral).build())
                        .numeroLote(numeroLote).build())
                .orElseThrow(() -> new NotFoundException("Lote no encontrado"));
        return crearLoteDtoPorLoteEntity(loteEntity);
    }

    @Override
    public LoteDto guardarLote(LoteDto loteDto) {
        log.info("Creacion de Lote : " + loteDto.getNombreLote());
        if (Boolean.TRUE.equals(validateLote(loteDto))) {
            return crearLoteDtoPorLoteEntity(loteRepository.save(crearLoteEntityPorLoteDto(loteDto)));
        } else throw new NotFoundException("Los campos de nombre y finca son obligatorios ");
    }

    @Override
    public List<LoteDto> obtenerLotesPorIdCatastral(final Integer idCatastral) {
        log.info("Consulta de Lotes por idCatastral : " + idCatastral);
        return loteRepository.findByidFincaIdCatastral(idCatastral).stream()
                .map(LoteFactory::crearLoteDtoPorLoteEntity)
                .collect(Collectors.toList());
    }

    @Override
    public LoteDto actualizarLote(LoteDto loteDto) {
        log.info("Actualizacion de Lote : " + loteDto.getNombreLote());
        if (Boolean.TRUE.equals(validateLote(loteDto))) {
            LoteEntity loteEntity = loteRepository.findById(LoteId.builder()
                            .finca(FincaEntity.builder().idCatastral(loteDto.getIdCatastral()).build())
                            .numeroLote(loteDto.getNumeroLote()).build())
                    .orElseThrow(() -> new NotFoundException("Lote no encontrado"));
            loteEntity.setNombreLote(loteDto.getNombreLote());
            return crearLoteDtoPorLoteEntity(loteRepository.save(loteEntity));
        } else throw new NotFoundException("Los campos de nombre y finca son obligatorios ");
    }

    @Override
    public Boolean eliminarLote(Integer idCatastral, Integer numeroLote) {
        log.info("Eliminacion de Lote : " + idCatastral + " " + numeroLote);
        LoteEntity loteEntity = loteRepository.findById(LoteId.builder()
                        .finca(FincaEntity.builder().idCatastral(idCatastral).build())
                        .numeroLote(numeroLote).build())
                .orElseThrow(() -> new NotFoundException("Lote no encontrado"));
        loteRepository.delete(loteEntity);
        return Boolean.TRUE;
    }

    private Boolean validateLote(LoteDto loteDto) {
        return loteDto.getNombreLote() != null && loteDto.getIdCatastral() != null;
    }
}
