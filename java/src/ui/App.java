package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    private static final String SCRIPT_PATH = "C:\\ISN\\Projet Service reseau\\badge-management-system\\java\\src\\ui\\test.bat"; // Remplacer
    // par
    // le
    // chemin
    // réel
    // du
    // script
    // shell
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            // Lancer le script shell en tant que processus et obtenir son flux de sortie
            ProcessBuilder processBuilder = new ProcessBuilder(SCRIPT_PATH);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Attendre que l'utilisateur scanne son badge et lire l'ID du badge
            String badgeId = reader.readLine();

            // Fermer le flux de sortie du processus
            reader.close();

            // Déterminer l'action à effectuer en fonction de l'ID du badge
            // Exemple :
            if (badgeId.equals("10")) {
                // Allumer la LED verte
                System.out.println("Allumer la LED verte");
            } else if (badgeId.equals("20")) {
                // Allumer la LED rouge
                System.out.println("Allumer la LED rouge");
            } else {
                // Afficher un message d'erreur
                System.out.println("ID de badge invalide : " + badgeId);
            }

            // Relancer le programme après un certain temps
            executorService.submit(() -> {
                try {
                    Thread.sleep(5000); // Attendre 5 secondes
                    main(args);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
    }
}
