package com.company;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre, anyoFundacion;
    private List<Empleado> empleadoList = new ArrayList<>();

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

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void addEmpleado (Empleado empleado) {
        empleado.setEmpresa(this);
        empleadoList.add(empleado);
    }

    public void visualizarEmpleados () {
        for (Empleado empleado:empleadoList) {
            System.out.println(empleado.toString());
        }
    }

    public void ere () {
        for (Empleado empleado: empleadoList) {
            empleado.clearEmpresa();
        }
        empleadoList.clear();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Año de fundación: " + anyoFundacion;
    }
}
