package view;

import controller.DatabaseController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class Menu {
    public static Scanner INPUT = new Scanner(System.in);
    public static final DatabaseController DATABASE_CONTROLLER = new DatabaseController(new Database());
    protected static final String TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";
    protected static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    protected static final String PASSWORD_CONDITION =
            "Entered password should start with minimum 1 and maximum 3 digits,\n" +
                    "continued by exactly one capital letter and finally, be finished by minimum 5\n" +
                    "and maximum 10 English non-capital letters.";

    public abstract Menu run();

    public static String removeExtraWhitespace(String string) {
        return string.trim().replaceAll("\\s+", " ");
    }

    public String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATE_TIME_FORMAT);
    }

    public static LocalDateTime parseDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMAT);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public abstract String help();
}
