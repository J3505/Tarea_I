package com.alonstark;

import java.util.Scanner;

public class Caso_X {

       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cargados = 0;
        int rechazados = 0;
        double totalPeso = 0.0;
        double mayorPeso = 0.0;

        System.out.print("Ingrese peso del paquete en kg (0 para terminar): ");
        if (!sc.hasNextDouble()) {
            sc.close();
            return;
        }
        double peso = sc.nextDouble();

        while (peso != 0.0 && totalPeso < 950.0) {

            if (peso > 200.0) {
                System.out.println("Paquete rechazado: excede 200 kg");
                rechazados++;
            } else {
                double queda = 1000.0 - totalPeso;

                if (peso > queda) {
                    System.out.printf("Paquete rechazado: no cabe (quedan %.1f kg)%n", queda);
                    rechazados++;
                } else {
                    cargados++;
                    totalPeso = totalPeso + peso;

                    if (peso > mayorPeso) {
                        mayorPeso = peso;
                    }

                    System.out.printf("Paquete %d cargado: %.1f kg - Total: %.1f kg%n", cargados, peso, totalPeso);
                }
            }

            if (totalPeso >= 950.0) {
                System.out.println("Camión lleno");
            } else {
                System.out.print("Ingrese peso del paquete en kg (0 para terminar): ");
                if (sc.hasNextDouble()) {
                    peso = sc.nextDouble();
                } else {
                    peso = 0.0;
                }
            }
        }

        double ocupacion = (totalPeso / 1000.0) * 100.0;

        System.out.printf("Paquetes cargados: %d | Rechazados: %d%n", cargados, rechazados);
        System.out.printf("Peso total: %.1f kg%n", totalPeso);
        System.out.printf("Ocupación: %.2f %%%n", ocupacion);
        System.out.printf("Paquete más pesado: %.1f kg%n", mayorPeso);

        sc.close();
    }


}
