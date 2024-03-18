package mappers;

import java.util.ArrayList;

import dtos.ScanDto;
import dtos.ScanListDto;
import entities.Scan;

public class ScanMapper {

    public static ScanListDto fromScanListToScanListDto(ArrayList<Scan> scans) {
        ScanListDto scanListDto = new ScanListDto();
        for (Scan scan : scans) {
            scanListDto.getScanList().add("heure:" + scan.getHeure() + " date:" + scan.getDate() + " id_utilisateur:"
                    + scan.getId_utilisateur() + " tentative_acces:" + scan.getTentative_acces());
        }
        return scanListDto;
    }

    public static ScanDto fromScanToScanDto(Scan scan) {
        ScanDto scanDto = new ScanDto();
        scanDto.setScan("heure:" + scan.getHeure() + " date:" + scan.getDate() + " id_utilisateur:"
                + scan.getId_utilisateur() + " tentative_acces:" + scan.getTentative_acces());
        return scanDto;

    }

}
