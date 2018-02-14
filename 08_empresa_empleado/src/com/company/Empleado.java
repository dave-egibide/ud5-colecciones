package com.company;

public abstract class Empleado {
    private String nombre, apellidos, fechaNacimiento, fechaContrato;
    private Empresa empresa;

    public Empleado(String nombre, String apellidos, String fechaNacimiento, String fechaContrato) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContrato = fechaContrato;
    }

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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void clearEmpresa () {
        empresa = null;
    }

    public String toString() {
        return " Nombre: " +apellidos + ", " + nombre +
                "\n    Fecha de nacimiento: " + fechaNacimiento +
                "\n    Fecha de contrato: " + fechaContrato;
    }
}
