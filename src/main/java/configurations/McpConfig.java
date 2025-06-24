package configurations;

import com.google.adk.tools.mcp.McpTool;
import com.google.adk.tools.mcp.McpToolset;
import io.modelcontextprotocol.client.transport.ServerParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class McpConfig {

    private static final Logger logger = LoggerFactory.getLogger(McpConfig.class);

    private static final String FAT_JAR_LOCATION = "C:\\Users\\Marcus\\Documents\\IdeaProjects\\AiGmMcp\\target\\AiGmMcp-0.0.1-SNAPSHOT.jar";
    private static final String JAVA_COMMAND = "java";
    private static final String JAVA_ARGS = "-jar";
    private static final ServerParameters serverParameters = new ServerParameters.Builder(JAVA_COMMAND).args(JAVA_ARGS, FAT_JAR_LOCATION).build();

    private static final McpToolset toolset = new McpToolset(serverParameters);

    private McpConfig(){}

    public static CompletableFuture<List<McpTool>> loadTools() {

        logger.info("Initializing McpServer");
        return toolset.loadTools();
    }

    public static void closeTools() {
        try {
            toolset.close();
            logger.info("McpToolset successfully closed.");
        } catch (Exception e) {
            logger.error("Error closing McpToolset: {}", e.getMessage());
        }
    }
}
