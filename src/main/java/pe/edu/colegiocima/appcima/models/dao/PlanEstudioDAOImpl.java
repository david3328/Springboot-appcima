package pe.edu.colegiocima.appcima.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.colegiocima.appcima.models.entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PlanEstudioDAOImpl implements PlanEstudioDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado) throws Exception {
        Session session = sessionFactory.openSession();
        List<PlanEstudio> lista = new ArrayList<>();
        try {
            session.doWork(cnx->{
                PreparedStatement ps = cnx.prepareStatement("select * from v_listaplanestudio where idannolectivo = ? and idgrado = ?");
                int index = 0;
                ps.setObject(++index,idAnioLectivo,Types.SMALLINT);
                ps.setObject(++index,idGrado,Types.SMALLINT);

                ResultSet rs = ps.executeQuery();
                if(Objects.nonNull(rs)){
                    while (rs.next()){
                        PlanEstudio planEstudio = mapperResultsetRecord(rs);
                        lista.add(planEstudio);
                    }
                    rs.close();
                }
                ps.close();
            });
            return lista;
        }catch(Exception e) {
            //session.getTransaction().rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    private PlanEstudio mapperResultsetRecord(ResultSet rs)  throws SQLException {
        PlanEstudio oMapper = new PlanEstudio();
        oMapper.setId(rs.getShort("id"));
        oMapper.setHoras(rs.getShort("horas"));
        Grado oGrado = new Grado();
        oGrado.setId(rs.getShort("idgrado"));
        oGrado.setDescripcion(rs.getString("grado"));
        oMapper.setGrado(oGrado);

        oMapper.setAnioLectivo(AnioLectivo.builder()
                .id(rs.getShort("idannolectivo"))
                .descripcion(rs.getString("annolectivo"))
                .build());
        oMapper.setAreaAsignatura(AreaAsignatura.builder()
                .id(rs.getShort("idareaasignatura"))
                .areaCurricular(AreaCurricular.builder()
                        .descripcion(rs.getString("areacurricular"))
                        .build())
                .asignatura(Asignatura.builder()
                        .descripcion("asignatura")
                        .build())
                .build());
        return oMapper;
    }
}
