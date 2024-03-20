package interfaces;

import java.util.ArrayList;

import entities.Scan;

public interface IScanInteractor {
    public ArrayList<Scan> getAllScans(int userRole);

    public Scan getScan(int userRole, int userId);

    public Scan scanBadge(int userId);
}
