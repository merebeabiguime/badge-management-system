package services;

import interfaces.IBadgeHandlerService;
import interfaces.IScanController;

public class BadgeHandlerService implements IBadgeHandlerService {

    private Integer badgeId;
    private IScanController controller;

    public BadgeHandlerService(IScanController controller) {
        this.badgeId = null;
        this.controller = controller;
    }

    public synchronized int waitForBadgeChange() {
        try {
            wait(5000); // Wait for 5 seconds or until badgeId changes(when notify is called)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.badgeId;
    }

    public synchronized String userHasScanned(int newBadgeId) {

        this.badgeId = newBadgeId;
        notify();
        String JsonInput = "{\"badgeId\":" + newBadgeId + "}";

        return controller.onScanBadge(JsonInput); // Returns the response from the scan
    }

}
