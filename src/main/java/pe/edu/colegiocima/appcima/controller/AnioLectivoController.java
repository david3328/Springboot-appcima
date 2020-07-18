package pe.edu.colegiocima.appcima.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.colegiocima.appcima.models.entity.AnioLectivo;
import pe.edu.colegiocima.appcima.service.AnioLectivoService;

import java.util.Objects;

@RestController(value = "aniolectivo")
@RequestMapping("/aniolectivo")
@Api(tags = "API Año Lectivo", description = "API del Listado Año Lectivo")
public class AnioLectivoController {

    @Autowired
    private AnioLectivoService service;

    @GetMapping()
    @ApiOperation(value = "Lista de todos los años lectivos")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/activo")
    @ApiOperation(value = "Lista de los años lectivos activos y ordenados por ID")
    public ResponseEntity<?> listarActivo(){
        return ResponseEntity.ok(service.findActive());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener año lectivo por ID")
    public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del registro") @PathVariable Short id){
        AnioLectivo obj = service.findById(id);
        if(Objects.isNull(obj)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findById(id));
    }


}
