package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${environment}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("opera")
    String getBrowser();

    @Key("version")
    @DefaultValue("97.0")
    String version();
}
