package main;

import java.util.Scanner;

public class ClientApplication {
	
	private static int ackSequence;
	
	
	@SuppressWarnings("resource")
	static String input() {
		return new Scanner(System.in).next();
	}

	static void show(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		
		 //inicia a sequence
		ackSequence = 0;
		show("2 - Client");
		String app = input();
		
		
		if (app.contentEquals("2")) {
			
			//connecta com o servidor
			UDPClient client = new UDPClient();
			client.connect();
			
			
			
			boolean clientRunning = true;
			while(clientRunning) {

				show("client start");


				
				
				DataInfo message = new DataInfo(new byte[100], ++ackSequence);
				
				//recebe mensagem do teclado
				message.setMessage(input());
				//envia
				client.send(message);
			}
		}
	}
}
