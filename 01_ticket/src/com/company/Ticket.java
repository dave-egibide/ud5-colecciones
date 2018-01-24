package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Ticket {
    private int numero;
    private Calendar cal = Calendar.getInstance();
    private List<LineaTicket> tickets = new ArrayList<>();

    public Ticket (int numero) {
        this.numero = numero;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (LineaTicket ticket : tickets) {
            s.append(ticket.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public int valorTotal() {
        int total = 0;
        for (LineaTicket ticket : tickets) {
            total += ticket.getPrecio();
        }
        return total;
    }

    public int unidadesTotal() {
        int total = 0;
        for (LineaTicket ticket : tickets) {
            total += ticket.getCantidad();
        }
        return total;
    }

    public int length() {
        return tickets.size();
    }

    public Calendar getCal() {
        return cal;
    }

    public void getFecha() {
        System.out.printf("%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
    }

    public void getHora() {
        System.out.printf("%02d/%02d/%04d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }

    public int getNumero() {
        return numero;
    }

    public List<LineaTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<LineaTicket> tickets) {
        this.tickets = tickets;
    }
}

