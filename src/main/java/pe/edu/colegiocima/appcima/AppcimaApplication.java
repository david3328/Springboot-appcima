package pe.edu.colegiocima.appcima;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.colegiocima.appcima.models.dao.GradoDAO;
import pe.edu.colegiocima.appcima.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.appcima.models.dto.projection.AnioLectivoVista;
import pe.edu.colegiocima.appcima.models.entity.AnioLectivo;
import pe.edu.colegiocima.appcima.models.entity.Grado;
import pe.edu.colegiocima.appcima.models.repository.AnioLectivoRepository;
import pe.edu.colegiocima.appcima.models.repository.GradoRepository;

@SpringBootApplication
public class AppcimaApplication implements CommandLineRunner{
	@Autowired
	private GradoRepository gradoRepository;

	@Autowired
	private AnioLectivoRepository anioLectivoRepository;
	
	@Autowired
	private GradoDAO gradoDAO;

    public static void main(String[] args) {
        SpringApplication.run(AppcimaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Calendar calendar = new GregorianCalendar(2008,0,1);
    	List<Object[]> lista = gradoRepository.buscarIdNivelGrado(calendar.getTime());
		for (Object[] o: lista ) {
			System.out.println("ID Colegio: "+o[0] + " ID Grado: " +o[1]);
		}

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
