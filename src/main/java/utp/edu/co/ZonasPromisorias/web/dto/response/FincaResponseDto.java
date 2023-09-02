package utp.edu.co.zonaspromisorias.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import utp.edu.co.zonaspromisorias.web.dto.ProductorDto;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FincaResponseDto {

    private Integer idCatastral;

    private String nombreFinca;

    private String ubicacionFinca;

    private String direccionFinca;

    private String hectareasFinca;

    private String nombreImagen;

    private String tipoImagen;

    private byte[] datosImagenFinca;

    private String observacionesFinca;

    private ProductorDto productor;
}
