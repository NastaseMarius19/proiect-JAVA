package src.service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    public void add(String action){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileWriter fw = null;
        try {
            fw = new FileWriter("files/audit.csv",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.write(action + "," + timestamp + "," +  "\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
