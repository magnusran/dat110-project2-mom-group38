package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	private static final int[] temps = {
		2, 4, 3, 5, 7, 8, 10, 9, 8, 7
	};

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		Client client = new Client("sensor", "", 8080);
		client.connect();

		for (int i = 0; i < COUNT; i++) {
			int temp = temps[i];
			System.out.println("READING: " + temp);
			client.publish("temperature", Integer.toString(temp));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

		client.disconnect();
		System.out.println("Temperature device stopping ... ");

	}
}
