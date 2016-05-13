package bl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import models.Ticket;
import dl.TicketDAO;

public class TicketService {
    private TicketDAO ticketDAO = new TicketDAO();

    public boolean addTicket(Ticket newTicket) {
        ArrayList<Ticket> tickets = ticketDAO.getTicketsFromDB();
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            if (ticket.getRow() == newTicket.getRow() && ticket.getNumber() == newTicket.getNumber()) {
                return false;
            }
        }
        return ticketDAO.addTicketInDB(newTicket);
    }

    public ArrayList<Ticket> getTickets() {
        return ticketDAO.getTicketsFromDB();

    }

    public void export(String tipExport) throws IOException {
        ArrayList<Ticket> tickets = getTickets();
        ExporterFactory exporterFactory = new ExporterFactory();
        Exporter exporter = exporterFactory.createExporter(tipExport);
        exporter.exportTickets(tickets);
    }
}
