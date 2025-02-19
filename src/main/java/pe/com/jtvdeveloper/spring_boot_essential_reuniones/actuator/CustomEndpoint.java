package pe.com.jtvdeveloper.spring_boot_essential_reuniones.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomEndpoint {
    @ReadOperation
    public String getCustomEndpoint() {
        return "Custom Endpoint Example";
    }
}
