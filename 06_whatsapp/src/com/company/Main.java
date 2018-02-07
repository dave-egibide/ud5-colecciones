package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Contacto> contactoMap = new LinkedHashMap<>();
        Map<String, Contacto> contactoTreeMap = new TreeMap<>();
        String input;
        do {
            System.out.println("\n" +
                    "   1) Gestión de contactos\n" +
                    "        Nuevo contacto.\n" +
                    "        Eliminar contacto.\n" +
                    "   2) Búsqueda\n" +
                    "        Buscar contacto por número de teléfono.\n" +
                    "        Buscar contacto por nombre.\n" +
                    "   3) Listados\n" +
                    "        Listado de todos los contactos, tal como se han añadido.\n" +
                    "        Listado de todos los contactos, ordenados por número de teléfono.\n" +
                    "   4) Salir");
            System.out.print("Introduzca la opción deseada: ");
            input = br.readLine();
            switch (input) {
                case "1":
                    // Gestión de contactos
                    System.out.println("   1) Nuevo contacto.\n" +
                            "   2) Eliminar contacto.");
                    System.out.print("Introduzca la opción deseada: ");
                    input = br.readLine();
                    switch (input) {
                        case "1":
                            // nuevo contacto
                            System.out.print("Introduzca el número de teléfono: ");
                            String telefono = br.readLine();
                            System.out.print("Introduzca el nombre del contacto: ");
                            String nombre = br.readLine();
                            System.out.print("Introduzca los apellidos del contacto: ");
                            String apellidos = br.readLine();
                            System.out.print("Introduzca el email del contacto: ");
                            String email = br.readLine();
                            contactoMap.put(telefono, new Contacto(nombre, apellidos, email));
                            contactoTreeMap.put(telefono, new Contacto(nombre, apellidos, email));
                            break;
                        case "2":
                            // eliminar contacto
                            visualizarContactos(contactoMap);
                            System.out.print("Introduzca el número del contacto que desea eliminar: ");
                            input = br.readLine();
                            contactoMap.remove(input);
                            contactoTreeMap.remove(input);
                            break;
                    }
                    break;
                case "2":
                    // Búsqueda
                    System.out.println("   1) Buscar contacto por número de teléfono.\n" +
                            "   2) Buscar contacto por nombre.");
                    System.out.print("Introduzca la opción deseada: ");
                    input = br.readLine();
                    switch (input) {
                        case "1":
                            // buscar contacto por teléfono
                            System.out.print("Introduzca el número de teléfono a buscar: ");
                            System.out.println(contactoMap.get(br.readLine()));
                            break;
                        case "2":
                            // buscar contacto por nombre
                            System.out.print("Introduzca el nombre del contacto a buscar: ");
                            buscarNombreContacto(contactoMap, br.readLine());
                            break;
                    }
                    break;
                case "3":
                    // Listados
                    System.out.println("   1) Listado de todos los contactos, tal como se han añadido.\n" +
                            "   2) Listado de todos los contactos, ordenados por número de teléfono.");
                    System.out.print("Introduzca la opción deseada: ");
                    input = br.readLine();
                    switch (input) {
                        case "1":
                            // listado de contactos por orden natural
                            System.out.println("Lista de contactos:");
                            visualizarContactos(contactoMap);
                            break;
                        case "2":
                            // listado de contactos por número
                            System.out.println("Lista de contactos por número:");
                            visualizarContactosPorNumero(contactoTreeMap);
                            break;
                    }
                    break;
                case "4":
                    System.out.println("Finalizando.");
                    break;
            }
        } while (!input.equals("4"));
    }

    private static void visualizarContactosPorNumero(Map<String, Contacto> contactoTreeMap) {
            contactoTreeMap.forEach((k,v) ->System.out.println("-" + k + " - " + v.toString()));
    }

    private static void buscarNombreContacto(Map<String, Contacto> contactoMap, String nombre) {
        contactoMap.forEach((k, v) -> {
            if (v.getNombre().equalsIgnoreCase(nombre)) System.out.println("-" + k + " - " + v.toString());
        });
    }

    private static void visualizarContactos(Map<String, Contacto> contactoMap) {
        contactoMap.forEach((k, v) -> System.out.println("-" + k + " - " + v.toString()));
    }
}