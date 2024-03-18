public class ScanInteractor implements IScan {
    private IScanRepository scanRepository;

    public ScanInteractor(IScanRepository scanRepository) {
        this.scanRepository = scanRepository;
    }

    @Override
    public ArrayList<Scan> getAllScans() {
        return scanRepository.getAllScans();
    }

    @Override
    public Scan getScan(int id) {
        return scanRepository.getScan(id);
    }

}