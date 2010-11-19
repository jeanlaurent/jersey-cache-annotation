package net.morlhon.jersey;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

public class CacheFilter implements ResourceFilter, ContainerResponseFilter
{

    private CacheControl cacheControl;

    public CacheFilter()
    {
        cacheControl = new CacheControl();
        cacheControl.setNoTransform(false);
        cacheControl.setMaxAge(172800); // 48h
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
        Response cachedResponse = Response.fromResponse(originalResponse).cacheControl(cacheControl).build();
        containerResponse.setResponse(cachedResponse);
        return containerResponse;
    }

}
