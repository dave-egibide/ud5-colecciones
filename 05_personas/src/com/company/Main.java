package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Set<Persona> personaSet1 = new HashSet<>();
        Set<Persona> personaSet2 = new HashSet<>();

        /*
        do {
            creadorPersonas(personaSet1, 1);
        } while (personaSet1.size() < 5);
        do {
            creadorPersonas(personaSet2, 2);
        } while (personaSet2.size() < 5);
        */

        personaSet1.add(new Persona("10","David"));
        personaSet1.add(new Persona("20","Daved"));
        personaSet1.add(new Persona("30","Davod"));
        personaSet1.add(new Persona("40","Davud"));
        personaSet1.add(new Persona("50","Davad"));

        personaSet2.add(new Persona("10","David"));
        personaSet2.add(new Persona("20","Daved"));
        personaSet2.add(new Persona("30","Davod"));
        personaSet2.add(new Persona("60","Dovid"));
        personaSet2.add(new Persona("70","Duvid"));


        System.out.println("\nConjunto 1:");
        visualizarConjunto(personaSet1);
        System.out.println("\nConjunto 2:");
        visualizarConjunto(personaSet2);

        System.out.println("\nUnión sin duplicados:");
        visualizarSinDuplicados(personaSet1, personaSet2);
        System.out.println("\nUnión con duplicados:");
        visualizarConDuplicados(personaSet1, personaSet2);
        System.out.println("\nDiferencia:");
        visualizarDiferentes(personaSet1, personaSet2);
        System.out.println("\nIntersección:");
        visualizarComunes(personaSet1, personaSet2);

    }

    private static void visualizarConDuplicados(Set<Persona> personaSet1, Set<Persona> personaSet2) {
        visualizarConjunto(personaSet1);
        visualizarConjunto(personaSet2);
    }

    private static void visualizarComunes(Set<Persona> personaSet1, Set<Persona> personaSet2) {
        Set<Persona> personaSetUnion = new HashSet<>();
        personaSetUnion.addAll(personaSet1);
        personaSetUnion.retainAll(personaSet2);
        visualizarConjunto(personaSetUnion);
    }

    private static void visualizarDiferentes(Set<Persona> personaSet1, Set<Persona> personaSet2) {
        Set<Persona> personaSetUnion = new HashSet<>();
        personaSetUnion.addAll(personaSet1);
        personaSetUnion.removeAll(personaSet2);
        visualizarConjunto(personaSetUnion);
    }

    private static void visualizarSinDuplicados(Set<Persona> personaSet1, Set<Persona> personaSet2) {
        Set<Persona> personaSetUnion = new HashSet<>();
        personaSetUnion.addAll(personaSet1);
        personaSetUnion.addAll(personaSet2);
        visualizarConjunto(personaSetUnion);
    }

    private static void creadorPersonas(Set<Persona> personaSet, int i) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Escriba el nombre de la persona #%d del conjunto #%d: ", personaSet.size() + 1, i);
        String nombre = br.readLine();
        System.out.printf("Escriba el DNI de la persona #%d del conjunto #%d: ", personaSet.size() + 1, i);
        String DNI = br.readLine();
        personaSet.add(new Persona(DNI, nombre));
    }

    private static void visualizarConjunto(Set<Persona> conjunto) {
        for (Persona persona : conjunto) {
            System.out.println("-" + persona.toString());
        }
    }
}
