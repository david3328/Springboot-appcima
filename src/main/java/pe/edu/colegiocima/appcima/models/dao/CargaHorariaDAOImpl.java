package pe.edu.colegiocima.appcima.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.colegiocima.appcima.models.dto.udt.CargaHorariaUDT;

import java.sql.*;
import java.util.Objects;

@Repository
public class CargaHorariaDAOImpl implements CargaHorariaDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Integer generar(Short bimestre, Short idPlanEstudio, Short[] idDocente, Short[] idGradoSeccion, Short idUsuario, Integer size) {
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            Integer respuesta = session.doReturningWork(cnx->{
                PreparedStatement ps = cnx.prepareStatement("select f_insertacargahoraria(?,?,?,?,?,?)");
                int index = 0;
                ps.setObject(++index,bimestre, Types.SMALLINT);
                ps.setObject(++index,idPlanEstudio,Types.SMALLINT);
                Array inArrayDocente = cnx.createArrayOf("smallint",idDocente);
                ps.setObject(++index,inArrayDocente,Types.ARRAY);
                Array inArrayGradoSeccion = cnx.createArrayOf("smallint",idGradoSeccion);
                ps.setObject(++index,inArrayGradoSeccion,Types.ARRAY);
                ps.setObject(++index,idUsuario,Types.SMALLINT);
                ps.setObject(++index,size,Types.INTEGER);

                ResultSet rs = ps.executeQuery();
                Integer dato = null;
                if(Objects.nonNull(rs) && rs.next()){
                    dato = rs.getInt(1);
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

    @Override
    public Integer generar(Short bimestre, Short idPlanEstudio, CargaHorariaUDT[] cargaHoraria, Short idUsuario) {
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            Integer respuesta = session.doReturningWork(cnx->{
                PreparedStatement ps = cnx.prepareStatement("select f_insertacargahoraria(?,?,?,?)");
                int index = 0;
                ps.setObject(++index,bimestre, Types.SMALLINT);
                ps.setObject(++index,idPlanEstudio,Types.SMALLINT);
                Array inArrayDocente = cnx.createArrayOf(CargaHorariaUDT.TYPE_NAME,cargaHoraria);
                ps.setObject(++index,inArrayDocente,Types.ARRAY);
                ps.setObject(++index,idUsuario,Types.SMALLINT);

                ResultSet rs = ps.executeQuery();
                Integer dato = null;
                if(Objects.nonNull(rs) && rs.next()){
                    dato = rs.getInt(1);
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
