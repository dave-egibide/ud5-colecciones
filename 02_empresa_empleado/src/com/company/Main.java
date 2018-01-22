package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Empresa> empresas = new ArrayList<>();
        do {
            System.out.print("\n1. Crear nueva empresa.\n" +
                    "2. Añadir empleado a empresa ya existente.\n" +
                    "3. Listado de empresas.\n" +
                    "4. Listado detallado de empresas y empleados.\n" +
                    "5. Salir.\n" +
                    "Opción: ");
            input = br.readLine();
            switch (Integer.parseInt(input)) {
                case 1:
                    Empresa empresa = new Empresa();
                    System.out.print("Introduzca el nombre de la empresa: ");
                    empresa.setNombre(br.readLine());
                    System.out.print("Introduzca el año de fundación: ");
                    empresa.setAnyoFundacion(br.readLine());
                    empresas.add(empresa);
                    break;
                case 2:
                    System.out.print("Introduzca el nombre de la empresa a la que añadir el empleado: ");
                    int numEmpresa = encontrarEmpresa(br.readLine(), empresas);
                    if (numEmpresa != -1) {
                        Empleado empleado = new Empleado();
                        System.out.print("Introduzca el nombre del empleado: ");
                        empleado.setNombre(br.readLine());
                        System.out.print("Introduzca sus apellidos: ");
                        empleado.setApellidos(br.readLine());
                        System.out.print("Introduzca su año de nacimiento: ");
                        empleado.setFechaNacimiento(br.readLine());
                        System.out.print("Introduzca su fecha de contratación: ");
                        empleado.setFechaContrato(br.readLine());
                        empresas.get(numEmpresa).addEmpleado(empleado);
                    } else System.out.println("Empresa no encontrada.");
                    break;
                case 3:
                    visualizarEmpresas(empresas);
                    break;
                case 4:
                    visualizarEmpresasYEmpleados(empresas);
                    break;
            }
        } while (Integer.parseInt(input) != 5);
    }

    private static void visualizarEmpresasYEmpleados(List<Empresa> empresas) {
        for (Empresa empresa:
             empresas) {
            System.out.println(empresa.toString());
            System.out.println("Empleados: ");
            for (Empleado empleado: empresa.getEmpleadoset()) {
                System.out.println(empleado.toString());
            }
        }
    }

    private static void visualizarEmpresas(List<Empresa> empresas) {
        for (Empresa empresa: empresas) {
            System.out.println(empresa.toString());
        }
    }

    private static int encontrarEmpresa(String nombreEmpresa, List<Empresa> empresas) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getNombre().equalsIgnoreCase(nombreEmpresa)) return i;
        }
        return -1;
    }

}
