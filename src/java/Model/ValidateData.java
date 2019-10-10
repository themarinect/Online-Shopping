/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class ValidateData {

    public static boolean isEmail(String Value) {
        Pattern pattern = Pattern.compile("\\w+@[a-zA-Z_]+\\.[a-zA-Z]{2,3}");
        Matcher matcher = pattern.matcher(Value);
        return matcher.matches();
    }

    public static boolean isEmail1(String Value) {
        Pattern pattern = Pattern.compile("(\\w+@[a-zA-Z_]+\\.[a-zA-Z]{2,3})|(\\w+@[a-zA-Z_]+\\.[a-zA-Z]{2,3}\\.[a-zA-Z]{2,3})");
        Matcher matcher = pattern.matcher(Value);
        return matcher.matches();
    }

    public static boolean isPwdUsername(String Value) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(Value);
        return matcher.matches();
    }

    public static boolean isSpace(String Value) {
        Pattern pattern = Pattern.compile("[\\w\\s]+");
        Matcher matcher = pattern.matcher(Value);
        return matcher.matches();
    }

    public static boolean isAZSpace(String Value) {
        Pattern pattern = Pattern.compile("[\\w\\s]+");
        Matcher matcher = pattern.matcher(Value);
        return matcher.matches();
    }

    public static boolean isNumeric(String Value) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(Value);
        return matcher.matches();
    }

    public static boolean isEmpty(String Value) {
        if (Value.trim().equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    public static boolean MaxLength(String Value, int Length) {
        if (Value.trim().length() <= Length) {
            return false;
        }
        return true;
    }

    public static boolean isDate(String Value) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            format.setLenient(false);
            Date date = new Date(format.parse(Value).getTime());
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }
}
