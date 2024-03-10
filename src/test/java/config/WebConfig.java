package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${environment}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("firefox")
    String getBrowser();

    @Key("version")
    @DefaultValue("97.0")
    String version();

    @Key("remote")
    @DefaultValue("")
    String remoteUrl();
}
