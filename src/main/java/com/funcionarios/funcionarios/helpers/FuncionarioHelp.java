package com.funcionarios.funcionarios.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncionarioHelp {

    private static final String EMAIL_REGEX = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private FuncionarioHelp() {
        // Constructor privado para evitar instanciación
    }

    public static boolean validarRut(Integer rut, String dv) {
        int m = 0;
        int s = 1;
        int t = rut;

        /* Algoritmo Módulo 11 */
        for (; t != 0; t /= 10) {
            s = (s + t % 10 * (9 - m++ % 6)) % 11;
        }

        char dvCalculado = (char) (s != 0 ? s + 47 : 75);

        // Convertimos el DV ingresado a mayúscula para comparar correctamente (ej. 'k'
        // -> 'K')
        return dv.toUpperCase().charAt(0) == dvCalculado;
    }

    public static String calcularVrut(Integer rut) {
        if (rut == null)
            return null;

        int m = 0;
        int s = 1;
        int t = rut;

        for (; t != 0; t /= 10) {
            s = (s + t % 10 * (9 - m++ % 6)) % 11;
        }

        // s == 0 significa que el DV es '0'
        // De lo contrario, se calcula el número o 'K'
        if (s != 0) {
            return String.valueOf((char) (s + 47));
        } else {
            return "K";
        }
    }

    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

}
