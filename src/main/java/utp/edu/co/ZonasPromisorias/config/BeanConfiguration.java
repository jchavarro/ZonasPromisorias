package utp.edu.co.zonaspromisorias.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuracion de inyeccion de dependencias.
 *
 * @author Juan Chavarro
 */
@Configuration
public class BeanConfiguration {

    /**
     * Inyeccion de dependencias del mapeador de objetos.
     * @return instancia modelmapper.
     */
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
