package net.morlhon;

import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class JerseyModule extends JerseyServletModule
{

    @Override
    protected void configureServlets()
    {
        bind(PersonResource.class);
        filter("/*").through(GuiceContainer.class);
    }
}
