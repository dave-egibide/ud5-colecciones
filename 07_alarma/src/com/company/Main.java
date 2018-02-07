package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Alarma alarma = new Alarma();
        alarma.consultarSensores();
        int count = 0;
        while (count < 3 && alarma.isActivada()) {
            System.out.printf("Introduzca el PIN para desactivar la alarma. Tiene %d intentos: ", 3 - count++);
            alarma.desactivar(Integer.parseInt(br.readLine()));
            if (!alarma.isActivada()) System.out.println("Alarma desactivada.");
        }
        if (alarma.isActivada()) {
            System.out.println("No quedan intentos. Todo está mal.");
        } else System.out.println("Todo está bien.");
    }
}
