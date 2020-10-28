package be.dog.d.steven.multipledb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "datasource1")
    @ConfigurationProperties("db1.datasource")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/my_database3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .username("admin")
                .password("admin")
                .build();
    }

    @Bean(name = "datasource2")
    @ConfigurationProperties("db2.datasource")
//    @Primary // Annotate 2nd db with primary to switch db
    public DataSource dataSource2(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/my_database4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .username("admin")
                .password("admin")
                .build();
    }

    @Bean
    @Autowired
    @Primary
    TransactionManager transactionManager(DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

//    @Bean(name="tm2")
//    @Autowired
//    DataSourceTransactionManager tm2(@Qualifier ("datasource2") DataSource datasource) {
//        return new DataSourceTransactionManager(datasource);
//    }

}
