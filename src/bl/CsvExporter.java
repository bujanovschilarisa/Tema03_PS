package bl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import models.Ticket;

public class CsvExporter implements Exporter {

    @Override
    public boolean exportTickets(ArrayList<Ticket> tickets) {
        String csv = "export.csv";
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(csv), ';');
            // Create record
            String[] record = new String[] { "Nume Spectacol", "Numar bilet", "Rand" };
            // Write the record to file
            writer.writeNext(record);
            for (int i = 0; i < tickets.size(); i++) {
                Ticket ticket = tickets.get(i);
                // Create record
                record = new String[] { String.valueOf(ticket.getNameShow()), String.valueOf(ticket.getNumber()),
                        String.valueOf(ticket.getRow()) };
                // Write the record to file
                writer.writeNext(record);
            }
            // close the writer
            try {
                writer.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
