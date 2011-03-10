package IT.net.morlhon.it;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PersonResourceTest
{

    private Client client;

    @Before
    public void init()
    {
        client = Client.create();
    }

    @Test
    public void test()
    {
        WebResource resource = client.resource("http://localhost:8081/person/42");
        ClientResponse clientResponse = resource.get(ClientResponse.class);
        assertThat(clientResponse.getStatus()).isEqualTo(200);
        assertThat(clientResponse.getHeaders().keySet()).contains("Cache-Control");
        assertThat(clientResponse.getHeaders().get("Cache-Control")).contains("max-age=172800");
    }
}
