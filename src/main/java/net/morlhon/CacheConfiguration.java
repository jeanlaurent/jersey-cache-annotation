package net.morlhon;

import java.util.Date;

import javax.ws.rs.core.CacheControl;

public interface CacheConfiguration
{
    Date getExpires();

    Date getLastModifiedBy();

    CacheControl getCacheControl();
}
