package pe.edu.colegiocima.appcima.models.dao;

import pe.edu.colegiocima.appcima.models.entity.Grado;

public interface GradoDAO {	
	public Short insertar(Grado grado) throws Exception;
	public Boolean editar(Grado grado) throws Exception;
}
