package interfaces;

import java.util.ArrayList;

import entities.Scan;

public interface IScanInteractor {
    public ArrayList<Scan> getAllScans();

    public Scan getScan(int id);
}
