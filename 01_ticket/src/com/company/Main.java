package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Ticket t = new Ticket();


        do {
            LineaTicket tick = new LineaTicket(t);
            System.out.print("Introduzca el nombre del producto: ");
            tick.setProducto(br.readLine());
            System.out.print("Introduzca el precio del producto: ");
            tick.setPrecio(Double.parseDouble(br.readLine()));
            System.out.print("Introduzca las unidades del producto: ");
            tick.setCantidad(Integer.parseInt(br.readLine()));
            t.tickets.add(tick);

            System.out.print("¿Desea añadir otro producto? (Si/No): ");
            input = br.readLine();

        } while (input.equalsIgnoreCase("si"));

        System.out.println("\nTicket:");
        System.out.println(t.toString());
        System.out.println("Líneas totales: " + t.tickets.size());
        System.out.println("Unidades: " + t.unidadesTotal());
        System.out.println("Precio total: " + t.valorTotal());

    }
}
