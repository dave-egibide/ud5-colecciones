package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Alumno> alumnos = new ArrayList<>();
        List<Asignatura> asignaturas = new ArrayList<>();
        String input;

        do {
            System.out.print("\n1.  Crear nuevo alumno.\n" +
                    "2.  Crear nueva asignatura.\n" +
                    "3.  Matricular alumno en asignatura.\n" +
                    "4.  Listado de alumnos matriculados en una asignatura.\n" +
                    "5.  Listado de asignaturas en las que está matriculado un alumno y total de horas.\n" +
                    "6.  Salir\n" +
                    "Introduzca opción: ");
            input = br.readLine();

            switch (Integer.parseInt(input)) {
                case 1:
                    //nuevo alumno
                    Alumno alumno = new Alumno();
                    System.out.print("Introduzca el nombre del alumno: ");
                    alumno.setNombre(br.readLine());
                    System.out.print("Introduzca sus apellidos: ");
                    alumno.setApellidos(br.readLine());
                    System.out.print("Introduzca su email: ");
                    alumno.setEmail(br.readLine());
                    alumnos.add(alumno);
                    break;
                case 2:
                    //nueva asignatura
                    Asignatura asignatura = new Asignatura();
                    System.out.print("Introduzca el nombre de la asignatura: ");
                    asignatura.setNombre(br.readLine());
                    System.out.print("Introduzca sus horas a la semana: ");
                    asignatura.setHorasSemanales(Integer.parseInt(br.readLine()));
                    asignaturas.add(asignatura);
                    break;
                case 3:
                    //matricular alumno
                    visualizarNombreAlumnos(alumnos);
                    System.out.print("Introduzca el número del alumno a matricular: ");
                    int numAlumno = Integer.parseInt(br.readLine());
                    visualizarNombreAsignaturas(asignaturas);
                    System.out.print("Introduzca el número de la asignatura en la que matricularle: ");
                    alumnos.get(numAlumno - 1).addAsignatura(asignaturas.get(Integer.parseInt(br.readLine()) - 1));
                    break;
                case 4:
                    //alumnos en asignatura
                    visualizarNombreAsignaturas(asignaturas);
                    System.out.print("Introduzca el número de la asignatura: ");
                    asignaturas.get(Integer.parseInt(br.readLine()) - 1).visualizarAlumnos();
                    break;
                case 5:
                    //asignaturas de alumno
                    visualizarNombreAlumnos(alumnos);
                    System.out.print("Introduzca el número de alumno: ");
                    alumnos.get(Integer.parseInt(br.readLine()) - 1).visualizarAsignaturasYTotal();
                    break;
            }

        } while (Integer.parseInt(input) != 6);
    }

    private static void visualizarNombreAsignaturas(List<Asignatura> asignaturas) {
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println(i + 1 + ". " + asignaturas.get(i).getNombre());
        }
    }

    private static void visualizarNombreAlumnos(List<Alumno> alumnos) {
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getApellidos() + ", " + alumnos.get(i).getNombre());
        }
    }
}
