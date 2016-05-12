package bl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import models.Ticket;
import dl.TicketDAO;

public class TicketService {
    private TicketDAO ticketDAO = new TicketDAO();
    private static final String CSV = "CSV";
    private static final String JSON = "JSON";

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
        Exporter exporter = null;
        ArrayList<Ticket> tickets = getTickets();
        if (CSV.equals(tipExport)) {
            exporter = (Exporter) new CsvExporter();
        } else if (JSON.equals(tipExport)) {
            exporter = new JsonExporter();
        }
        exporter.exportTickets(tickets);
    }
}
