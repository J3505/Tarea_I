package com.alonstark;

import java.util.Locale;
import java.util.Scanner;


public class Caso_VII {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Ingrese el valor inicial del equipo: ");
        double valorInicial = scanner.nextDouble();

       
        double valorResidual = valorInicial * 0.10; 
        double valorEnLibros = valorInicial;
        double depreciacionAcumulada = 0.0;
        int anio = 0;

        
        while (valorEnLibros > valorResidual + 0.00001) {
            anio++;
            double depreciacionAnual = valorEnLibros * 0.25; 
            double nuevoValorEnLibros = valorEnLibros - depreciacionAnual;

            
            if (nuevoValorEnLibros < valorResidual) {
                depreciacionAnual = valorEnLibros - valorResidual;
                nuevoValorEnLibros = valorResidual;
            }

            valorEnLibros = nuevoValorEnLibros;
            depreciacionAcumulada += depreciacionAnual;

           
            System.out.printf(Locale.US, "%d | %.2f | %.2f\n", anio, depreciacionAnual, valorEnLibros);
        }

       
        System.out.println("Años de depreciación: " + anio);
        System.out.printf(Locale.US, "Depreciación acumulada: S/ %.2f\n", depreciacionAcumulada);

        scanner.close();
    }
}
