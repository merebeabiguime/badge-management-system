package services.microservices.BadgeService.repositories;

import services.microservices.BadgeService.interfaces.IShellHandlerRepository;

public class ShellHandlerRepository implements IShellHandlerRepository {

    class MockController {

        public static String onScanBadge(String jsonInput) {
            return "\"status\":\"success\",\"code\":\"200\",\"message\":\"Badge scanned successfully\",\"data\":\"{\\\"badgeId\\\":10}\"";
        }
    }

    public String sendBadgeId(String badgeId) {
        return MockController.onScanBadge(badgeId);
    }

}
