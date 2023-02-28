package com.pce.timeplanner.datasource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSource {
    public static DriverManagerDataSource pgsqlSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgresDB");
        dataSource.setUsername("postgresUser");
        dataSource.setPassword("postgresPW");
        return dataSource;
    }

}
