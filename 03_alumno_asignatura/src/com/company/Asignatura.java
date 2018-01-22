package com.company;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private String nombre;
    private int horasSemanales;
    private List<Alumno> alumnos = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void visualizarAlumnos() {
        for (Alumno alumno:
             alumnos) {
            System.out.println(alumno.toString());
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + horasSemanales + " horas semanales)";
    }
}
