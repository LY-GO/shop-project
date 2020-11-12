package com.qfedu.user.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpConfiguration {
    @Resource
    private OkHttpConfigurationProperties properties;

    @Bean
    public OkHttpClient okHttpClient(ConnectionPool pool) {
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectionPool(pool)
                .connectTimeout(properties.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(properties.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(properties.getWriteTimeout(), TimeUnit.MILLISECONDS)
                .build();
        return client;
    }

    /**
     * 连接池
     *
     * @return
     */
    @Bean
    public ConnectionPool pool() {
        return new ConnectionPool(properties.getMaxIdle(), properties.getKeepAlive(), TimeUnit.SECONDS);
    }


}
