package org.fnb.reservation;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "FNB_reservations";
    }

    @Override
    public MongoClient mongoClient() {
        String uri = "mongodb+srv://wafik20:wafik202047@cluster0.jhhu4kl.mongodb.net/FNB_reservations";
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .codecRegistry(customCodecRegistry())
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public CodecRegistry customCodecRegistry() {
        return CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(new DateTimeFormatterCodec())
        );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        try {
            return new MongoTemplate(mongoClient(), getDatabaseName());
        } catch (Exception e) {
            throw new RuntimeException("Error initializing MongoTemplate", e);
        }
    }
    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    // ...
}
