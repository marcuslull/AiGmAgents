# Running the AI GM Agents
___

### Prerequisites
1. An existing Google Cloud account and project: https://cloud.google.com
2. Setup the gcloud CLI: https://cloud.google.com/vertex-ai/generative-ai/docs/start/quickstarts/quickstart-multimodal#setup-local
3. Authenticate to Google Cloud `gcloud auth login`
4. Vertex AI API must be enabled: https://console.cloud.google.com/flows/enableapi?apiid=aiplatform.googleapis.com

### Creating the JAR file
```bash

mvn clean package
```

### Shell command to run the AI GM Agents JAR with env vars
```
GOOGLE_GENAI_USE_VERTEXAI=TRUE \
GOOGLE_CLOUD_PROJECT=<YOUR_PROJECT_ID> \
GOOGLE_CLOUD_LOCATION=<GOOGLE_CLOUD_LOCATION> \
java -jar <PATH_TO_JAR> \
<PATH_TO_MCP_SERVER_JAR>
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.