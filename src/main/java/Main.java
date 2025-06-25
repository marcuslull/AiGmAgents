import agents.Praetor;
import configurations.McpConfig;
import console.ConsoleUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sessions.MainSession;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        if (args.length != 1) throw new IllegalArgumentException("Usage: Please specify the path to the MCP JAR file");

        String mcpJarPath = args[0];
        McpConfig.initialize(mcpJarPath);

        logger.info("Starting AI GM Agents");
        Praetor.getAgent();

        logger.info("Starting Console UI");
        ConsoleUI.startConsoleUI(MainSession.session, MainSession.inMemoryRunner);
    }
}
