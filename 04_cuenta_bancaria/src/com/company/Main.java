package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, CuentaBancaria> cuentaBancariaMap = new Hashtable<>();
        Map<String, Titular> titularMap = new Hashtable<>();
        String input, innerInput;
        int numCuenta = 1;

        do {
            System.out.print("1) Titular\n" +
                    "    i. Nuevo titular\n" +
                    "2) Cuenta bancaria\n" +
                    "    i. Nueva cuenta\n" +
                    "    ii. Nuevo apunte\n" +
                    "    iii. Borrar cuenta\n" +
                    "3) Consultas\n" +
                    "    i. Dado un titular, saldo de todas sus cuentas\n" +
                    "    ii. Dada una cuenta, titulares asociados\n" +
                    "4) Salir\n" +
                    "Introduzca una opción: ");
            input = br.readLine();
            if (Integer.parseInt(input) != 4) {
                switch (Integer.parseInt(input)) {
                    case 1:
                        //nuevo titular
                        System.out.print("Introduzca el nombre del titular: ");
                        String nombre = br.readLine();
                        System.out.print("Introduzca los apellidos del titular: ");
                        String apellidos = br.readLine();
                        System.out.print("Introduzca el DNI del titular: ");
                        String DNI = br.readLine();
                        System.out.println();
                        if (!titularMap.containsKey(DNI) || !DNI.equals("0")) {
                            titularMap.put(DNI, new Titular(nombre, apellidos));
                            System.out.println("Titular creado correctamente.");
                        } else System.out.println("DNI inválido. Registro cancelado.");
                        break;
                    case 2:
                        System.out.print("1) Nueva cuenta\n" +
                                "2) Nuevo apunte\n" +
                                "3) Borrar cuenta\n" +
                                "Introduzca una opción: ");
                        innerInput = br.readLine();
                        switch (Integer.parseInt(innerInput)) {
                            case 1:
                                if (titularMap.size() > 0) {
                                    CuentaBancaria cuenta = new CuentaBancaria();
                                    do {
                                        System.out.println("Lista de posibles titulares:");
                                        visualizarTitulares(titularMap);
                                        System.out.print("Introduzca el DNI de un titular de la cuenta o 0 para terminar: ");
                                        innerInput = br.readLine();
                                        if (titularMap.containsKey(innerInput)) {
                                            cuenta.addTitular(innerInput, titularMap);
                                            System.out.println(innerInput + " agregado correctamente.");
                                        }
                                    } while (!innerInput.equals("0"));
                                    if (cuenta.numTitulares() > 0) {
                                        cuentaBancariaMap.put(String.valueOf(numCuenta), cuenta);
                                        cuentaBancariaMap.get(String.valueOf(numCuenta)).vincularTitulares(String.valueOf(numCuenta));
                                        numCuenta++;
                                        System.out.println("Cuenta creada correctamente.");
                                    }
                                }
                                break;
                            case 2:
                                //nuevo apunte
                                if (cuentaBancariaMap.size() > 0) {
                                    System.out.println("Listado cuentas:");
                                    visualizarCuentas(cuentaBancariaMap);
                                    System.out.print("Introduzca el núm. de cuenta en el que hacer un apunte: ");
                                    innerInput = br.readLine();
                                    if (cuentaBancariaMap.containsKey(innerInput)) {
                                        System.out.print("Introduzca la cantidad (positiva o negativa) a sumar: ");
                                        cuentaBancariaMap.get(innerInput).addApunte(new Apunte(Double.parseDouble(br.readLine())));
                                        System.out.println("Apunte creado correctamente.");
                                    }
                                }
                                break;
                            case 3:
                                //borrar cuenta
                                if (cuentaBancariaMap.size() > 0) {
                                    System.out.println("Listado cuentas:");
                                    visualizarCuentas(cuentaBancariaMap);
                                    System.out.print("Introduzca el núm. de cuenta a eliminar: ");
                                    innerInput = br.readLine();
                                    if (cuentaBancariaMap.containsKey(innerInput)) {
                                        cuentaBancariaMap.get(innerInput).desvincularTitulares(innerInput);
                                        cuentaBancariaMap.get(innerInput).eliminarApuntes();
                                        cuentaBancariaMap.remove(innerInput);
                                        System.out.println("Cuenta eliminada correctamente.");
                                    }
                                }
                                break;
                        }
                        break;
                    case 3:
                        System.out.print("1) Dado un titular, saldo de todas sus cuentas\n" +
                                "2) Dada una cuenta, titulares asociados\n" +
                                "Introduzca una opción: ");
                        innerInput = br.readLine();
                        switch (Integer.parseInt(innerInput)) {
                            case 1:
                                //saldo de un titular
                                if (titularMap.size() > 0) {
                                    System.out.println("Listado titulares:");
                                    visualizarTitulares(titularMap);
                                    System.out.print("Introduzca el DNI del titular a comprobar: ");
                                    titularMap.get(br.readLine()).visualizarCuentas();
                                }
                                break;
                            case 2:
                                //titulares de una cuenta
                                if (cuentaBancariaMap.size() > 0) {
                                    System.out.println("Listado cuentas:");
                                    visualizarCuentas(cuentaBancariaMap);
                                    System.out.print("Introduzca el núm. de cuenta a comprobar: ");
                                    cuentaBancariaMap.get(br.readLine()).visualizarTitulares();
                                }
                        }
                }
                System.out.println();
            }
        } while (Integer.parseInt(input) != 4);
    }

    private static void visualizarTitulares(Map titulares) {
        titulares.forEach((k, v) -> System.out.println(v.toString() + " - " + k));
    }

    private static void visualizarCuentas(Map cuentas) {
        cuentas.forEach((k, v) -> System.out.println(k));
    }
}
