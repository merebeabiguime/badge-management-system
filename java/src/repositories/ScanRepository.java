package repositories;

import java.util.ArrayList;
import java.util.Date;

import entities.Scan;
import interfaces.IScanRepository;

public class ScanRepository implements IScanRepository {
    private ArrayList<Scan> scans;

    public ScanRepository() {
        scans = new ArrayList<Scan>();
        scans.add(new Scan(1, new Date(1999, 12, 31), "12:00:00", 1, false));
    }

    public ArrayList<Scan> getAllScans() {
        return scans;
    }

    public Scan getScan(int id) {
        for (Scan scan : scans) {
            if (scan.getId() == id) {
                return scan;
            }
        }
        return null;
    }

}
