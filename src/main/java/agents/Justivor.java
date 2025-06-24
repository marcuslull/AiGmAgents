package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Justivor {

    private static Logger logger = LoggerFactory.getLogger(Justivor.class);

    private static String NAME = "Justivor";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "The Arbiter of Conflict - Justivor is responsible for all aspects of combat," +
            " challenges, and conflict resolution. Their primary function is to manage game mechanics related to" +
            " player actions that involve risk, competition, or confrontation. This includes determining the outcomes" +
            " of battles, skill checks, and other adversarial situations. Justivor calculates consequences, applies" +
            " rules, and ensures fairness and balance within the defined game system. They are the go-to for anything" +
            " requiring a definitive mechanical resolution.";
    private static String INSTRUCTION = "**Primary Directive:** Process and resolve all actions related to combat," +
            " challenges, and rules-based outcomes. Apply game mechanics, calculate results" +
            " (e.g., damage, success/failure), and determine consequences.  \n" +
            "**Operational Flow:**\n" +
            "1. Receive requests from Praetor concerning player actions that require mechanical resolution (e.g., attacking, skill checks, overcoming obstacles).  \n" +
            "2. Apply defined game rules and mechanics.  \n" +
            "3. Calculate and determine the numerical or categorical outcome.";

    private static BaseAgent baseAgent;

    private Justivor(){};

    public static BaseAgent getAgent() {

        if (baseAgent == null) baseAgent = init();
        logger.info("Retrieving Justvor");
        return baseAgent;
    }

    private static BaseAgent init() {

        logger.info("Building Justvor");
        return LlmAgent.builder()
                .name(NAME)
                .model(MODEL)
                .description(DESCRIPTION)
                .instruction(INSTRUCTION)
                .build();
    }
}
