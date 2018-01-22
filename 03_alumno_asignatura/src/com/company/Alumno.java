package com.company;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre, apellidos, email;
    private List<Asignatura> asignaturas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAsignatura(Asignatura asignatura) {
        asignatura.addAlumno(this);
        asignaturas.add(asignatura);
    }

    @Override
    public String toString() {
        return apellidos + ", " + nombre + " (" +email + ")";
    }

    public void visualizarAsignaturasYTotal() {
        for (Asignatura asignatura: asignaturas) {
            System.out.println(asignatura.toString());
        }
        System.out.println("Total horas a la semana: " + this.horasSemanales());
    }
    public int horasSemanales() {
        int horas = 0;
        for (Asignatura asignatura: asignaturas) {
            horas += asignatura.getHorasSemanales();
        }
        return horas;
    }
}
