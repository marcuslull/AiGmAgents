package agents.oratorix;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class Oratorix {

    // TODO: Classify this so we can make many agents
    private static String NAME = "Oratorix";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "The AI game master";
    private static String INSTRUCTION = "You are a tabletop RPG game master, responsible for gameplay, narrative, and game rules.";

    public static BaseAgent ORATORIX = init();

    public static BaseAgent init() {
        return LlmAgent.builder()
                .name(NAME)
                .model(MODEL)
                .description(DESCRIPTION)
                .instruction(INSTRUCTION)
                .build();
    }
}
