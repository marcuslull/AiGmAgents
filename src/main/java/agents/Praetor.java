package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.mcp.McpTool;
import configurations.McpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Praetor {

    private static Logger logger = LoggerFactory.getLogger(Praetor.class);

    private static String NAME = "Praetor";
    private static String MODEL = "gemini-2.0-flash";
    private static String DESCRIPTION = "The Director - Praetor serves as the overarching strategic leader and" +
            " decision-maker for the entire GM agent group. Their core responsibility is to synthesize information" +
            " from all other agents and make high-level directional choices that guide the game's progression. Praetor" +
            " sets the agenda, prioritizes tasks, and resolves conflicts or ambiguities between the outputs of other" +
            " agents. They ensure that the game remains on track, coherent, and aligned with the intended player" +
            " experience. Praetor is the ultimate authority in guiding the \"big picture.\"";
    private static String INSTRUCTION = "* **Primary Directive:** Receive and interpret ALL incoming player requests." +
            " Strategically direct the appropriate agent(s) to process the request. Synthesize all agent outputs" +
            " into a cohesive response. Prioritize and resolve any conflicts or ambiguities between agent contributions." +
            " Ensure the overall game progression aligns with the established narrative and player experience.  \n" +
            "* **Operational Flow:**  \n" +
            "  1. Receive player request.  \n" +
            "  2. Determine relevant agents for the request (e.g., Justivor for combat, Orbis for world info, Chronos for time-based events).  \n" +
            "  3. Distribute the request to the chosen agent(s).  \n" +
            "  4. Resolve group conflicts if needed.";

    private static BaseAgent baseAgent;

    private Praetor(){};

    public static BaseAgent getAgent() {

        if (baseAgent == null) {
            try {
                baseAgent = init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        logger.info("Retrieving Praetor");
        return baseAgent;
    }

    private static BaseAgent init() throws Exception {

        List<McpTool> mcpTools = McpConfig.loadTools().join();

        logger.info("Building Praetor");
        return LlmAgent.builder()
                .name(NAME)
                .model(MODEL)
                .description(DESCRIPTION)
                .instruction(INSTRUCTION)
                .subAgents(Chronos.getAgent(), Justivor.getAgent(), Oratorix.getAgent(), Orbis.getAgent())
                .tools(mcpTools)
                .build();
    }
}
