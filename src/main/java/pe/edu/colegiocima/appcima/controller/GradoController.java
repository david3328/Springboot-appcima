package pe.edu.colegiocima.appcima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import pe.edu.colegiocima.appcima.models.entity.Grado;
import pe.edu.colegiocima.appcima.service.GradoService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController(value = "grado")
@RequestMapping("/grado")
@Api(tags = "API Grado", description = "API del CRUD Grado")
public class GradoController {
    @Autowired
    private GradoService service;

    @GetMapping("/nivel-colegio/{id}/pagina")
    @ApiOperation(value = "Listar grados y paginado por Nivel de Colegio")
    public ResponseEntity<?> listarPorNivelColegio(@PathVariable Integer id, Pageable pageable){

    	return ResponseEntity.ok(service.findByIdNivelColegioOrderByDescripcion(id,pageable));
    }
    
    @GetMapping()
    @ApiOperation(value = "Lista todos los grados")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.findAll());
    }
    

    @PostMapping()
    @ApiOperation(value = "Crear un nuevo registro del grado academico")
    public ResponseEntity<?> crear(@Valid @RequestBody 
    		@ApiParam(value = "Estructura del modelo Grado Academico")
    		Grado grado, BindingResult result){
        if(result.hasErrors()){
            return this.validar(result);
        }
        Grado gradoDB = service.save(grado);
        return ResponseEntity.status(HttpStatus.CREATED).body(gradoDB);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Editar un registro del grado academico")
    public ResponseEntity<?> editar(@Valid @RequestBody 
    		@ApiParam(value = "Estructura del modelo Grado Academico")
    		Grado grado, BindingResult result, 
    		@ApiParam(value = "Identificador del Grado Academico")
    		@PathVariable Long id){
       
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
@ApiOperation(value = "Elimina un registro del Grado Academico")
    public ResponseEntity<?> eliminar(
    		@ApiParam(value = "Identificador del Grado Academico", required = true, example = "16")
    		@PathVariable Long id){
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
