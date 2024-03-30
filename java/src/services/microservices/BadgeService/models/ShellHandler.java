package services.microservices.BadgeService.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellHandler {

    private String SCRIPT_PATH;
    private ProcessBuilder processBuilder;
    private Process process;
    private BufferedReader reader;
    private String badgeId;

    public ShellHandler(String SCRIPT_PATH) {
        this.SCRIPT_PATH = SCRIPT_PATH;
        this.processBuilder = new ProcessBuilder(SCRIPT_PATH);
    }

    public String getPath() {
        return this.SCRIPT_PATH;
    }

    public String getBadgeId() {
        return this.badgeId;
    }

    public void runService() throws IOException {
        this.process = this.processBuilder.start();
    }

    public void waitForBadgeId() throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(this.process.getInputStream()));
        this.badgeId = this.reader.readLine();
        reader.close();
    }

}
