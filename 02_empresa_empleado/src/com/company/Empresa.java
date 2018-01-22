package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Empresa {
    private String nombre, anyoFundacion;
    private Set<Empleado> empleadoset = new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnyoFundacion() {
        return anyoFundacion;
    }

    public void setAnyoFundacion(String anyoFundacion) {
        this.anyoFundacion = anyoFundacion;
    }

    public Set<Empleado> getEmpleadoset() {
        return empleadoset;
    }

    public void addEmpleado (Empleado empleado) {
        empleado.setEmpresa(this);
        empleadoset.add(empleado);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Año de fundación: " + anyoFundacion;
    }
}
