package net.morlhon.jersey;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import net.morlhon.CacheConfiguration;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

public class CacheFilter implements ResourceFilter, ContainerResponseFilter
{

    private CacheConfiguration cacheConfiguration;

    public CacheFilter(Class<? extends CacheConfiguration> cacheConfigurationClass)
    {
        try
        {
            cacheConfiguration = cacheConfigurationClass.newInstance();
        }
        catch (InstantiationException ie)
        {
            throw new RuntimeException(ie);
        }
        catch (IllegalAccessException iae)
        {
            throw new RuntimeException(iae);
        }
    }

    @Override
    public ContainerRequestFilter getRequestFilter()
    {
        return null;
    }

    @Override
    public ContainerResponseFilter getResponseFilter()
    {
        return this;
    }

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse containerResponse)
    {
        Response originalResponse = containerResponse.getResponse();
        ResponseBuilder responseBuilder = Response.fromResponse(originalResponse);
        assignCacheConfiguration(responseBuilder, cacheConfiguration);
        Response cachedResponse = responseBuilder.build();
        containerResponse.setResponse(cachedResponse);
        return containerResponse;
    }

    // naive procedural stinky approach.
    ResponseBuilder assignCacheConfiguration(ResponseBuilder responseBuilder, CacheConfiguration cacheConfiguration)
    {
        if (cacheConfiguration.getExpires() != null)
        {
            responseBuilder.expires(cacheConfiguration.getExpires());
        }
        if (cacheConfiguration.getLastModifiedBy() != null)
        {
            responseBuilder.lastModified(cacheConfiguration.getLastModifiedBy());
        }
        if (cacheConfiguration.getCacheControl() != null)
        {
            responseBuilder.cacheControl(cacheConfiguration.getCacheControl());
        }
        return responseBuilder;
    }
}
