package main;

import java.util.Scanner;

public class ClientApplication {
	
	@SuppressWarnings("resource")
	static String input() {
		return new Scanner(System.in).next();
	}

	static void show(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		show("2 - Client");
		String app = input();
		if (app.contentEquals("2")) {
			show("Client");
			UDPClient client = new UDPClient();
			client.connect();
			client.sendEcho("teste");
		}
	}
}
