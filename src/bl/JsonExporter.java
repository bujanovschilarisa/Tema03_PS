package bl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import models.Ticket;

public class JsonExporter implements Exporter {

    @Override
    public boolean exportTickets(ArrayList<Ticket> tickets) {
        Gson gson = new Gson();

        try {
            FileWriter fw = new FileWriter("export.json");
            gson.toJson(tickets, new FileWriter("export.json"));
            String jsonInString = gson.toJson(tickets);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(jsonInString);
            bw.close();
            return true;
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
