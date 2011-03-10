package net.morlhon.jersey;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import net.morlhon.CacheConfiguration;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Cache
{
    Class<? extends CacheConfiguration> value();
}
