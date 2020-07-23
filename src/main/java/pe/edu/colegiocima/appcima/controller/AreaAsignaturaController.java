package pe.edu.colegiocima.appcima.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.colegiocima.appcima.service.AreaAsignaturaService;

@RestController
@RequestMapping("/area-asignatura")
@Api(tags = "API Area Asignatura", description = "API del Lista de las areas de la asignatura")
public class AreaAsignaturaController {

    @Autowired
    private AreaAsignaturaService service;

    @GetMapping()
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/listar-formulario")
    public ResponseEntity<?> listarCustom(){ return ResponseEntity.ok(service.findCustomAreaAsignatura());}
}
