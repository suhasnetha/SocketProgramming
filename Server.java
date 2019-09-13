// File Name Server.java
import java.net.*;
import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Server extends Thread {
   private ServerSocket serverSocket;
   
   public Server(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      //serverSocket.setSoTimeout(10000);
   }

   public void run() {

         try {
            System.out.println("Waiting for client... ");
            while(true){
               Socket server = serverSocket.accept();
               DataInputStream in = new DataInputStream(server.getInputStream());
               DataOutputStream out = new DataOutputStream(server.getOutputStream());
               String clientMsg = in.readUTF();
               System.out.println("Message From Client - Before Decryption: "+ clientMsg);
               String key ="1234567812345678";
               Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
               Cipher cipher = Cipher.getInstance("AES");
               cipher.init(Cipher.DECRYPT_MODE, secretKey);
               String decryptedMsg = new String(cipher.doFinal(Base64.decodeBase64(clientMsg.getBytes())));
               System.out.println("After Decryption: "+ decryptedMsg);
                if(decryptedMsg.equals("Exit")) {
                  out.writeUTF("Thank you for connecting\nGoodbye!");
                  DataInputStream in1 = new DataInputStream(server.getInputStream());
                  System.out.println(in1.readUTF());
                  server.close();
                  break;
               }
            }
         }
         catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
	    System.out.println("Connection ended!");	
            
         } catch (Exception e) {
            e.printStackTrace();
         }

   }
   
   public static void main(String [] args) {
      int port = 8080;
      try {
         Thread t = new Server(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
