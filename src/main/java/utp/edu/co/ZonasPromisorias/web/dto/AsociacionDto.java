package utp.edu.co.zonaspromisorias.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsociacionDto {

    private Integer nitAsociacion;

    private String nombreAsociacion;

    private String direccionAsociacion;

    private String telefonoAsociacion;

    private String observacionesAsociacion;

    private List<ProductorDto> productores;
}
