package pe.edu.colegiocima.appcima.models.dto.udt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargaHorariaUDT implements SQLData {
    public static final String TYPE_NAME = "public.tp_cargahoraria";
    private Short idDocente;
    private Short idGradoSeccion;

    @Override
    public String getSQLTypeName() throws SQLException {
        return TYPE_NAME;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.idDocente = stream.readShort();
        this.idGradoSeccion = stream.readShort();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeShort(this.idDocente);
        stream.writeShort(this.idGradoSeccion);
    }
}
