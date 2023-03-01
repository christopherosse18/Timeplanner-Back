package com.pce.timeplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeplannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeplannerApplication.class, args);/*
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSource.pgsqlSource());
        String sql = "select count(*) from timeplanner.\"user\"";
        System.out.println(jdbcTemplate.queryForObject(sql, String.class));*/
    }

}
