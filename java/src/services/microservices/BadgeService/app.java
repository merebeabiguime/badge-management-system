package services.microservices.BadgeService;

import io.github.mihkels.dotenv.Dotenv;
import services.microservices.BadgeService.controllers.ShellHandlerController;
import services.microservices.BadgeService.interactors.ShellHandlerInteractor;
import services.microservices.BadgeService.models.ShellHandler;
import services.microservices.BadgeService.repositories.ShellHandlerRepository;

public class app {

    private static final String SCRIPT_PATH;

    static {
        Dotenv dotenv = Dotenv.load(); // Create a Dotenv instance
        SCRIPT_PATH = dotenv.get("SCRIPT_PATH"); // Use the instance to call get()
    }

    public static void main(String[] args) {
        while (true) {
            ShellHandler shellHandler = new ShellHandler(SCRIPT_PATH);
            ShellHandlerRepository shellHandlerRepository = new ShellHandlerRepository();
            ShellHandlerInteractor shellHandlerInteractor = new ShellHandlerInteractor(shellHandlerRepository);
            ShellHandlerController shellHandlerController = new ShellHandlerController(shellHandlerInteractor);
            shellHandlerController.handleService(shellHandler);
        }
    }

}
