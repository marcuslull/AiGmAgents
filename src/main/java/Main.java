import agents.Praetor;
import console.ConsoleUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sessions.MainSession;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting AI GM Agents");
        Praetor.getAgent();

        logger.info("Starting Console UI");
        ConsoleUI.startConsoleUI(MainSession.session, MainSession.inMemoryRunner);
    }
}
