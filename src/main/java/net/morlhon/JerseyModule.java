package net.morlhon;

import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class JerseyModule extends JerseyServletModule
{

    @Override
    protected void configureServlets()
    {
        bind(PersonResource.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put(ResourceConfig.FEATURE_DISABLE_WADL, "true");
        params.put("com.sun.jersey.spi.container.ResourceFilters", "net.morlhon.jersey.CacheFilterFactory");
        filter("/*").through(GuiceContainer.class, params);
    }
}
