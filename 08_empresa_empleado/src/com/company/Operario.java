package com.company;

public class Operario extends Empleado {
    private double salarioHora;
    private int horasContrato;

    public Operario(String nombre, String apellidos, String fechaNacimiento, String fechaContrato, double salarioHora, int horasContrato) {
        super(nombre, apellidos,fechaNacimiento,fechaContrato);
        this.salarioHora = salarioHora;
        this.horasContrato = horasContrato;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHorasContrato() {
        return horasContrato;
    }

    public void setHorasContrato(int horasContrato) {
        this.horasContrato = horasContrato;
    }

    @Override
    public String toString() {
        return super.toString() + "\n    Salario/hora: " + salarioHora +
                "\n    Horas de contrato: " + horasContrato;
    }
}
