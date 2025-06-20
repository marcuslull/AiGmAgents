import console.ConsoleUI;
import sessions.MainSession;

public class Main {
    public static void main(String[] args) {


        ConsoleUI.startConsoleUI(MainSession.session, MainSession.inMemoryRunner);

    }
}
