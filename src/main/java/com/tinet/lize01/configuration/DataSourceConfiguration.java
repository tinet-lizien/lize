package com.tinet.lize01.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据库连接池配置
 *
 * @author wangtao
 * @date 2018/08/11
 */
@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.quartz.url}")
    private String url;

    @Value("${spring.datasource.quartz.username}")
    private String username;

    @Value("${spring.datasource.quartz.password}")
    private String password;

    @Value("${spring.datasource.quartz.max-active}")
    private int maxActive;

    @Bean
    public DataSource quartzDataSource() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(maxActive);

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager quartzTransactionManager(DataSource quartzDataSource) {
        return new DataSourceTransactionManager(quartzDataSource);
    }

}