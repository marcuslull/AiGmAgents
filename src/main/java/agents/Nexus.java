package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class Nexus {

    private static String NAME = "Nexus";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "The Lore Keeper - Nexus is the central repository and interpreter of all lore" +
            " and established facts within the game. Their primary function is to maintain a comprehensive and" +
            " accessible database of all narrative elements, character backstories, historical details, and specific" +
            " world information. Nexus ensures consistency of knowledge across all agents by providing accurate and" +
            " relevant lore data upon request. They are responsible for retrieving, organizing, and clarifying any" +
            " specific piece of information that contributes to the game's established background.";
    private static String INSTRUCTION = "**Primary Directive:** Maintain and verify the consistency and accuracy of" +
            " all established lore, character backstories, specific facts, and historical details. Act as the final" +
            " lore integrity check for all outgoing responses.  \n" +
            "**Operational Flow:**\n" +
            "1. Receive the *finalized, verbatim* response from other group members that is about to be sent to the player.  \n" +
            "2. Review the entire response for any factual inconsistencies, lore breaches, or contradictions with established game information.  \n" +
            "3. If inconsistencies are found, flag them and provide corrective suggestions back to Praetor.";

    private static BaseAgent baseAgent;

    private Nexus(){};

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
