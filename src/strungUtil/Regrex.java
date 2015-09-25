package strungUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regrex {

    private static final String pattrnAbsolutPath = "^[A-Za-z]:";
    
    public static boolean isAbsolutPath(String path){
        return match(pattrnAbsolutPath,path);
    }
    
    public static boolean match(String pattern, String watMatch) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(watMatch);
        return m.matches();
    }

}
