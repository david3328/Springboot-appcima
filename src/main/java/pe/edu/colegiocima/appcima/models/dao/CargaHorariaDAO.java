package pe.edu.colegiocima.appcima.models.dao;

public interface CargaHorariaDAO {
    public Integer generar(Short bimestre, Short idPlanEstudio, Short[] idDocente, Short[] idGradoSeccion, Short idUsuario, Integer size);
}
