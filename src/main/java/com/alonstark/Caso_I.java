package com.alonstark;

import java.util.Locale;
import java.util.Scanner;

public class Caso_I {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double tarifaBase;
        double porcentajeEdad;
        double descuento;
        int equipajePermitido;
        int kilosExceso = 0;
        double tasaEmbarque = 28.90;
        double costoKiloExceso = 12;

        System.out.print("Destino (1 a 4): ");
        int destino = sc.nextInt();

        switch (destino) {
            case 1:
                tarifaBase = 180;
                break;
            case 2:
                tarifaBase = 220;
                break;
            case 3:
                tarifaBase = 250;
                break;
            case 4:
                tarifaBase = 320;
                break;
            default:
                System.out.println("Destino no válido");
                return;
        }

        System.out.print("Clase (E o N): ");
        char clase = Character.toUpperCase(sc.next().charAt(0));

        double tarifaClase;
        if (clase == 'E') {
            tarifaClase = tarifaBase;
            equipajePermitido = 23;
        } else if (clase == 'N') {
            tarifaClase = tarifaBase * 1.8;
            equipajePermitido = 32;
        } else {
            System.out.println("Clase no válida");
            return;
        }

        System.out.print("Edad del pasajero: ");
        int edad = sc.nextInt();

        System.out.print("Dias de anticipacion: ");
        int anticipacion = sc.nextInt();

        System.out.print("Kilos de equipaje: ");
        int equipaje = sc.nextInt();

        if (edad < 2) {
            porcentajeEdad = 0.10;
        } else if (edad <= 11) {
            porcentajeEdad = 0.75;
        } else if (edad >= 65) {
            porcentajeEdad = 0.85;
        } else {
            porcentajeEdad = 1.00;
        }

        if (anticipacion >= 30) {
            descuento = 0.15;
        } else if (anticipacion >= 15) {
            descuento = 0.08;
        } else {
            descuento = 0;
        }

        double tarifaEdad = tarifaClase * porcentajeEdad;
        double tarifaFinal = tarifaEdad - tarifaEdad * descuento;

        if (equipaje > equipajePermitido) {
            kilosExceso = equipaje - equipajePermitido;
        }
        double excesoEquipaje = kilosExceso * costoKiloExceso;

        double total = tarifaFinal + excesoEquipaje + tasaEmbarque;

        System.out.printf(Locale.US, "Tarifa con descuentos: S/ %.2f%n", tarifaFinal);
        System.out.printf(Locale.US, "Exceso de equipaje: S/ %.2f%n", excesoEquipaje);
        System.out.printf(Locale.US, "Tasa de embarque: S/ %.2f%n", tasaEmbarque);
        System.out.printf(Locale.US, "Total: S/ %.2f%n", total);
    }
}
