package pe.edu.colegiocima.appcima;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.colegiocima.appcima.models.dao.CargaHorariaDAO;
import pe.edu.colegiocima.appcima.models.dao.GradoDAO;
import pe.edu.colegiocima.appcima.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.appcima.models.dto.projection.AnioLectivoVista;
import pe.edu.colegiocima.appcima.models.dto.projection.AreaAsignaturaCustom;
import pe.edu.colegiocima.appcima.models.dto.projection.AreaAsignaturaVista;
import pe.edu.colegiocima.appcima.models.entity.*;
import pe.edu.colegiocima.appcima.models.repository.AnioLectivoRepository;
import pe.edu.colegiocima.appcima.models.repository.AreaAsignaturaRepository;
import pe.edu.colegiocima.appcima.models.repository.AsignaturaRepository;
import pe.edu.colegiocima.appcima.models.repository.GradoRepository;

@SpringBootApplication
public class AppcimaApplication
		implements CommandLineRunner
{
	@Autowired
	private GradoRepository gradoRepository;

	@Autowired
	private AnioLectivoRepository anioLectivoRepository;
	
	@Autowired
	private GradoDAO gradoDAO;

	@Autowired
	private AreaAsignaturaRepository areaAsignaturaRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Autowired
	private CargaHorariaDAO cargaHorariaDAO;

    public static void main(String[] args) {
        SpringApplication.run(AppcimaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

    	int size = 5;
    	Short[] idDocente = {4155,3821,1077,550,981};
    	Short[] idGradoSeccion = {905,902,906,907,908};
    	Integer item = cargaHorariaDAO.generar((short) 1,(short) 4622,idDocente,idGradoSeccion,(short) 1045, size);
		System.out.println("Respuesta: " + item);

//    	List<String> lista = Arrays.asList("LUIS","BACA","ALEX","DAVID","PIO","BRAYAN");
//    	for (String nombre : lista){
//    		if(Objects.equals(nombre,"BACA")){continue;}
//			System.out.println("Hola " + nombre +" a codear");
//		}

//    	List<AreaAsignaturaCustom> lista = areaAsignaturaRepository.findByOrderByAreaCurricularDescripcion();
//    	List<AreaAsignaturaVista> lista = areaAsignaturaRepository.findCustomAreaCurricular();
//    	lista.forEach((area)->{
//			System.out.println("ID: "+area.getId() + " Area: "+area.getAreaCurricular() + " Asignatura: "+area.getAsignatura());
//		});

//    	Asignatura asignatura = asignaturaRepository.findById((short) 100).orElse(null);
//		System.out.println("listo");

//    	Iterable<AreaAsignatura> lista = repository.findAll();
//    	lista.forEach((asignatura)-> {
//			System.out.println("ID: " + asignatura.getId());
//			AreaCurricular ac = Objects.nonNull(asignatura.getAreaCurricular()) ? asignatura.getAreaCurricular() : new AreaCurricular();
//			System.out.println("Area Curricular: " + ac.getDescripcion());
//		});

//    	Iterable<AreaAsignatura> lista = repository.findAll();
//		System.out.println("listo");

//		Calendar calendar = new GregorianCalendar(2008,0,1);
//    	List<Object[]> lista = gradoRepository.buscarIdNivelGrado(calendar.getTime());
//		for (Object[] o: lista ) {
//			System.out.println("ID Colegio: "+o[0] + " ID Grado: " +o[1]);
//		}

		//List<AnioLectivo> lista = anioLectivoRepository.buscarPorActivo();
		//List<AnioLectivoVista> lista = anioLectivoRepository.findByActivoTrueOrderById();

//		List<AnioLectivoDTO> lista = anioLectivoRepository.findByActivoTrueOrderByDescripcion();

//		List<AnioLectivoDTO> lista = anioLectivoRepository.busquedaActivo();
//
//		for(AnioLectivoDTO item:lista) {
//			System.out.println("ID: " + item.getId() + " Descripcion: " + item.getDescripcion() );
//		}

		/*Grado g = gradoRepository.findByDescripcionAndIdNivelColegio("NATIVE", 1);
		if(Objects.isNull(g)) {
			//Short idgrado = gradoRepository.insertar("PRUEBA", (short)1,(short) 26, 12, true);
			Short idgrado = gradoRepository.queryInsertarDML("NATIVE", (short)1,(short) 26, 12, true);
			System.out.println("ID: " + idgrado);
		}*/
		
	/*	
		Grado grado = new Grado();
		grado.setDescripcion("DAO-TEST");
		grado.setIdNivelColegio(1);
		grado.setIdGradoAnterior(26);
		grado.setEdad(12);
		grado.setCirculoEstudio(true);
		
		Grado g = gradoRepository.findByDescripcionAndIdNivelColegio(grado.getDescripcion(),grado.getIdNivelColegio());
		
		if(Objects.isNull(g)) {
			Short idgrado = gradoDAO.insertar(grado);
			System.out.println("ID: " +idgrado);
		}	
	*/
		
	/*	
		Boolean idgrado = gradoRepository.editar("D-TEST-1", (short)1,(short) 26, 13, true, (short) 122);	
		
		System.out.println("ID: "+idgrado); 
		
		*/
		
		/*Grado grado = new Grado();
		grado.setId(122L);
		grado.setDescripcion("BAQUITA");
		grado.setIdNivelColegio(1);
		grado.setIdGradoAnterior(26);
		grado.setEdad(12);
		grado.setCirculoEstudio(true);
		
		Boolean idgrado = gradoDAO.editar(grado);	
		
		System.out.println("ID: "+idgrado); 
		
		AnioLectivo anioLectivo = new AnioLectivo();*/


		
	}

}
