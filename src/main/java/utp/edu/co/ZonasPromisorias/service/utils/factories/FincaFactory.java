package utp.edu.co.zonaspromisorias.service.utils.factories;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.ProductorEntity;
import utp.edu.co.zonaspromisorias.web.dto.FincaDto;

import java.io.File;
import java.io.IOException;

public final class FincaFactory {

    private FincaFactory() {
    }

    public static FincaEntity crearFincaEntityPorFincaDto(FincaDto fincaDto, MultipartFile imagenFinca)
            throws IOException {
        return FincaEntity.builder()
                .idCatastral(fincaDto.getIdCatastral())
                .nombreFinca(fincaDto.getNombreFinca())
                .ubicacionFinca(fincaDto.getUbicacionFinca())
                .direccionFinca(fincaDto.getDireccionFinca())
                .hectareasFinca(fincaDto.getHectareasFinca())
                .nombreImagen(imagenFinca == null ?
                        null : imagenFinca.getName())
                .tipoImagen(imagenFinca == null ?
                        null : imagenFinca.getContentType())
                .datosImagenFinca(imagenFinca == null ?
                        null : imagenFinca.getBytes())
                .observacionesFinca(fincaDto.getObservacionesFinca())
                .productor(ProductorEntity.builder().nitProductor(fincaDto.getProductor().getNitProductor()).build())
                .build();
    }

}
