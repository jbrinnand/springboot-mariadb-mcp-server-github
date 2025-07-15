//import io.modelcontextprotocol.client.McpClient;
//import io.modelcontextprotocol.spec.McpSchema;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.Duration;
//import java.util.Map;
//
//@Slf4j
//@SpringBootTest
//public class SpringbootMCPApplicationTest {
//
//    @Test
//    void testRemoteClient() {
//        // Create a remote transport pointing to your MCP server
//        var remoteTransport = new HttpClientTransport("http://localhost:8080/mcp");
//
//        // Create a sync client with remote configuration
//        var client = McpClient.sync(remoteTransport)
//                .requestTimeout(Duration.ofSeconds(30))
//                .capabilities(McpSchema.ClientCapabilities.builder()
//                        .roots(true)      // Enable roots capability
//                        .sampling()       // Enable sampling capability
//                        .build())
//                .sampling(request ->
//                        McpSchema.CreateMessageResult.builder()
//                                .message(String.valueOf(request.messages().getFirst()))
//                                .build()
//                )
//                .build();
//
//        try {
//            // Initialize connection
//            client.initialize();
//
//            // List available tools
//            final McpSchema.ListToolsResult listToolsResult = client.listTools();
//            log.info("Available tools: {}", listToolsResult.tools());
//            listToolsResult.tools().forEach(tool ->
//                log.info("Tool: {}  Description: {}", tool.name(), tool.description())
//            );
//
//            // Test invoking a tool
//            var toolParams = Map.of("name", "test");
//            var toolResult = client.invokeTool("searchAccountsByPartialName", toolParams);
//            log.info("Tool result: {}", toolResult);
//
//        } finally {
//            client.closeGracefully();
//        }
//    }
//}