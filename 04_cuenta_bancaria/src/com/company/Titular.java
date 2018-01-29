package com.company;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

public class Titular {
    private String nombre, apellidos;
    private Calendar fechaAlta = Calendar.getInstance();
    private Map<String, CuentaBancaria> cuentaBancariaMap = new Hashtable<>();

    public Titular (String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    public void getFechaAlta() {
        System.out.printf("%02d/%02d/%04d",fechaAlta.get(Calendar.DAY_OF_MONTH), fechaAlta.get(Calendar.MONTH) + 1, fechaAlta.get(Calendar.YEAR));
    }

    public Map<String, CuentaBancaria> getCuentaBancariaMap() {
        return cuentaBancariaMap;
    }


    public void visualizarCuentas() {
        cuentaBancariaMap.forEach((k,v) ->{
            System.out.print("Núm. cuenta: " + k);
            System.out.println(" - Saldo: " +cuentaBancariaMap.get(k).getSaldo());
        });
    }

    @Override
    public String toString() {
        return nombre + (" ") + apellidos;
    }


}
