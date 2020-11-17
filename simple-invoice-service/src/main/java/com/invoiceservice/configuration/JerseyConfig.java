package com.invoiceservice.configuration;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.invoiceservice.json.ObjectMapperProvider;
import com.invoiceservice.model.config.AppConfiguration;
import com.invoiceservice.rest.CategoryRatesResource;
import com.invoiceservice.rest.InvoiceResource;
import com.invoiceservice.rest.SystemHealthResource;

@Component
public class JerseyConfig extends ResourceConfig {
    
    @Autowired
    AppConfiguration appConfiguration;
   
    @PostConstruct
    public void init() {
       
        register(InvoiceResource.class);
        register(SystemHealthResource.class);
        register(CategoryRatesResource.class);
        register(JacksonFeature.class);
        register(ObjectMapperProvider.class);
        setApplicationName("InvioceService");
        property(ServerProperties.MONITORING_STATISTICS_MBEANS_ENABLED, true);
    }
}
