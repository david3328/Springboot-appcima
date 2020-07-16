package pe.edu.colegiocima.appcima;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import pe.edu.colegiocima.appcima.models.entity.Grado;
import pe.edu.colegiocima.appcima.models.repository.GradoRepository;

@SpringBootApplication
public class AppcimaApplication implements CommandLineRunner{
	@Autowired
	private GradoRepository gradoRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppcimaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Grado g = gradoRepository.findByDescripcionAndIdNivelColegio("PRUEBA", 1);
		if(Objects.isNull(g)) {
			Short idgrado = gradoRepository.insertar("PRUEBA", (short)1,(short) 26, 12, true);		
			System.out.println("ID: " + idgrado);
		}
		
	}

}
