package ui;

import controllers.ScanController;
import repositories.ScanRepository;
import usecases.ScanInteractor;

public class App {
    public static void main(String[] args) throws Exception {
        ScanRepository scanRepository = new ScanRepository();
        ScanInteractor scanInteractor = new ScanInteractor(scanRepository);
        ScanController scanController = new ScanController(scanInteractor);

        System.out.println("Premier scan : \n" + scanController.onGetScan("{\"id\":10, \"userRole\":1}"));
    }
}
