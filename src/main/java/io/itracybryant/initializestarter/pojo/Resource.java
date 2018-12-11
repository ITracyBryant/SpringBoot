package io.itracybryant.initializestarter.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName Resource
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 15:29
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "io.itracybryant.opensource")
@PropertySource(value = "classpath:resource.properties")
public class Resource {
    private String name;
    private String website;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
