package org.Tayana.GRPC_serverStreaming_Project.client;

import java.util.Iterator;

import com.Tayana.Proto.AmazonRequest;
import com.Tayana.Proto.AmazonResponse;
import com.Tayana.Proto.AmazonServiceGrpc;
import com.Tayana.Proto.AmazonServiceGrpc.AmazonServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;

public class AmazonClient 
{
	@GrpcClient("AmazonServer")
	private AmazonServiceGrpc.AmazonServiceBlockingStub amazonServiceBlockingStub;
	public static void main(String[] args) {
		
		ManagedChannel channel=ManagedChannelBuilder.forAddress("localhost", 8081)
				.usePlaintext().build();
		AmazonRequest request=AmazonRequest 
				.newBuilder()
				.setRequest("hello")
				.build();
		AmazonServiceBlockingStub blockingStub=AmazonServiceGrpc.newBlockingStub(channel);
		Iterator<AmazonResponse> response=blockingStub.hello(request);
		while(response.hasNext())
		{
			System.out.println(response.next());
		}
																	
		
	}

}
