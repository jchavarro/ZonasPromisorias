package utp.edu.co.zonaspromisorias.service.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.repositories.FincaRepository;
import utp.edu.co.zonaspromisorias.service.interfaces.FincaService;
import utp.edu.co.zonaspromisorias.service.utils.models.PythonModel;
import utp.edu.co.zonaspromisorias.web.dto.FincaDto;
import utp.edu.co.zonaspromisorias.web.dto.response.FincaResponseDto;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static utp.edu.co.zonaspromisorias.service.utils.factories.FincaFactory.crearFincaEntityPorFincaDto;

@AllArgsConstructor
@Service
@Slf4j
public class FincaServiceImpl implements FincaService {

    /**
     * Permite la conversión de un objeto a otro que tenga atributos en común.
     */
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FincaRepository fincaRepository;

    @Autowired
    private PythonModel pythonModel;

    @Override
    public FincaResponseDto obtenerFincaPorId(Integer id) {
        log.info("Consulta de Finca : " + id);
        return mapper.map(fincaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado la finca: " + id)), FincaResponseDto.class);
    }

    @Override
    public FincaResponseDto guardarFinca(FincaDto fincaDto, MultipartFile imagenFinca) throws IOException {
        log.info("Creacion de Finca : " + fincaDto.getNombreFinca());
        if (Boolean.TRUE.equals(validateFinca(fincaDto))) {
            return mapper.map(fincaRepository
                    .save(crearFincaEntityPorFincaDto(fincaDto, imagenFinca)), FincaResponseDto.class);
        } else throw new NotFoundException("Los campos de nombre e identificacion son obligatorios ");
    }

    @Override
    public FincaResponseDto actualizarFinca(FincaDto fincaDto, MultipartFile imagenFinca) throws IOException {
        log.info("Actualizacion de Finca : " + fincaDto.getNombreFinca());
        fincaRepository.findById(fincaDto.getIdCatastral())
                .orElseThrow(() -> new NotFoundException("No se ha encontrado la finca: "
                        + fincaDto.getIdCatastral()));
        return mapper.map(fincaRepository.save(crearFincaEntityPorFincaDto(fincaDto, imagenFinca)),
                FincaResponseDto.class);
    }

    @Override
    public Boolean eliminarFinca(Integer id) {
        log.info("Eliminacion de Finca : " + id);
        fincaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado la finca: " + id));
        fincaRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<FincaResponseDto> obtenerFincas(final Integer id) {
        log.info("Consulta de Fincas");
        return fincaRepository.findByProductorNitProductor(id).stream()
                .map(fincaEntity -> mapper.map(fincaEntity, FincaResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean obtenerModeloFinca() {
        return pythonModel.obtenerResultadoModelo();
    }

    private Boolean validateFinca(FincaDto fincaDto) {
        return fincaDto.getNombreFinca() != null && fincaDto.getIdCatastral() != null;
    }
}
