package services.microservices.BadgeService.interactors;

import services.microservices.BadgeService.interfaces.IShellHandlerInteractor;
import services.microservices.BadgeService.interfaces.IShellHandlerRepository;

public class ShellHandlerInteractor implements IShellHandlerInteractor {

    private IShellHandlerRepository repository;

    public ShellHandlerInteractor(IShellHandlerRepository repository) {
        this.repository = repository;
    }

    public String tryRegisteringBadge(String badgeId) {
        String response = repository.sendBadgeId(badgeId);
        return response;
    }
}
