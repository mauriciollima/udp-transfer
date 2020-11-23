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
			String response = "";
			
			
			while(clientRunning) {
				show("response ack: " + response);
				sleep(1000);
				DataInfo message = new DataInfo(new byte[100], ++ackSequence);
				
				show(" 1 - 300 bytes");
				show(" 2 - 1200 bytes");
				
				
				//input do teclado
				String input = input();
				
				if(input.contentEquals("1")) {
					message.setData(Utils.loreIpsum300().getBytes());
				}
				
				if(input.contentEquals("2")) {
					message.setData(Utils.loreIpsum1200().getBytes());
				}
				
				
				
				//envia
				System.out.println("enviando seq: " +message.getSequence());
				System.out.println("enviando bytes: " +message.getData().length);
				sleep(3000);
				response = client.send(message);
				
				//mostra a resposta
				System.out.println("response from server: " +response);
				sleep(5000);
			}
		}
	}
	
	public static void sleep(int s) {
//		System.out.println("sleeping "+s);
		try {
			Thread.sleep(s);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public boolean validateResponse(String sequence) {
		return true;
	}
}
