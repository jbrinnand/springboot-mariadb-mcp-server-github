//package com.ct.springboot_mariadb;
//
//import io.modelcontextprotocol.client.McpClient;
//import io.modelcontextprotocol.client.McpSyncClient;
//import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
//import io.modelcontextprotocol.spec.McpSchema;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.Duration;
//
//@Slf4j
//@SpringBootTest
//public class SpringbootMariadbApplicationTests {
//
//    @Test
//    void testRemoteClient() {
//        log.info("Test Remote Client");
//        var transport = new HttpClientSseClientTransport("http://localhost:8080/mcp");
//
//        // Create a sync client with remote configuration
//        McpSyncClient client = McpClient.sync(transport)
//                .requestTimeout(Duration.ofSeconds(30))
//                .capabilities(McpSchema.ClientCapabilities.builder()
//                        .roots(true)
//                        .sampling()
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
//                    log.info("Tool: {}  Description: {}", tool.name(), tool.description())
//            );
//        } finally {
//            client.closeGracefully();
//        }
//    }
//}