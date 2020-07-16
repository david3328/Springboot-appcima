package pe.edu.colegiocima.appcima.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Objects;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.edu.colegiocima.appcima.models.entity.Grado;

@Repository
public class GradoDAOImpl implements GradoDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Short insertar(Grado grado) throws Exception {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			Short respuesta = session.doReturningWork(cnx -> {
				PreparedStatement ps = cnx.prepareStatement("select * from f_insertagrado(?,?,?,?,?)");
				int index = 0;
				ps.setObject(++index,grado.getDescripcion(),Types.VARCHAR);
				ps.setObject(++index,grado.getIdNivelColegio(),Types.SMALLINT);
				ps.setObject(++index, grado.getIdGradoAnterior(),Types.SMALLINT);
				ps.setObject(++index, grado.getEdad(),Types.INTEGER);
				ps.setObject(++index, grado.isCirculoEstudio(),Types.BOOLEAN);
				ResultSet rs = ps.executeQuery();
				Short dato = null;
				if(Objects.nonNull(rs) && rs.next()) {
					dato = rs.getShort(1);
					rs.close();
				}
				ps.close();
				return dato;
			});
			if(Objects.nonNull(respuesta) && respuesta > 0) {
				session.getTransaction().commit();
			}else {
				session.getTransaction().rollback();
			}
			return respuesta;
		}catch(Exception e) {
			session.getTransaction().rollback();
			throw e;
		}finally {
			session.close();
		}
	}

}
