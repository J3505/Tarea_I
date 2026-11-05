package com.alonstark;

import java.util.Scanner;

public class Caso_V {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Plan (B, P o F): ");
        char plan = Character.toUpperCase(sc.next().charAt(0));

        System.out.print("Tipo de atención (C, E o H): ");
        char tipo = Character.toUpperCase(sc.next().charAt(0));

        System.out.print("Monto de la atención: ");
        double monto = sc.nextDouble();

        // 1. Validaciones de plan
        if (plan != 'B' && plan != 'P' && plan != 'F') {
            System.out.println("Plan no válido");
            return;
        }
        if (tipo != 'C' && tipo != 'E' && tipo != 'H') {
            System.out.println("Tipo de atención no válido");
            return;
        }

        // 2. Porcentaje de cobertura del tipo de plan
        double porcentaje = 0;
        if (plan == 'B') {
            if (tipo == 'C') porcentaje = 0.60;
            else if (tipo == 'E') porcentaje = 0.70;
            else porcentaje = 0.50;
        } else if (plan == 'P') {
            if (tipo == 'C') porcentaje = 0.80;
            else if (tipo == 'E') porcentaje = 0.90;
            else porcentaje = 0.70;
        } else { // plan F
            if (tipo == 'C') porcentaje = 1.00;
            else if (tipo == 'E') porcentaje = 1.00;
            else porcentaje = 0.90;
        }

        // 3. Deducible por el tipo de plan
        double deducible;
        if (tipo == 'C') deducible = 0;
        else if (tipo == 'E') deducible = 50;
        else deducible = 200;

        // 4. Tope del plan
        double tope;
        if (plan == 'B') tope = 5000;
        else if (plan == 'P') tope = 15000;
        else tope = 50000;

        // 5. Cálculo
        double aseguradora;
        if (monto <= deducible) {
            aseguradora = 0;
        } else {
            aseguradora = (monto - deducible) * porcentaje;
            if (aseguradora > tope) {
                aseguradora = tope;
            }
        }
        double paciente = monto - aseguradora;

        // 6. Salida 
        System.out.printf("Paga la aseguradora: S/ %.2f%n", aseguradora);
        System.out.printf("Paga el paciente: S/ %.2f%n", paciente);
    }

}
