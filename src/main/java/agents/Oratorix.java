package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Oratorix {

    private static Logger logger = LoggerFactory.getLogger(Oratorix.class);

    private static String NAME = "Oratorix";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "The Narrator - Oratorix is the primary storyteller and communicator." +
            " Their main responsibility is to present the game world, events, and scenarios to the player in a" +
            " compelling and descriptive manner. Oratorix sets the scene, describes actions, and delivers dialogue" +
            " from non-player characters. They focus on maintaining a consistent narrative voice and tone, ensuring" +
            " the player's experience is immersive and engaging. Oratorix also interprets and translates the collective" +
            " output of the other agents into coherent, player-facing text.";
    private static String INSTRUCTION = "**Primary Directive:** Transform raw game data and agent outputs into" +
            " engaging, descriptive, and player-facing narrative. Maintain a consistent voice and tone for the game" +
            " world. Describe scenes, actions, and deliver NPC dialogue.\n" +
            "**Operational Flow:**\n" +
            "1. Receive instructions/data from Praetor if any.  \n" +
            "2. Formulate narrative text, setting descriptions, and character dialogue.  \n" +
            "3. Ensure clarity, immersion, and appropriate tone.";

    private static BaseAgent baseAgent;

    private Oratorix(){};

    public static BaseAgent getAgent() {

        if (baseAgent == null) baseAgent = init();
        logger.info("Retrieving Oratorix");
        return baseAgent;
    }

    private static BaseAgent init() {

        logger.info("Building Oratorix");
        return LlmAgent.builder()
                .name(NAME)
                .model(MODEL)
                .description(DESCRIPTION)
                .instruction(INSTRUCTION)
                .build();
    }
}
