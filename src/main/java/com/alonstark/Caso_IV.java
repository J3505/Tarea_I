package com.alonstark;

import java.util.Locale;
import java.util.Scanner;

public class Caso_IV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // para leer decimales con punto

        System.out.print("Deuda total: ");
        double deuda = sc.nextDouble();

        System.out.print("Pago realizado: ");
        double pago = sc.nextDouble();

        System.out.print("Días de atraso: ");
        int atraso = sc.nextInt();

        System.out.print("Tipo de tarjeta (C o G): ");
        char tarjeta = Character.toUpperCase(sc.next().charAt(0));

        // 1. Pago mínimo
        double minimo;
        if (deuda < 50) {
            minimo = deuda;
        } else {
            minimo = deuda * 0.05;
            if (minimo < 50) {
                minimo = 50;
            }
        }

        // 2. Deuda cancelada
        if (pago >= deuda) {
            System.out.println("Deuda cancelada. Sin intereses");
            return;
        }

        // 3. Saldo pendiente
        double saldoPendiente = deuda - pago;

        // 4. Interés mensual según tarjeta
        double tasa;
        if (tarjeta == 'C') {
            tasa = 0.035;
        } else {
            tasa = 0.028;
        }
        double interes = saldoPendiente * tasa;

        // 5. Mora y estado
        double mora = 0;
        String estado;
        if (pago < minimo) {
            mora = saldoPendiente * 0.001 * atraso;
            double topeMora = saldoPendiente * 0.10;
            if (mora > topeMora) {
                mora = topeMora;
            }
            estado = "En mora";
        } else {
            estado = "Al día";
        }

        // 6. Nuevo saldo
        double nuevoSaldo = saldoPendiente + interes + mora;

        // 7. Salida
        System.out.printf(Locale.US, "Pago mínimo: S/ %.2f%n", minimo);
        System.out.printf(Locale.US, "Saldo pendiente: S/ %.2f%n", saldoPendiente);
        System.out.printf(Locale.US, "Interés: S/ %.2f%n", interes);
        System.out.printf(Locale.US, "Mora: S/ %.2f%n", mora);
        System.out.printf(Locale.US, "Nuevo saldo: S/ %.2f%n", nuevoSaldo);
        System.out.println("Estado: " + estado);
    }

}
