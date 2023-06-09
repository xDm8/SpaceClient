import java.util.Objects;
import java.util.Scanner;
public class Main {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        Window.Launch();
        System.out.println("Dev Console; -ver=1.0.3 -started=true");
        ConsoleCommandHandler();
    }

    public static void ConsoleCommandHandler() {
        String cmd = console.nextLine();
        ConsoleCommandRunner(cmd);
    }

    public static void ConsoleCommandRunner(String cmd) {
        if (Objects.equals(cmd, "console.test")) {
            System.out.println("console.test.success");
        } else if (Objects.equals(cmd, "app.exit")){
            System.exit(0);
        } else if (cmd.startsWith("file.downloadmod ")) {
            String mod = cmd.substring(17);
            Installer.downloadMod(mod);
        } else if (cmd.startsWith("file.removemod ")) {
            String mod = cmd.substring(15);
            Installer.removeMod(mod);
        } else {
            System.out.println("error.unkownCommandError");
        }
        ConsoleCommandHandler();
    }
}