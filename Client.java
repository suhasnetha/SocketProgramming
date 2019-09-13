// File Name Client.java
import java.net.*;
import java.io.*;
import java.util.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Client {

   
   public static void main(String [] args) {
      String serverName = "localhost";

      int port = 8080;
      try {

        System.out.println("Connecting to Server");
              while (true) {
	Socket client = new Socket(serverName, port);
              
              OutputStream outToServer = client.getOutputStream();
              DataOutputStream out = new DataOutputStream(outToServer);
              DataOutputStream out1 = new DataOutputStream(outToServer);
              Scanner myObj = new Scanner(System.in);
              System.out.println("Enter a message OR Type Exit to End communication");
              String line = myObj.nextLine();
              String key = "1234567812345678"; // assigning a key
              Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
              Cipher cipher = Cipher.getInstance("AES");
              cipher.init(Cipher.ENCRYPT_MODE, secretKey);
              byte[] outputBytes = cipher.doFinal(line.getBytes());
              out.writeUTF(new String(Base64.encodeBase64(outputBytes)));
              if (line.toString().equals("Exit")) {
                  InputStream inFromServer = client.getInputStream();
                  DataInputStream in = new DataInputStream(inFromServer);
                  System.out.println("Server:" + in.readUTF());
                  out1.writeUTF("Thank You");
                  client.close();
                  break;
              }
          }
      }
       catch (Exception e) {
         e.printStackTrace();
      }
   }
}
