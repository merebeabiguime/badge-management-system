public class ScanController implements IScanController {
    private IScanInteractor scanInteractor;

    public ScanController(IScanInteractor scanInteractor, int userRole) {
        if (userRole != 1) {
            throw new AccessDeniedException("Vous n'avez pas le droit d'accéder à cette ressource");
        }
        this.scanInteractor = scanInteractor;
    }

    public ArrayList<Scan> onGetAllScans() {
        return scanInteractor.getAllScans();
    }

    public Scan onGetScan(int id) {
        return scanInteractor.getScan(id);
    }

}
