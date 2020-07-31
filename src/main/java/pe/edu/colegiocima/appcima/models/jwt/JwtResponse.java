package pe.edu.colegiocima.appcima.models.jwt;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtResponse {
    private final String jwtToken;
    public String getToken(){
        return this.jwtToken;
    }
}
