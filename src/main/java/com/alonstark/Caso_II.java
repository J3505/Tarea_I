package com.alonstark;

import java.util.Locale;
import java.util.Scanner;

public class Caso_II {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double arranque = 4.50;
        double costoDistancia;
        double costoEspera = 0;
        double factorDemanda;
        double recargoAeropuerto = 8.00;
        double tarifaMinima = 9.00;

        System.out.print("Distancia en km: ");
        double distancia = sc.nextDouble();

        System.out.print("Minutos de espera: ");
        int espera = sc.nextInt();

        System.out.print("Hora de inicio (0 a 23): ");
        int hora = sc.nextInt();

        System.out.print("Viaje al aeropuerto (S/N): ");
        char aeropuerto = Character.toUpperCase(sc.next().charAt(0));

        System.out.print("Nivel de demanda (1 a 3): ");
        int demanda = sc.nextInt();

        switch (demanda) {
            case 1:
                factorDemanda = 1.0;
                break;
            case 2:
                factorDemanda = 1.3;
                break;
            case 3:
                factorDemanda = 1.6;
                break;
            default:
                System.out.println("Nivel de demanda no válido");
                return;
        }

        if (distancia <= 5) {
            costoDistancia = distancia * 1.80;
        } else {
            costoDistancia = 5 * 1.80 + (distancia - 5) * 1.50;
        }

        if (espera > 3) {
            costoEspera = (espera - 3) * 0.30;
        }

        double subtotal = arranque + costoDistancia + costoEspera;

        if (hora >= 22 || hora < 5) {
            subtotal = subtotal * 1.20;
        }

        double total = subtotal * factorDemanda;

        if (aeropuerto == 'S') {
            total = total + recargoAeropuerto;
        }

        if (total < tarifaMinima) {
            System.out.printf(Locale.US, "Total a pagar: S/ %.2f (tarifa mínima)%n", tarifaMinima);
        } else {
            System.out.printf(Locale.US, "Total a pagar: S/ %.2f%n", total);
        }
    }
}
