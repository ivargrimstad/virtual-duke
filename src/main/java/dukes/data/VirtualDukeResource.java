package dukes.data;

import jakarta.enterprise.concurrent.ManagedThreadFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import javax.naming.InitialContext;

@Path("/threads")
public class VirtualDukeResource {

    @GET
    public String real() throws Exception {

        ManagedThreadFactory threadFactory = InitialContext
                .doLookup("java:app/concurrent/MyManagedThreadFactory");

        Thread taskThread = threadFactory.newThread(() -> {
            System.out.printf("Running");
        });

        taskThread.start();

        return "Task submitted on " + taskThread;
    }

}