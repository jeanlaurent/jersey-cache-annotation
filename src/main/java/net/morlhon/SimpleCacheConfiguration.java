package net.morlhon;

import java.util.Date;

import javax.ws.rs.core.CacheControl;

public class SimpleCacheConfiguration implements CacheConfiguration
{
    private CacheControl cacheControl;

    public SimpleCacheConfiguration()
    {
        cacheControl = new CacheControl();
        cacheControl.setNoTransform(false);
        cacheControl.setMaxAge(172800); // 48h
    }

    @Override
    public CacheControl getCacheControl()
    {
        return cacheControl;
    }

    @Override
    public Date getExpires()
    {
        return null;
    }

    @Override
    public Date getLastModifiedBy()
    {
        return new Date();
    }

}
