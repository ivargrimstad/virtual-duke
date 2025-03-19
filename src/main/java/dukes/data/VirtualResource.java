package dukes.data;

import jakarta.enterprise.concurrent.ManagedThreadFactory;
import jakarta.enterprise.concurrent.ManagedThreadFactoryDefinition;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import javax.naming.InitialContext;

@ManagedThreadFactoryDefinition(
        name = "java:app/concurrent/MyManagedThreadFactory",
        virtual = true
)
@RequestScoped
@Path("/threads")
public class VirtualResource {

    @GET
    public String real() throws Exception {

        ManagedThreadFactory threadFactory = InitialContext
                .doLookup("java:app/concurrent/MyManagedThreadFactory");

        Thread taskThread = threadFactory.newThread(() -> {
            System.out.printf("Running");
        });

        taskThread.start();
        System.out.println(taskThread);

        return "Task submitted";
    }

}