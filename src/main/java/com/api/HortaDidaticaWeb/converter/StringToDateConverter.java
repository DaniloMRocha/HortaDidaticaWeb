
package com.api.HortaDidaticaWeb.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.time.LocalDate;

@Component
public class StringToDateConverter implements Converter<String, Date>{
    
    @Override
    public Date convert(String source) {
        return Date.valueOf(LocalDate.parse(source));
    }
    
}
