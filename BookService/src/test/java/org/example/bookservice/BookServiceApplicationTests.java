package org.example.bookservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "eureka.client.enabled=false",
        "eureka.client.register-with-eureka=false",
        "eureka.client.fetch-registry=false",
        "spring.cloud.discovery.enabled=false",
        "spring.cloud.netflix.eureka.client.enabled=false"
})
class BookServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
