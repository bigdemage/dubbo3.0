package grpc.health.v1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public interface Health {

    static final String JAVA_SERVICE_NAME = "grpc.health.v1.Health";
    static final String SERVICE_NAME = "grpc.health.v1.Health";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = HealthDubbo.init();

    grpc.health.v1.HealthCheckResponse check(grpc.health.v1.HealthCheckRequest request);

    default CompletableFuture<grpc.health.v1.HealthCheckResponse> checkAsync(grpc.health.v1.HealthCheckRequest request){
        return CompletableFuture.supplyAsync(() -> check(request));
    }


        /**
         * <pre>
         *  Performs a watch for the serving status of the requested service.
         *  The server will immediately send back a message indicating the current
         *  serving status.  It will then subsequently send a new message whenever
         *  the service&#39;s serving status changes.
         * 
         *  If the requested service is unknown when the call is received, the
         *  server will send a message setting the serving status to
         *  SERVICE_UNKNOWN but will &#42;not&#42; terminate the call.  If at some
         *  future point, the serving status of the service becomes known, the
         *  server will send a new message with the service&#39;s serving status.
         * 
         *  If the call terminates with status UNIMPLEMENTED, then clients
         *  should assume this method is not supported and should not retry the
         *  call.  If the call terminates with any other status (including OK),
         *  clients should retry the call with appropriate exponential backoff.
         * </pre>
         */
    void watch(grpc.health.v1.HealthCheckRequest request, org.apache.dubbo.common.stream.StreamObserver<grpc.health.v1.HealthCheckResponse> responseObserver);


}
