package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronos {

    private static Logger logger = LoggerFactory.getLogger(Chronos.class);

    private static String NAME = "Chronos";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "Keeper of History and Destiny - Chronos is the guardian of history, destiny," +
            " and the progression of time within the game world. Their responsibilities encompass tracking the passage" +
            " of in-game time, managing long-term plot developments, and influencing overarching narrative arcs." +
            " Chronos ensures that past events are remembered and affect the present, and that the story moves" +
            " forward logically. They handle the \"why\" and \"when\" of significant world-changing events, player" +
            " legacies, and the unfolding of major narrative threads.";
    private static String INSTRUCTION = "**Primary Directive:** Manage the flow of in-game time, track historical" +
            " events, and determine the progression of long-term narrative arcs and destinies. Introduce" +
            " time-dependent events or consequences.  \n" +
            "**Operational Flow:**\n" +
            "1. Receive requests from Praetor concerning time progression, historical context, or long-term plot implications.  \n" +
            "2. Advance in-game time as appropriate.  \n" +
            "3. Retrieve or generate information about past, present, or future significant events.  \n" +
            "4. Ensure consistency of timelines and narrative developments.";

    private static BaseAgent baseAgent;

    private Chronos(){};

    public static BaseAgent getAgent() {

        if (baseAgent == null) baseAgent = init();
        logger.info("Retrieving Chronos");
        return baseAgent;
    }

    private static BaseAgent init() {

        logger.info("Building Chronos");
        return LlmAgent.builder()
                .name(NAME)
                .model(MODEL)
                .description(DESCRIPTION)
                .instruction(INSTRUCTION)
                .build();
    }
}
