package org.Tayana.GRPC_serverStreaming_Project.server;

import com.Tayana.Proto.AmazonRequest;
import com.Tayana.Proto.AmazonResponse;
import com.Tayana.Proto.AmazonServiceGrpc.AmazonServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AmazonServer extends AmazonServiceImplBase
{

	@Override
	public void hello(AmazonRequest request, 
					StreamObserver<AmazonResponse> responseObserver) 
	{
		for(int i=0;i<=5;i++)
		{
			AmazonResponse amazonResponse=AmazonResponse.newBuilder()
					.setResponse("response sent :"+i +" "+request.getRequest())
					.build();
			responseObserver.onNext(amazonResponse);
		}
		responseObserver.onCompleted();
	}
}
	

	


