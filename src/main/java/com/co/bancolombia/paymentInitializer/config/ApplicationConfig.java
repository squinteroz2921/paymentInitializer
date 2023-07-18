package com.co.bancolombia.paymentInitializer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Value("${db.host}")
    private String DBhost;
    @Value("${db.port}")
    private String DBport;
    @Value("${db.database}")
    private String DBname;
    @Value("${db.username}")
    private String DBusername;
    @Value("${db.password}")
    private String DBpassword;

    private Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean
    public DataSource getDataSource() throws  Exception{
        try{
            logger.info("Iniciando Conexión con la base de datos ...");
            String url = String.format("jdbc:postgresql"
                    + "://" + DBhost
                    + ":" + DBport
                    + "/" + DBname);
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("org.postgresql.Driver");
            dataSourceBuilder.url(url);
            dataSourceBuilder.username(DBusername);
            dataSourceBuilder.password(DBpassword);
            logger.info("Conexion establecida con la BD: "+DBname);
            return dataSourceBuilder.build();
        }
        catch (Exception e){
            logger.error(String.valueOf(e));
            throw e;
        }
    }
}
