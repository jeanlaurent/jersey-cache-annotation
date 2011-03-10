package net.morlhon.jersey;

import java.util.Collections;
import java.util.List;

import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;

public class CacheFilterFactory implements ResourceFilterFactory
{

    @Override
    public List<ResourceFilter> create(AbstractMethod abstractMethod)
    {
        if (abstractMethod.isAnnotationPresent(Cache.class))
        {
            Cache annotation = abstractMethod.getAnnotation(Cache.class);
            return Collections.<ResourceFilter> singletonList(new CacheFilter(annotation.value()));
        }
        return null;
    }
}
