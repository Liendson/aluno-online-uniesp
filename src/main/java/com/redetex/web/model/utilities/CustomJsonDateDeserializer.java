package com.redetex.web.model.utilities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomJsonDateDeserializer extends StdDeserializer<Date> {
    private static final long serialVersionUID = 5733300029529524226L;

    public CustomJsonDateDeserializer() {
        this(null);
    }

    public CustomJsonDateDeserializer(Class<?> vc) {
        super(vc);
    }

    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
        try {
            return DateUtils.parseDate(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm", "yyyy-MM-dd", "dd/MM/yyyy", "dd/MM/yyyy hh:mm:ss", "dd/MM/yyyy hh:mm", "dd/MM/yyyy'T'hh:mm:ss", "dd/MM/yyyy'T'hh:mm:ss'Z'", "dd/MM/yyyy'T'hh:mm:ssZ");
        } catch (ParseException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static String formatDateSQL(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}