package org.example.patient_management.billingservices.GRPC;

import Billing.BillingResponse;
import Billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@GrpcService
public class Grpc_Service extends BillingServiceGrpc.BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(Grpc_Service.class);
    @Override
    public void createBillingAccount(Billing.BillingRequest request, StreamObserver<BillingResponse> responseobserver)
    {
        log.info("Create Billing Account Request"+request.toString());
        //Bussines Logic
        BillingResponse response= BillingResponse.newBuilder().setAccountId("12345").setStatus("Active").build();


        responseobserver.onNext(response);
        responseobserver.onCompleted();


    }
}
