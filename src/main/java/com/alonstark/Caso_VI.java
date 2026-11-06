package com.alonstark;

import java.util.Scanner;

public class Caso_VI {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int entradasGeneralDisponibles = 12;
        int entradasVIPDisponibles = 4;
        int totalAforoMaximo = 16;

        int entradasVendidasGeneral = 0;
        int entradasVendidasVIP = 0;
        double ingresosTotales = 0.0;
        int comprasAceptadas = 0;
        int comprasRechazadas = 0;
        int contadorComprasTotales = 0;

        System.out.println("=== SISTEMA DE VENTA DE ENTRADAS ===");
        System.out.println("Ingrese el tipo de entrada (G para General, V para VIP) o 'F' para finalizar:");

        while (true) {
            contadorComprasTotales++;
            System.out.print("\nCompra " + contadorComprasTotales + " - Tipo de entrada (G | V |F): ");
            String tipo = scanner.next().trim().toUpperCase();

            if (tipo.equals("F")) {
                contadorComprasTotales--; // No cuenta 'F' como una compra ingresada
                break;
            }

            if (!tipo.equals("G") && !tipo.equals("V")) {
                System.out.println("Tipo no válido");
                comprasRechazadas++;
                continue;
            }

            System.out.print("Cantidad de entradas: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Cantidad no válida: debe ser de 1 a 6");
                scanner.next(); 
                comprasRechazadas++;
                continue;
            }
            int cantidad = scanner.nextInt();

            if (cantidad < 1 || cantidad > 6) {
                System.out.println("Cantidad no válida: debe ser de 1 a 6");
                comprasRechazadas++;
                continue;
            }

            if (tipo.equals("G")) {
                if (cantidad > entradasGeneralDisponibles) {
                    System.out.println("Entradas insuficientes: quedan " + entradasGeneralDisponibles);
                    comprasRechazadas++;
                    continue;
                }
            } else if (tipo.equals("V")) {
                if (cantidad > entradasVIPDisponibles) {
                    System.out.println("Entradas insuficientes: quedan " + entradasVIPDisponibles);
                    comprasRechazadas++;
                    continue;
                }
            }

            double precioUnitario = tipo.equals("G") ? 80.0 : 200.0;
            double montoSubtotal = cantidad * precioUnitario;

            if (cantidad >= 4) {
                montoSubtotal = montoSubtotal * 0.90;
            }

            if (tipo.equals("G")) {
                entradasGeneralDisponibles -= cantidad;
                entradasVendidasGeneral += cantidad;
            } else {
                entradasVIPDisponibles -= cantidad;
                entradasVendidasVIP += cantidad;
            }

            ingresosTotales += montoSubtotal;
            comprasAceptadas++;

            System.out.printf("Compra %d: %d entradas %s - S/ %.2f\n", 
                comprasAceptadas, cantidad, tipo, montoSubtotal);
        }

        // RESUMEN FINAL 
        int totalVendidas = entradasVendidasGeneral + entradasVendidasVIP;
        double porcentajeOcupacion = ((double) totalVendidas / totalAforoMaximo) * 100.0;

        System.out.println("\n----------------------------------------");
        System.out.println("          RESUMEN FINAL                 ");
        System.out.println("----------------------------------------");
        System.out.println("Entradas vendidas: General " + entradasVendidasGeneral + " | VIP " + entradasVendidasVIP);
        System.out.printf("Ingresos: S/ %.2f\n", ingresosTotales);
        System.out.printf("Ocupación del aforo: %.2f %%\n", porcentajeOcupacion);
        System.out.println("Compras aceptadas: " + comprasAceptadas + " | Compras rechazadas: " + comprasRechazadas);

        scanner.close();
    }
}
