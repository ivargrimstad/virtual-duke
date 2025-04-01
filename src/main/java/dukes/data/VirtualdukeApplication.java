package dukes.data;

import jakarta.enterprise.concurrent.ManagedThreadFactoryDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ManagedThreadFactoryDefinition(
        name = "java:app/concurrent/MyManagedThreadFactory",
        virtual = true
)
@ApplicationPath("/api")
public class VirtualdukeApplication extends Application {

}