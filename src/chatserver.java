import java.io.*;
import java.net.*;
public class chatserver
{
  public static void main(String args[]) throws IOException
  {
	ServerSocket ss = null;
	Socket socket =null;
	int i=1;		
	String message = null;	
	ss = new ServerSocket(10008);
	System.out.println("Server    socket is created and waiting for client");
		
	socket = ss.accept();		
	DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
	DataInputStream istream = new DataInputStream(socket.getInputStream());
		
    while(true)
    { 
	 message = istream.readUTF();
	 System.out.println("Client Says: "+message);
	 
	 while(i<5)
	 {
		 int v=Integer.parseInt(message);
		 if(v==i)
		 {
		 message = "ok"; 
		 ostream.writeUTF(message);
		 i++;
		 break;
		 }
		 else
		 {	
message = "error"; 
			 ostream.writeUTF(message);
			 i=1;
			 break;	 
		 }
	  }
     }	    
   }
}



