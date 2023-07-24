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
import utp.edu.co.zonaspromisorias.web.dto.FincaDto;
import utp.edu.co.zonaspromisorias.web.dto.LoteDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public LoteDto obtenerLotePorId(Integer idCatastral, Integer numeroLote) {
        log.info("Consulta de Lote : " + idCatastral + " " + numeroLote);
        LoteId loteId = new LoteId();
        FincaEntity fincaEntity = new FincaEntity();
        fincaEntity.setIdCatastral(idCatastral);
        loteId.setFinca(fincaEntity);
        loteId.setNumeroLote(numeroLote);
        entityManager.close();
        LoteEntity loteEntity = loteRepository.findById(loteId)
                .orElseThrow(() -> new NotFoundException("Lote no encontrado"));


        LoteDto loteDTO = new LoteDto();
        loteDTO.setFinca(mapper.map(loteEntity.getId().getFinca(), FincaDto.class));
        loteDTO.setNumeroLote(loteEntity.getId().getNumeroLote());
        loteDTO.setNombreLote(loteEntity.getNombreLote());

        return loteDTO;
    }

    @Override
    public LoteDto guardarLote(LoteDto loteDto) {
        log.info("Creacion de Lote : " + loteDto.getNombreLote());
        if (Boolean.TRUE.equals(validateLote(loteDto))) {
            LoteEntity loteEntity = mapper.map(loteDto, LoteEntity.class);
            loteEntity.setId(new LoteId(mapper.map(loteDto.getFinca(), FincaEntity.class), loteDto.getNumeroLote()));
            LoteEntity loteEntity1 = loteRepository.save(loteEntity);
            return mapper.map(loteEntity1, LoteDto.class);
        } else throw new NotFoundException("Los campos de nombre y finca son obligatorios ");
    }

    @Override
    public List<LoteDto> obtenerLotesPorIdCatastral() {
        return null;
    }

    @Override
    public LoteDto actualizarLote(LoteDto loteDto) {
        return null;
    }

    @Override
    public Boolean eliminarLote(Integer idCatastral, Integer numeroLote) {
        return null;
    }

    private Boolean validateLote(LoteDto loteDto) {
        return loteDto.getNombreLote() != null && loteDto.getFinca() != null;
    }
}
