package fr.cmm.tags;


import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class Functions {

    public static String text(String String){
        String s = StringEscapeUtils.escapeXml10(String);
        return StringUtils.replace(s, "\n", "<br>");
    }
}
