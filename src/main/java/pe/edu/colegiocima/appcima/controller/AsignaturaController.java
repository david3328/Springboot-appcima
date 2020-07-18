package pe.edu.colegiocima.appcima.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.colegiocima.appcima.service.AsignaturaService;

@RestController
@RequestMapping("/asignatura")
@Api(tags = "API Asignatura",description = "API del Listado de las areas de la asignatura")
public class AsignaturaController {
    @Autowired
    private AsignaturaService service;

    @GetMapping()
    @ApiOperation(value = "Listar todas las asignaturas")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.findAll());
    }
}
