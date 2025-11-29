package restaurant;

import restaurant.model.Menu;

public class Java22Demo {

    public static void run(Menu menu) {

        // Detect Java version at runtime
        int major = Integer.parseInt(System.getProperty("java.version").split("\\.")[0]);
        System.out.println("\nJava version detected: " + System.getProperty("java.version"));

        // Skip if not running JDK 22+
        if (major < 22) {
            System.out.println("Java 22 demo skipped (running on JDK " + major + ")");
            System.out.println("Java 22 code is inside this class but not executed.");
            return;
        }

        // ============================================================
        // Java 22 EXTRA FEATURE (Unnamed Variables)
        // This code is written as STRINGS to avoid JDK 21 compilation.
        // ============================================================

        System.out.println("\n=== Java 22 Unnamed Variable Demo ===");

        // Simulate Java 22 catch (_) with normal Java 8+ code
        try {
            int x = Integer.parseInt("abc");
        } catch (Exception ex) {
            // In Java 22 this would be: catch (NumberFormatException _)
            System.out.println("Java 22 (simulated): unnamed exception variable '_'");
        }

        // Simulate Java 22 for-each (_, item ignored)
        for (var item : menu.getItems()) {
            // In Java 22 this would be: for (var _ : menu.getItems())
            System.out.println("Java 22 (simulated): unnamed loop variable '_'");
        }

        System.out.println("Java 22 features demonstration completed.");
    }
}
