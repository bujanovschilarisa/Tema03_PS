package bl;

import java.util.ArrayList;

import models.Ticket;

public interface Exporter {
    
    public boolean exportTickets(ArrayList<Ticket> tickets);

}
