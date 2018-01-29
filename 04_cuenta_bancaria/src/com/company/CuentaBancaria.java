package com.company;

import java.util.*;

public class CuentaBancaria {
    private List<Apunte> apuntes = new ArrayList<>();
    private Map<String, Titular> titularMap = new Hashtable<>();

    public List<Apunte> getApuntes() {
        return apuntes;
    }

    public Map<String, Titular> getTitularMap() {
        return titularMap;
    }

    public void addTitular(String DNI, Map<String, Titular> titularMap) {
        this.titularMap.put(DNI ,titularMap.get(DNI));
    }

    public double getSaldo() {
        double saldo = 0;
        for (Apunte apunte : apuntes) {
            saldo += apunte.getCantidad();
        }
        return saldo;
    }
    public int numTitulares() {
        return titularMap.size();
    }

    public void vincularTitulares(String numCuenta) {
        titularMap.forEach((k,v) -> titularMap.get(k).getCuentaBancariaMap().put(numCuenta, this));

    }

    public void visualizarTitulares() {
        titularMap.forEach((k,v) -> System.out.println(k + " - " + titularMap.get(k).toString()));
    }

    public void addApunte(Apunte apunte) {
        apunte.setCuentaBancaria(this);
        apuntes.add(apunte);
    }

    public void desvincularTitulares(String numCuenta) {
        titularMap.forEach((k,v) -> titularMap.get(k).getCuentaBancariaMap().remove(numCuenta));
    }
}
