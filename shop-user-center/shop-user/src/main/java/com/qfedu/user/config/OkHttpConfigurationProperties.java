package com.qfedu.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "okhttp")
public class OkHttpConfigurationProperties {
    private int connectTimeout;
    private int readTimeout;
    private int writeTimeout;
    private int maxIdle;
    private int keepAlive;
}
