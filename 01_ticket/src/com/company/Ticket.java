package com.company;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    List<LineaTicket> tickets = new ArrayList<>();

    public String toString () {
        StringBuilder s = new StringBuilder();
        for (LineaTicket ticket : tickets) {
            s.append(ticket.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public int valorTotal () {
        int total = 0;
        for (LineaTicket ticket : tickets) {
            total += ticket.getPrecio();
        }
        return total;
    }

    public int unidadesTotal () {
        int total = 0;
        for (LineaTicket ticket : tickets) {
            total += ticket.getCantidad();
        }
        return total;
    }
}
