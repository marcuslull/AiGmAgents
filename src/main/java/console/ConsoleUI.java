package console;

import com.google.adk.events.Event;
import com.google.adk.runner.Runner;
import com.google.adk.sessions.Session;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import configurations.McpConfig;
import io.reactivex.rxjava3.core.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleUI {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleUI.class);

    private static final String USER_ID = "SessionUser";

    // TODO: Parameterize USER_ID
    public static void startConsoleUI(Session session, Runner runner) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            while (true) {
                System.out.print("\nYou > ");
                String userInput = scanner.nextLine();

                if ("quit".equalsIgnoreCase(userInput)) {
                    logger.info("Exiting Console UI");
                    McpConfig.closeTools();
                    break;
                }

                Content userMsg = Content.fromParts(Part.fromText(userInput));
                logger.info("User Message: {}", userMsg);
                Flowable<Event> events = runner.runAsync(USER_ID, session.id(), userMsg);

                System.out.print("\nAgent > ");
                events.blockingForEach(event -> System.out.println(event.stringifyContent()));
            }
        }
    }
}
