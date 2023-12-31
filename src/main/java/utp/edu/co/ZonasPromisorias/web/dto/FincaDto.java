package utp.edu.co.zonaspromisorias.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FincaDto {

    private Integer idCatastral;

    private String nombreFinca;

    private String ubicacionFinca;

    private String direccionFinca;

    private String hectareasFinca;

    private String observacionesFinca;

    private ProductorDto productor;
}
