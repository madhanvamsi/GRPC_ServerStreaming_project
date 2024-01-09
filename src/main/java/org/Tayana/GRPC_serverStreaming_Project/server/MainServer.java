package org.Tayana.GRPC_serverStreaming_Project.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MainServer 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server=ServerBuilder
				.forPort(8081).addService(new AmazonServer())
				.build();
		System.out.println("server started");
		server.start();
		server.awaitTermination();
	}
}
