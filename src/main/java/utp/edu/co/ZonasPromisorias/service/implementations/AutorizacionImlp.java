package utp.edu.co.zonaspromisorias.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utp.edu.co.zonaspromisorias.exceptions.types.BadRequestException;
import utp.edu.co.zonaspromisorias.model.entities.ProductorEntity;
import utp.edu.co.zonaspromisorias.model.repositories.ProductorRepository;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class AutorizacionImlp implements UserDetailsService {

    @Autowired
    private ProductorRepository productorRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        ProductorEntity usu = productorRepository.findByNombreUsuario(userId);

        if (usu != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            usu.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getNombre()));
            });
            UserDetails userDetails =
                    new User(usu.getNombreUsuario(), usu.getContrasena(), authorities);
            return userDetails;
        }
        throw new BadRequestException("El usuario no existe");
    }
}