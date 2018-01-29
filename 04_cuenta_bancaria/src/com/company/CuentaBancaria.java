package com.company;

import java.util.*;

public class CuentaBancaria {
    private List<Apunte> apuntes = new ArrayList<>();
    private Map<String, Titular> titularMap = new Hashtable<>();

    public List<Apunte> getApuntes() {
        return apuntes;
    }

    public void setApuntes(List<Apunte> apuntes) {
        this.apuntes = apuntes;
    }

    public Map<String, Titular> getTitularMap() {
        return titularMap;
    }

    public void setTitularMap(Map<String, Titular> titularMap) {
        this.titularMap = titularMap;
    }

    public void addTitular(String DNI, Map titularMap) {
        titularMap.put(DNI ,titularMap.get(DNI));
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
}
