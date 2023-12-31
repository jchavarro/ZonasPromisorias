package utp.edu.co.zonaspromisorias.service.utils.factories;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import utp.edu.co.zonaspromisorias.model.entities.ProductorEntity;
import utp.edu.co.zonaspromisorias.web.dto.ProductorDto;

public final class ProductorFactory {

    private ProductorFactory() {
    }

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static ProductorEntity crearProductorEntityPorProductorDto(ProductorDto productorDto) {
        return ProductorEntity.builder()
                .nitProductor(productorDto.getNitProductor())
                .nombreProductor(productorDto.getNombreProductor())
                .apellidosProductor(productorDto.getApellidosProductor())
                .direccionProductor(productorDto.getDireccionProductor())
                .telefonoProductor(productorDto.getTelefonoProductor())
                .imagenProductor(productorDto.getImagenProductor())
                .observacionesProductor(productorDto.getObservacionesProductor())
                .nombreUsuario(productorDto.getNombreUsuario())
                .contrasena(passwordEncoder.encode(productorDto.getContrasena()))
                .build();
    }

    public static ProductorDto crearProductorDtoPorProductorEntity(ProductorEntity productorEntity) {
        return ProductorDto.builder()
                .nitProductor(productorEntity.getNitProductor())
                .nombreProductor(productorEntity.getNombreProductor())
                .apellidosProductor(productorEntity.getApellidosProductor())
                .direccionProductor(productorEntity.getDireccionProductor())
                .telefonoProductor(productorEntity.getTelefonoProductor())
                .imagenProductor(productorEntity.getImagenProductor())
                .observacionesProductor(productorEntity.getObservacionesProductor())
                .nombreUsuario(productorEntity.getNombreUsuario())
                .contrasena(productorEntity.getContrasena())
                .build();
    }
}
