package interfaces;

public interface IBadgeHandlerService {
    public int waitForBadgeChange();

    public String userHasScanned(int newBadgeId);

}
