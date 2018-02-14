package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Empresa> empresas = new ArrayList<>();
        String input;

        do {
            System.out.println("\n" +
                    "   1) Empresa\n" +
                    "        Crear nueva empresa\n" +
                    "        Borrar una empresa\n" +
                    "   2) Añadir empleados (a una empresa)\n" +
                    "        Añadir operario\n" +
                    "        Añadir directivo\n" +
                    "        Listar empleados (de la empresa)\n" +
                    "   3) Listados\n" +
                    "        Todas las empresas\n" +
                    "        Todos los empleados\n" +
                    "        Listado por empresa y empleado\n" +
                    "   4) Salir\n");
            System.out.print("Introduzca una opción: ");
            input = br.readLine();
            switch (input) {
                case "1":
                    // empresa
                    System.out.println("       1) Crear nueva empresa\n" +
                            "       2) Borrar una empresa\n");
                    System.out.print("Introduzca una opción: ");
                    input = br.readLine();
                    switch (input) {
                        case "1":
                            // crear empresa
                            Empresa empresa = new Empresa();
                            System.out.print("Introduzca el nombre de la empresa: ");
                            empresa.setNombre(br.readLine());
                            System.out.print("Introduzca el año de fundación: ");
                            empresa.setAnyoFundacion(br.readLine());
                            empresas.add(empresa);
                            break;
                        case "2":
                            // eliminar empresa
                            if (empresas.size() > 0) {
                                visualizarEmpresas(empresas);
                                System.out.print("Introduzca el número de la empresa que desea eliminar: ");
                                eliminarEmpresa(empresas, Integer.parseInt(br.readLine()) - 1);
                            } else System.out.println("No hay empresas añadidas.");
                            break;
                    }
                    break;
                case "2":
                    if (empresas.size() > 0) {
                        visualizarEmpresas(empresas);
                        System.out.print("Introduzca el número de la empresa a tratar: ");
                        int numEmpresa = Integer.parseInt(br.readLine()) - 1;
                        // añadir empleados a empresa
                        System.out.println("   1) Añadir operario\n" +
                                "   2) Añadir directivo\n" +
                                "   3) Listar empleados (de la empresa)\n");
                        System.out.print("Introduzca una opción: ");
                        input = br.readLine();
                        if (input.equals("1") || input.equals("2")) {
                            System.out.print("Introduzca el nombre del empleado: ");
                            String nombre = br.readLine();
                            System.out.print("Introduzca sus apellidos: ");
                            String apellidos = br.readLine();
                            System.out.print("Introduzca su año de nacimiento: ");
                            String fechaNacimiento = br.readLine();
                            System.out.print("Introduzca su fecha de contratación: ");
                            String fechaContrato = br.readLine();
                            switch (input) {
                                case "1":
                                    // añadir operario
                                    System.out.print("Introduzca el salario por horas que recibe: ");
                                    double salarioHora = Double.parseDouble(br.readLine());
                                    System.out.print("Introduzca el número de horas por las que está contratado: ");
                                    int horasContrato = Integer.parseInt(br.readLine());
                                    empresas.get(numEmpresa).addEmpleado(new Operario(nombre, apellidos, fechaNacimiento, fechaContrato, salarioHora, horasContrato));
                                    System.out.println("Operario añadido correctamente.");
                                    break;
                                case "2":
                                    // añadir directivo
                                    System.out.print("Introduzca el salario anual que recibe: ");
                                    double salarioAnual = Double.parseDouble(br.readLine());
                                    System.out.print("Introduzca el bonus personal que recibe: ");
                                    double bonusPersonal = Double.parseDouble(br.readLine());
                                    empresas.get(numEmpresa).addEmpleado(new Directivo(nombre, apellidos, fechaNacimiento, fechaContrato, salarioAnual, bonusPersonal));
                                    System.out.println("Directivo añadido correctamente.");
                                    break;
                                case "3":
                                    // listar empleados
                                    empresas.get(numEmpresa).visualizarEmpleados();
                            }
                        }
                    } else System.out.println("No hay empresas añadidas.");
                    break;
                case "3":
                    // listados
                    System.out.println("   1) Todas las empresas\n" +
                            "   2) Todos los empleados\n" +
                            "   3) Listado por empresa y empleado\n");
                    System.out.print("Introduzca una opción: ");
                    input = br.readLine();
                    switch (input) {
                        case "1":
                            //listar todas las empresas
                            visualizarEmpresas(empresas);
                            break;
                        case "2":
                            //listar empleados
                            for (Empresa empresa: empresas) {
                                empresa.visualizarEmpleados();
                            }
                            break;
                        case "3":
                            //listar todo
                            for (Empresa empresa: empresas) {
                                System.out.println(empresa.toString());
                                empresa.visualizarEmpleados();
                            }
                    }
                    break;
                case "4":
                    System.out.println("Finalizando.");
            }
        } while (!input.equalsIgnoreCase("4"));
    }

    private static void eliminarEmpresa(List<Empresa> empresas, int numero) {
        empresas.get(numero).ere();
        empresas.remove(numero);
    }

    private static void visualizarEmpresas(List<Empresa> empresasList) {
        int count = 1;
        for (Empresa empresas : empresasList) {
            System.out.println(count++ + ") " + empresas.toString());
        }
    }
}
