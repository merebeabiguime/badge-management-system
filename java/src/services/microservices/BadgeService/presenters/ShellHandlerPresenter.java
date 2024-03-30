package services.microservices.BadgeService.presenters;

import services.microservices.BadgeService.interfaces.IShellHandlerPresenter;

public class ShellHandlerPresenter implements IShellHandlerPresenter {
    public void processResponse(String response) {
        // Implement logic to handle different response types
        // For example:
        if (response.equals("scan_ok")) {
            // Call View
        } else if (response.equals("scan_error")) {
            // Call View
        } else if (response.equals("badge_not_registered")) {
            // Call View
        } else {
            System.out.println("caca");
        }
        System.out.println("pipi");
    }
}
