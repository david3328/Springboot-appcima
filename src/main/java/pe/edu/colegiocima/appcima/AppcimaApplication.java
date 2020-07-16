package pe.edu.colegiocima.appcima;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.colegiocima.appcima.models.dao.GradoDAO;
import pe.edu.colegiocima.appcima.models.entity.Grado;
import pe.edu.colegiocima.appcima.models.repository.GradoRepository;

@SpringBootApplication
public class AppcimaApplication implements CommandLineRunner{
	@Autowired
	private GradoRepository gradoRepository;
	
	@Autowired
	private GradoDAO gradoDAO;

    public static void main(String[] args) {
        SpringApplication.run(AppcimaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
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
		
		Boolean idgrado = gradoRepository.editar("D-TEST-1", (short)1,(short) 26, 13, true, (short) 122);	
		
		System.out.println("ID: "+idgrado);
		
	}

}
