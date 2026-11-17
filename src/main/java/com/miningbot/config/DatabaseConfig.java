package com.miningbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    public DataSource dataSource(@Value("${spring.datasource.url}") String databaseUrl) {

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(databaseUrl);

        return dataSource;
    }
}
