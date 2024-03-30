package services.microservices.BadgeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.github.mihkels.dotenv.Dotenv;

class MockController {

    public static String onScanBadge(String jsonInput) {
        return "\"status\":\"success\",\"code\":\"200\",\"message\":\"Badge scanned successfully\",\"data\":\"{\\\"badgeId\\\":10}\"";
    }
}

public class ShellScriptHandlerService {

    private static final String SCRIPT_PATH;

    static {
        Dotenv dotenv = Dotenv.load(); // Create a Dotenv instance
        SCRIPT_PATH = dotenv.get("SCRIPT_PATH"); // Use the instance to call get()
    }

    // Méthode quand le scan a marcher
    // Méthode quand le scan n'a pas marcher(hors horaire)
    // Méthode quand le scan n'a pas marcher(Erreur ou badge non enregistré)

    private final void runService() throws IOException, InterruptedException {
        // Lancer le script shell en tant que processus et obtenir son flux de sortie
        ProcessBuilder processBuilder = new ProcessBuilder(SCRIPT_PATH);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Attendre que l'utilisateur scanne son badge et lire l'ID du badge
        String badgeId = reader.readLine();

        // Fermer le flux de sortie du processus
        reader.close();

        // Appeler le controleur
        String response = MockController.onScanBadge("{\"badgeId\":" + badgeId + "}");
        System.out.println(response);
        // Attendre la réponse puis appeler les méthodes appropriées avant de relancer
        // le script shell
        processResponse(response);
    }

    private void processResponse(String response) {
        // Implement logic to handle different response types
        // For example:
        if (response.equals("scan_ok")) {
            // Handle successful scan
        } else if (response.equals("scan_error")) {
            // Handle scan error
        } else if (response.equals("badge_not_registered")) {
            // Handle unregistered badge
        } else {
            System.out.println("caca");
        }
        System.out.println("pipi");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ShellScriptHandlerService shellScriptHandlerService = new ShellScriptHandlerService();
        while (true) {
            shellScriptHandlerService.runService();
        }
    }
}
