package org.example.patient_management.patientservice.Grpc;

import Billing.BillingRequest;
import Billing.BillingResponse;
import Billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingServiceGrpcClient {


    private final BillingServiceGrpc.BillingServiceBlockingStub blockstub;


    public BillingServiceGrpcClient(@Value("${billing.service.address:localhost}") String serveraddresss, @Value("${billing.service.grpc.port:9001}") int serverport) {
        log.info("Server address:{} and: {}", serveraddresss, serverport);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(serveraddresss, serverport)
                .usePlaintext().build();

        blockstub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBillingAccount(String patientId, String name, String email) {
        try {
            BillingRequest request = BillingRequest.newBuilder()
                    .setPatientId(patientId)
                    .setName(name)
                    .setEmail(email)
                    .build();

            BillingResponse response = blockstub.createBillingAccount(request);
            log.info("Received Response via Grpc :{}", response);
            return response;
        } catch (Exception e) {
            {
                log.error("Grpc call to Billing service failed", e);
                throw e;
            }
        }


    }

}