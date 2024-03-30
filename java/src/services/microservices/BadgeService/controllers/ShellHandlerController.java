package services.microservices.BadgeService.controllers;

import java.io.IOException;

import services.microservices.BadgeService.interfaces.IShellHandlerController;
import services.microservices.BadgeService.interfaces.IShellHandlerInteractor;
import services.microservices.BadgeService.models.ShellHandler;

public class ShellHandlerController implements IShellHandlerController {

    private IShellHandlerInteractor shellHandlerInteractor;

    public ShellHandlerController(IShellHandlerInteractor shellHandlerInteractor) {
        this.shellHandlerInteractor = shellHandlerInteractor;
    }

    public void handleService(ShellHandler shellHandler) {
        try {
            shellHandler.runService();
            shellHandler.waitForBadgeId();
            String response = this.shellHandlerInteractor.tryRegisteringBadge(shellHandler.getBadgeId());
            System.out.println(response);
            // processResponse(response);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
