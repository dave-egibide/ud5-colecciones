package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alarma {
    private int pin, telefonoAviso;
    private boolean activada = false;
    private List<SensorMovimiento> sensorMovimientos = new ArrayList<>();

    public Alarma() {
        Random r = new Random();
        this.pin = 5555;
        this.telefonoAviso = 650300200;
        int numAlarmas = r.nextInt(4) + 1;
        for (int i = 0; i < numAlarmas; i++) {
            sensorMovimientos.add(new SensorMovimiento(this));
        }
    }

    public void consultarSensores() {
        int count = 1;
        for (SensorMovimiento sensores : sensorMovimientos) {
            if (sensores.hayMovimiento()) {
                activar();
                System.out.printf("¡Alarma! Sensor #%02d ha detectado movimiento.\n", count);
            }
            count++;
        }
        if (activada) System.out.println("Avisando al número de contacto " + telefonoAviso + ".");
    }

    public void activar() {
        activada = true;
    }

    public void desactivar(int pin) {
        if (pin == this.pin) activada = false;
    }

    public boolean isActivada() {
        return activada;
    }
}
