/*
 * Created on 4/Fev/2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package referencefinder;

import java.io.*;
import java.lang.reflect.Array;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author ilucas
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }


    
        public static String camelCaseToString(String str) {
        StringBuilder nome = new StringBuilder();
        if (str != null && str.length() > 0) {
            nome.append(Character.toUpperCase(str.charAt(0)));
            for (int i = 1; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c) || Character.isDigit(c)) {
                    nome.append(' ');
                    nome.append(c);
                } else if ('.'==c){
                    nome.append(' ');
                } else {
                    nome.append(c);
                }
               
            }
            return nome.toString();
        }
        return null;
    }
        
    public static String stringToCamelCase(String str) {
        
        
        if (str != null && str.length() > 0) {
            String clean =removeAcentos(str.toLowerCase());
            StringBuilder nome = new StringBuilder();
            clean = clean.replaceAll("[^\\d\\w\\s]","" );
            String[] partesNome = clean.split("\\s+");
            nome.append(partesNome[0]);
            for(int i =1;i<partesNome.length && i<5;++i){
                nome.append(Character.toUpperCase(partesNome[i].charAt(0)));
                nome.append(partesNome[i].substring(1));
            }                       
            return nome.toString();
        }
        return null;
    }
    
    
    public static String removeAcentos(String str) {
        if (str == null) {
            return null;
        }

        str = str.replace('�', 'A');
        str = str.replace('�', 'a');
        str = str.replace('�', 'A');
        str = str.replace('�', 'a');
        str = str.replace('�', 'A');
        str = str.replace('�', 'a');
        str = str.replace('�', 'A');
        str = str.replace('�', 'a');
        str = str.replace('�', 'A');
        str = str.replace('�', 'a');
        str = str.replace('�', 'C');
        str = str.replace('�', 'c');
        str = str.replace('�', 'E');
        str = str.replace('�', 'e');
        str = str.replace('�', 'E');
        str = str.replace('�', 'e');
        str = str.replace('�', 'E');
        str = str.replace('�', 'e');
        str = str.replace('�', 'E');
        str = str.replace('�', 'e');
        str = str.replace('�', 'I');
        str = str.replace('�', 'I');
        str = str.replace('�', 'i');
        str = str.replace('�', 'i');
        str = str.replace('�', 'I');
        str = str.replace('�', 'i');
        str = str.replace('�', 'I');
        str = str.replace('�', 'i');
        str = str.replace('�', 'N');
        str = str.replace('�', 'n');
        str = str.replace('�', 'O');
        str = str.replace('�', 'O');
        str = str.replace('�', 'o');
        str = str.replace('�', 'o');
        str = str.replace('�', 'O');
        str = str.replace('�', 'o');
        str = str.replace('�', 'O');
        str = str.replace('�', 'o');
        str = str.replace('�', 'U');
        str = str.replace('�', 'U');
        str = str.replace('�', 'u');
        str = str.replace('�', 'u');
        str = str.replace('�', 'U');
        str = str.replace('�', 'u');

        return str;
    }

    public static String arrayToString(Object[] objs) {
        StringBuilder builder = new StringBuilder();
        builder.append("[\"");

        if (objs != null && objs.length > 0) {
            builder.append(objs[0]);
        }

        for (int i = 1; i < objs.length; ++i) {
            builder.append("\", \"");
            builder.append(objs[i]);
        }
        builder.append("\"]");
        return builder.toString();
    }

    public static String arrayToString(Object[] names, Object[] objs) {
        StringBuilder builder = new StringBuilder();
        builder.append("[\n\t");

        if (objs != null && objs.length > 0) {
            builder.append(names[0]);
            builder.append("=\"");
            builder.append(objectToString(objs[0]));
            builder.append("\"");
        }
        for (int i = 1; i < objs.length; ++i) {
            builder.append(",\n\t ");
            builder.append(names[i]);
            builder.append("=\"");
            builder.append(objectToString(objs[i]));
            builder.append("\"");

        }
        builder.append("\n\"]");
        return builder.toString();
    }

    public static String objectToString(Object object) {
        if (object == null) {
            return null;
        } else if (object.getClass().isArray()) {
            return arrayPrint(object);
        } else {
            return object.toString();
        }

    }

    /**
     * A convenience method to print all elements in an array
     *
     * @param a the array to print. It can be an object array or a primitive
     * type array
     */
    static String arrayPrint(Object a) {
        Class cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        StringBuilder builder = new StringBuilder(componentType.getName() + "[" + length + "] = { ");
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                builder.append(',');
            }
            builder.append(Array.get(a, i));
        }
        builder.append("}");
        return builder.toString();
    }
    
  
}
