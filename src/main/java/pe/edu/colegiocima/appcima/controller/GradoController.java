package pe.edu.colegiocima.appcima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pe.edu.colegiocima.appcima.models.entity.Grado;
import pe.edu.colegiocima.appcima.service.GradoService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController(value = "grado")
@RequestMapping("/grado")
public class GradoController {
    @Autowired
    private GradoService service;

    @GetMapping()
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> crear(@Valid @RequestBody Grado grado, BindingResult result){
        if(result.hasErrors()){
            return this.validar(result);
        }
        Grado gradoDB = service.save(grado);
        return ResponseEntity.status(HttpStatus.CREATED).body(gradoDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Grado grado, BindingResult result, @PathVariable Long id){
       
    	if(result.hasErrors()) {
    		return this.validar(result);
    	}
    	
    	Grado o = service.findById(id);
        if(Objects.isNull(o)){
            return ResponseEntity.notFound().build();
        }

        Grado gradoDB = o;
        gradoDB.setDescripcion(grado.getDescripcion());
        gradoDB.setEdad(grado.getEdad());
        gradoDB.setIdNivelColegio(grado.getIdNivelColegio());
        gradoDB.setCirculoEstudio(grado.isCirculoEstudio());
        gradoDB.setIdGradoAnterior(grado.getIdGradoAnterior());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(gradoDB));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<?> validar(BindingResult result){
        Map<String,Object> errores = new HashMap<>();
        List<FieldError> lError = result.getFieldErrors();
        for(FieldError error: lError){
            errores.put(error.getField(),"El campo " + error.getField() + " " + error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errores);
    }
}
