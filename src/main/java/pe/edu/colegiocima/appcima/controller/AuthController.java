package pe.edu.colegiocima.appcima.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.colegiocima.appcima.models.jwt.JwtRequest;
import pe.edu.colegiocima.appcima.models.jwt.JwtResponse;
import pe.edu.colegiocima.appcima.security.jwt.JwtToken;
import pe.edu.colegiocima.appcima.service.JwtUserDetailsServiceImpl;

@RestController
@CrossOrigin
@Slf4j
public class AuthController {
    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> crearTokenAuthentication(
            @RequestBody JwtRequest request
            ) throws Exception{
        try{
            autenticar(request.getUsername(),request.getPassword());
            final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getUsername());
            final String token = jwtToken.generateToken(
                    userDetails
            );
            log.info("Token: " + token);
            return ResponseEntity.ok(new JwtResponse(token));
        }catch (Exception e){
            log.error("error", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    public void autenticar(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );
        }catch (DisabledException e){
            throw  new Exception("USUARIO DESHABILITADO",e);
        }catch (BadCredentialsException e){
            throw new Exception("CREDENCIALES INVALIDAS",e);
        }
    }

}
