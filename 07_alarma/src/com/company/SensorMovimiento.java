package com.company;

import java.util.Random;

public class SensorMovimiento {
    private Alarma alarma;
    private int umbral;

    public SensorMovimiento(Alarma alarma) {
        Random r = new Random();
        this.alarma = alarma;
        this.umbral = r.nextInt(100);
    }

    public boolean hayMovimiento() {
        Random r = new Random();
        return umbral < r.nextInt(100);
    }
}
