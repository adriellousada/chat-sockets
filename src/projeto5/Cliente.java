/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

    public static void main(String[] args) {

        try {

            String envio;
            DatagramSocket s = new DatagramSocket();
            InetAddress dest = InetAddress.getByName("localhost");

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("> ");
            envio = teclado.readLine();

            while (!envio.equalsIgnoreCase("")) {
                byte[] buffer = envio.getBytes();
                DatagramPacket msg = new DatagramPacket(buffer, buffer.length, dest, 4545);
                s.send(msg);
                DatagramPacket resposta = new DatagramPacket(new byte[512], 512);

                for (int i = 0; i < resposta.getLength(); i++) {
                    System.out.print((char) resposta.getData()[i]);
                }
                System.out.println();
                System.out.println("> ");
                envio = teclado.readLine();
            }
            
            s.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
