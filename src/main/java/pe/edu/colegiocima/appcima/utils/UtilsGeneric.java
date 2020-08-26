package pe.edu.colegiocima.appcima.utils;

import io.netty.util.internal.StringUtil;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

public class UtilsGeneric {
    public static String formatParams(String value, Map<String,String> params){
        return StringUtils.capitalize(value) + " no se encontro para los parametros "+ params;
    }
}
