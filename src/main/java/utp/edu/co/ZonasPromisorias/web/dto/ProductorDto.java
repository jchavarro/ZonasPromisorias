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
public class ProductorDto {

    private Integer nitProductor;

    private String nombreProductor;

    private String apellidosProductor;

    private String direccionProductor;

    private String telefonoProductor;

    private String imagenProductor;

    private String observacionesProductor;

    private List<AsociacionDto> asociaciones;
}
