package be.dog.d.steven.multipledb.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DataSourceConfigurationTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;

    @Test
    public void testDataSource() {
        assertTrue(this.dataSourceConfiguration.dataSource() instanceof com.zaxxer.hikari.HikariDataSource);
    }

    @Test
    public void testDataSource2() {
        assertTrue(this.dataSourceConfiguration.dataSource2() instanceof com.zaxxer.hikari.HikariDataSource);
    }

    @Test
    public void testTransactionManager() {
        assertTrue(this.dataSourceConfiguration.transactionManager(
                this.dataSource) instanceof org.springframework.jdbc.datasource.DataSourceTransactionManager);
    }
}

