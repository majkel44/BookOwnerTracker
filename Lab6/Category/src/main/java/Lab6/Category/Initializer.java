package Lab6.Category;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Initializer implements InitializingBean {

    private final OwnerService ownerService;

    @Autowired
    public Initializer (OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (ownerService.findAll().isEmpty()) {
            Owner john = Owner.builder()
                    .uuid(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                    .name("John")
                    .age(38)
                    .build();
            Owner jack = Owner.builder()
                    .uuid(UUID.fromString("475f28c8-e455-4f50-85a7-b3fb27d3c805"))
                    .name("Jack")
                    .age(30)
                    .build();
            Owner jenny = Owner.builder()
                    .uuid(UUID.fromString("7dc3d549-73a1-4796-969e-f2cedfd461cd"))
                    .name("Jenny")
                    .age(27)
                    .build();

            ownerService.create(john);
            ownerService.create(jack);
            ownerService.create(jenny);
        }
    }
}
