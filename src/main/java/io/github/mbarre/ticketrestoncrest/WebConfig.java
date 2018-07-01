/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mbarre.ticketrestoncrest;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author salad74
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        //set path extension to false
        configurer.favorPathExtension(false).
                //request parameter ("format" by default) should be used to determine the requested media type
                favorParameter(true).
                //the favour parameter is set to "mediaType" instead of default "format"
                parameterName("mediaType").
                //ignore the accept headers
                ignoreAcceptHeader(true).
                //dont use Java Activation Framework since we are manually specifying the mediatypes required below
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }
}
