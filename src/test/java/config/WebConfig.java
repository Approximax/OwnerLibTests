package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("firefox")
    String getBrowser();

    @Key("version")
    @DefaultValue("122.0")
    String version();

    @Key("remote")
    String remoteUrl();
}