package Lab5.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Repository
public class OwnerEvent {
    private final RestTemplate restTemplate;

    @Autowired
    public OwnerEvent (RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public void delete (UUID id){
        restTemplate.delete("/api/owners/{ownerID}", id);
    }
    public void create (UUID entity){
        Map<String, UUID> requestBody = Collections.singletonMap("uuid", entity);
        //restTemplate.postForEntity("/owners", requestBody, Void.class);
    }
}
