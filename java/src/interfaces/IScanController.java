package interfaces;

import java.util.ArrayList;

import entities.Scan;

public interface IScanController {
    public ArrayList<Scan> onGetAllScans();

    public Scan onGetScan(int id);

}
