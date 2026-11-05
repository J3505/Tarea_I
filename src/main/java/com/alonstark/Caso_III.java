package com.alonstark;

import java.util.Locale;
import java.util.Scanner;

public class Caso_III {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // para leer decimales con punto

        System.out.print("Unidades del lote: ");
        int lote = sc.nextInt();

        System.out.print("Unidades revisadas: ");
        int revisadas = sc.nextInt();

        System.out.print("Defectos menores encontrados: ");
        int menores = sc.nextInt();

        System.out.print("Defectos críticos encontrados: ");
        int criticos = sc.nextInt();

        System.out.print("Precio unitario: ");
        double precio = sc.nextDouble();

        System.out.print("Proveedor certificado (S/N): ");
        char certificado = Character.toUpperCase(sc.next().charAt(0));

        // 1. Validar muestra mínima ( 10% )
        int minimo = (int) Math.ceil(lote * 0.10);
        if (revisadas < minimo) {
            System.out.println("Muestra insuficiente: revisar al menos " + minimo + " unidades");
            return;
        }

        // 2. Defectos críticos
        if (criticos >= 1) {
            System.out.println("Decisión: Lote RECHAZADO: defectos críticos");
            System.out.printf(Locale.US, "Pago al proveedor: S/ %.2f%n", 0.0);
            return;
        }

        // 3. Porcentaje de defectuosas
        double porcentaje = (double) menores / revisadas * 100;

        // 4. Máximo aceptable según proveedor
        double maximo;
        if (certificado == 'S') {
            maximo = 3;
        } else {
            maximo = 2;
        }

        // 5. Decisión y pago
        double valorLote = lote * precio;
        double pago;
        String decision;

        if (porcentaje <= maximo) {
            decision = "Lote ACEPTADO";
            pago = valorLote;
        } else if (porcentaje <= maximo + 3) {
            decision = "Lote ACEPTADO CON DESCUENTO";
            pago = valorLote * 0.90;
        } else {
            decision = "Lote RECHAZADO: exceso de defectos";
            pago = 0;
        }

        // 6. Salida
        System.out.printf(Locale.US, "Defectuosas: %.2f %%%n", porcentaje);
        System.out.println("Decisión: " + decision);
        System.out.printf(Locale.US, "Pago al proveedor: S/ %.2f%n", pago);
    }
}
