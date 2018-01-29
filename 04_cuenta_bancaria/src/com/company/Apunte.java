package com.company;

import java.util.Calendar;

public class Apunte {
    private double cantidad;
    private Calendar fecha = Calendar.getInstance();
    private CuentaBancaria cuentaBancaria;

    public Apunte (double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
    public void getFecha() {
        System.out.printf("%02d/%02d/%04d",fecha.get(Calendar.DAY_OF_MONTH), fecha.get(Calendar.MONTH) + 1, fecha.get(Calendar.YEAR));
    }
}
