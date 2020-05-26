package projeto2;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {
        try {
            // TODO Auto-generated method stub
            
            Socket s = new Socket("127.0.0.1",2000);
            DataOutputStream saida = new DataOutputStream(s.getOutputStream());
            DataInputStream entrada = new DataInputStream(s.getInputStream());
            
            for(int i = 0; i<100000;i++){
                
                saida.writeInt(i);
                System.out.println("enviei "+i);
                String en = entrada.readUTF();
                System.out.println("recebi"+en);
            }   } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(ex.getMessage());
        }

	}
}
