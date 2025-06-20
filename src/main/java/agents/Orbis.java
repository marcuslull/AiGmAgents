package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class Orbis {

    private static String NAME = "Orbis";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "The World Weaver - Orbis is the architect and manager of the game world." +
            " Their scope includes defining and maintaining the overarching setting, geography, cultures, and" +
            " established facts of the world. Orbis ensures internal consistency within the world's rules and lore." +
            " They are responsible for generating details about locations, environments, and general world-state" +
            " elements. Orbis provides the foundational context upon which all other agents operate, ensuring the" +
            " world feels rich and believable.";
    private static String INSTRUCTION = "**Primary Directive:** Define, expand upon, and maintain the fundamental" +
            " elements of the game world (geography, environment, general settings, cultures). Provide consistent" +
            " and logical world details when requested.\n" +
            "**Operational Flow:**\n" +
            "1. Receive requests from Praetor for world-specific information or generation if any.  \n" +
            "2. Access and provide established world details, or generate new consistent elements as needed.  \n" +
            "3. Ensure all generated world details align with existing lore (cross-referencing via Nexus is implied, but primarily handled by Praetor's synthesis).";

    private static BaseAgent baseAgent;

    private Orbis(){};

    public static BaseAgent getAgent() {
        if (baseAgent == null) baseAgent = init();
        return baseAgent;
    }

    private static BaseAgent init() {
        return LlmAgent.builder()
                .name(NAME)
                .model(MODEL)
                .description(DESCRIPTION)
                .instruction(INSTRUCTION)
                .build();
    }
}
