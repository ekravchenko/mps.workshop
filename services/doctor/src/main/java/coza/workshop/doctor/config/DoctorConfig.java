package coza.workshop.doctor.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DoctorConfig {

    @Value("${dataSource.driverClassName}")
    private String driverClassName;
    @Value("${dataSource.user}")
    private String user;
    @Value("${dataSource.password}")
    private String password;
    @Value("${dataSource.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setUsername(user);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.addDataSourceProperty("useSSL", false);
        return new HikariDataSource(config);
    }

    @Bean
    public DSLContext dsl(DataSource dataSource) {
        DataSourceConnectionProvider dataSourceConnectionProvider = new DataSourceConnectionProvider(dataSource);

        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.setConnectionProvider(dataSourceConnectionProvider);
        configuration.setSQLDialect(SQLDialect.MYSQL);
        return new DefaultDSLContext(configuration);
    }
}
