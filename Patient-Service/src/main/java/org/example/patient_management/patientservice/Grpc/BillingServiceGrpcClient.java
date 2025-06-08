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


    public BillingServiceGrpcClient(
            @Value("${billing_service_address:localhost}") String serverAddress,
            @Value("${billing_service_grpc_port:9001}") int serverPort) {

        log.info("Server address: {} and port: {}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();



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