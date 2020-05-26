package projeto2;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
     public static void main(String[] args) {
         try {
             InetAddress endereco_remoto;
             int porta_remota;
             
             ServerSocket s = new ServerSocket(2000);
             System.out.println("Esperando Conexão................");
             
             Socket conexao = s.accept();
             System.out.println("Conexão aceita,esperando dados.......");
             
             endereco_remoto = conexao.getInetAddress();
             porta_remota = conexao.getPort();
             
             System.out.println("Nome da maquina remota: "+endereco_remoto.getHostName());
             System.out.println("Ip da maquina remota: "+endereco_remoto.getHostAddress());
             System.out.println("Porta da maquina remota: "+porta_remota);
             
             
             DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
             DataInputStream entrada = new DataInputStream(conexao.getInputStream());
             
             for(int i = 0; i<100000;i++){
              int resp = entrada.readInt();
              System.out.println("entrei");
              saida.writeUTF("RECEBI SEU DADO: "+ resp);
             }
             
             
         } catch (IOException ex) {
             Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
         }
	}
    
}
