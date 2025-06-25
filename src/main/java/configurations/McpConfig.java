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

    private static final String JAVA_COMMAND = "java";
    private static final String JAVA_ARGS = "-jar";
    private static final String JAR_PROFILE = "--spring.profiles.active=pack";

    private static boolean isInitialized = false;

    private static McpToolset toolset;

    private McpConfig(){}

    public static void initialize(String mcpJarPath) {
        if (isInitialized) return;
        ServerParameters serverParameters = new ServerParameters.Builder(JAVA_COMMAND).args(JAVA_ARGS, mcpJarPath, JAR_PROFILE).build();
        toolset = new McpToolset(serverParameters);
        isInitialized = true;
        logger.info("McpConfig initialized with JAR: {}", mcpJarPath);
    }

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
