package com.gsomogyi.testsender.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EntityScan(basePackages = {"com.gsomogyi.testsender.model"})
@EnableJpaRepositories(
        basePackages = {"com.gsomogyi.testsender.repository"},
        entityManagerFactoryRef = "testsenderEntityManager",
        transactionManagerRef = "testsenderTransactionManager"
)
public class DatabaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean(name = "testsenderEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean testsenderEntityManager(@Qualifier("testsenderDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.gsomogyi.testsender.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "testsenderDataSource", destroyMethod = "")
    @Primary
    public DataSource testsenderDataSource() {
        logger.info("Configure H2 embedded database");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();

    }

    @Bean(name = "testsenderTransactionManager")
    @Primary
    public PlatformTransactionManager testsenderTransactionManager(@Qualifier("testsenderEntityManager") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}