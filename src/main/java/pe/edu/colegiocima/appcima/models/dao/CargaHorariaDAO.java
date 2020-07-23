package pe.edu.colegiocima.appcima.models.dao;

import pe.edu.colegiocima.appcima.models.dto.udt.CargaHorariaUDT;

public interface CargaHorariaDAO {
    public Integer generar(Short bimestre, Short idPlanEstudio, CargaHorariaUDT[] cargaHoraria, Short idUsuario);
    public Integer generar(Short bimestre, Short idPlanEstudio, Short[] idDocente, Short[] idGradoSeccion, Short idUsuario, Integer size);
}
