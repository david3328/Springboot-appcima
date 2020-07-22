package pe.edu.colegiocima.appcima.models.dto.projection;

/*
* DTO via proyección cerrada para entidades relacionadas con la estrategia de Interfaces Anidadas
* */

public interface AreaAsignaturaCustom {
    public Short getId();
    public AreaCurricularDTO getAreaCurricular();
    public AsignaturaDTO  getAsignatura();
    interface AsignaturaDTO{
        public String getDescripcion();
    }
    interface AreaCurricularDTO{
        public String getDescripcion();
    }
}
