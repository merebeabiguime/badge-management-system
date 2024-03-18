package interfaces;

import java.util.ArrayList;
import entities.Scan;

public interface IScanRepository {
    public ArrayList<Scan> getAllScans();

    public Scan getScan(int id);

}
