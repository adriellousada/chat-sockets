package projeto3;

import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) {
        try {
            // TODO Auto-generated method stub

            Socket s = new Socket("localhost", 2001);
            DataOutputStream saida = new DataOutputStream(s.getOutputStream());
            DataInputStream entrada = new DataInputStream(s.getInputStream());

            String linha;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println(">");
                linha = teclado.readLine();
                saida.writeUTF(linha);
                linha = entrada.readUTF();
                if (linha.equalsIgnoreCase("")) {
                    System.out.println("Conexão encerrada!");
                    break;
                }
                System.out.println(linha);
            }

        } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

            System.out.println(ex.getMessage());
        }

    }
}
