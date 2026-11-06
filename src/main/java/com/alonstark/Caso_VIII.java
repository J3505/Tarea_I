package com.alonstark;

import java.util.Scanner;

public class Caso_VIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese número de estudiantes: ");
        if (!sc.hasNextInt()) {
            return;
        }

        int n = sc.nextInt();

        int cantValidos = 0;
        int aprobados = 0;
        double sumPromedios = 0.0;
        String mejorAlumno = "";
        double mejorProm = -1.0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nombre del estudiante: ");
            String nombre = sc.next();
            double sumaNotas = 0.0;
            boolean errorNota = false;

            for (int j = 1; j <= 3; j++) {
                System.out.print("Nota " + j + ": ");
                double nota = sc.nextDouble();

                if (nota < 0.0 || nota > 20.0) {
                    errorNota = true;
                }
                sumaNotas = sumaNotas + nota;
            }

            if (errorNota == true) {
                System.out.printf("%s: nota inválida, no se considera%n", nombre);
            } else {
                double prom = sumaNotas / 3.0;

                String condicion = "";
                if (prom >= 11.0) {
                    condicion = "Aprobado";
                    aprobados++;
                } else {
                    condicion = "Desaprobado";
                }

                System.out.printf("%s: promedio %.2f - %s%n", nombre, prom, condicion);

                cantValidos++;
                sumPromedios = sumPromedios + prom;

                if (mejorAlumno.equals("") || prom > mejorProm) {
                    mejorProm = prom;
                    mejorAlumno = nombre;
                }
            }
        }

        if (cantValidos > 0) {
            double porc = ((double) aprobados / cantValidos) * 100.0;
            double promGeneral = sumPromedios / cantValidos;

            System.out.printf("Estudiantes considerados: %d%n", cantValidos);
            System.out.printf("Aprobados: %d (%.2f %%)%n", aprobados, porc);
            System.out.printf("Promedio general: %.2f%n", promGeneral);
            System.out.printf("Mejor promedio: %s (%.2f)%n", mejorAlumno, mejorProm);
        } else {
            System.out.println("Sin estudiantes válidos");
        }

        sc.close();
    }

}
