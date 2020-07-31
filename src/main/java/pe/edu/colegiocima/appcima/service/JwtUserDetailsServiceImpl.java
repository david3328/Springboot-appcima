package pe.edu.colegiocima.appcima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.colegiocima.appcima.models.entity.Persona;
import pe.edu.colegiocima.appcima.models.entity.Usuario;
import pe.edu.colegiocima.appcima.models.repository.PersonaRepository;
import pe.edu.colegiocima.appcima.models.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /* --- Primer CASO - Sin ROL
        /*
        Persona persona = personaRepository.findByLogin(username);
        if(Objects.isNull(persona)){
            throw new UsernameNotFoundException("Usuario no se encuentra con el login: "+username);
        }

        return new User(persona.getLogin(),new BCryptPasswordEncoder().encode(persona.getPass()), new ArrayList<>());
        */

        // ---- Segundo CASO - Roles

        Usuario usuario = usuarioRepository.findByLogin(username).orElseThrow(()->new UsernameNotFoundException("Usuario no se encuentra con el login: "+username));
        List<String> roles = usuarioRepository.buscarRol(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String rol: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol));
        }
        return new User(usuario.getLogin(),new BCryptPasswordEncoder().encode(usuario.getPass()), authorities);
    }
}
