package pe.edu.colegiocima.appcima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.colegiocima.appcima.service.GradoService;

@RestController(value = "grado")
@RequestMapping("/grado")
public class GradoController {
    @Autowired
    private GradoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.findAll());
    }
}
