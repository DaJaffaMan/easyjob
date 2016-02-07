package config;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

@Component
@Configuration
public class DatabaseConfig {

    @Bean
    public Node node() {
        return nodeBuilder().local(true).build();
    }

    @Bean
    public Client client(Node node) {
        return node.client();
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client);
    }
}
