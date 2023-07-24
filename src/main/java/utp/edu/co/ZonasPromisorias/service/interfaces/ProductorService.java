package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.ProductorDto;

public interface ProductorService {
    ProductorDto obtenerProductorPorId(Integer id);

    ProductorDto guardarProductor(ProductorDto productorDto);

    ProductorDto actualizarProductor(ProductorDto productorDto);

    Boolean eliminarProductor(Integer id);
}
