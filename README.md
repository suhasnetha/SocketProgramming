# SocketProgramming
The goal of this assignment is to give you practical experience in using cryptographic libraries to implement encryption functionality in your code, especially in regard to data in transit i.e. network communications.

Prerequisite: Need to download and import org.apache.commons.codec.binary.Base64 library jar file to execute the code. Use below link to download.
http://www.java2s.com/Code/Jar/c/Downloadcommonscodec17jar.htm

1.	Analyse the client and server code which was provided

2.	Executed the socket programs in Windows command prompt, which gets terminated after a specific message i.e: Exit

3.	Modified the Code to keep up continuous messaging. Inserted while loop to continuously check for messages from either party and reply accordingly.

4.	Set the End of Communication string as ‘Exit’. At client end, after input of every message, checked the message if it matches to Exit. If matched, breaking the while loop and closing the connection. At server side, after receiving a message from client and decrypting it, checking it if it matches the Exit message. If matches, breaking the while loop and closing the connection.

5.	 Using org.apache.commons.codec.binary.Base64 underlying AES encryption and decryption algorithm to encrypt and decrypt the message. Imported the required header files for AES. Set a Symmetric key. At client side, took input from message, encrypted the message using AES encryption and once received a message from server, decrypted the message. At server side, when a message is received, decrypted it using the symmetric key and AES algorithm, and when sending a message, encrypted the message using the same key and AES encryption algorithm.

6.	When a message is received from either party, please find below screenshot displayed the received encrypted message and after decrypting, displayed the decrypted message.
