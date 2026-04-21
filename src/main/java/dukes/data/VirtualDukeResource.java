package dukes.data;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedThreadFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/threads")
public class VirtualDukeResource {

    @Resource(lookup = "java:app/concurrent/MyManagedThreadFactory")
    private ManagedThreadFactory threadFactory;

    @GET
    public String real() throws Exception {

        Thread taskThread = threadFactory.newThread(() -> {
            System.out.printf("Running");
        });

        taskThread.start();

        return "Task submitted on " + taskThread;
    }

}