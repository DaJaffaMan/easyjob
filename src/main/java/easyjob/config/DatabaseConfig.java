package easyjob.config;

import easyjob.handlers.HandlerConfig;
import easyjob.repositories.RepositoryConfig;
import easyjob.transformer.TransformerConfig;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

@Configuration
@EnableElasticsearchRepositories(basePackages = "easyjob.repositories")
@Import({HandlerConfig.class, RepositoryConfig.class, TransformerConfig.class})
public class DatabaseConfig {

    @Bean
    public Node node() {
        return nodeBuilder().local(true).node();
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
