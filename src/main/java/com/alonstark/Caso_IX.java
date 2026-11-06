package com.alonstark;

import java.util.Scanner;

public class Caso_IX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numLlamada = 0;
        int gratisRestantes = 60;
        int gratisUsados = 0;
        double subtotal = 0.0;

        System.out.print("Tipo de llamada (L, N, I o F para terminar): ");
        if (!sc.hasNext()) {
            sc.close();
            return;
        }
        String tipo = sc.next().toUpperCase();

        while (!tipo.equals("F")) {

            System.out.print("Duración en segundos: ");
            int seg = sc.nextInt();

            if (!tipo.equals("L") && !tipo.equals("N") && !tipo.equals("I")) {
                System.out.println("Tipo de llamada no válido");
            } else {
                int minutos = (seg + 59) / 60;
                double costo = 0.0;
                String nomTipo = "";

                switch (tipo) {
                    case "L":
                        nomTipo = "local";
                        int usarGratis = 0;
                        if (minutos <= gratisRestantes) {
                            usarGratis = minutos;
                        } else {
                            usarGratis = gratisRestantes;
                        }
                        gratisUsados = gratisUsados + usarGratis;
                        gratisRestantes = gratisRestantes - usarGratis;

                        int cobrar = minutos - usarGratis;
                        costo = cobrar * 0.08;
                        break;

                    case "N":
                        nomTipo = "nacional";
                        costo = minutos * 0.15;
                        break;

                    case "I":
                        nomTipo = "internacional";
                        costo = minutos * 0.90;
                        break;
                }

                numLlamada++;
                subtotal = subtotal + costo;

                System.out.printf( "Llamada %d (%s): %d min - S/ %.2f%n", numLlamada, nomTipo, minutos, costo);

                if (subtotal > 50.00) {
                    System.out.println("Servicio suspendido por exceder el límite");
                    break;
                }
            }

            System.out.print("Tipo de llamada (L, N, I o F para terminar): ");
            if (sc.hasNext()) {
                tipo = sc.next().toUpperCase();
            } else {
                tipo = "F";
            }
        }

        double igv = subtotal * 0.18;
        double total = subtotal + igv;

        System.out.printf("Minutos locales gratis usados: %d%n", gratisUsados);
        System.out.printf("Total sin IGV: S/ %.2f%n", subtotal);
        System.out.printf("IGV: S/ %.2f%n", igv);
        System.out.printf("Total a pagar: S/ %.2f%n", total);

        sc.close();
    }

}
