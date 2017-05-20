import java.io.*;
import java.net.*;
public class chatclient
{	  public static void main(String args[]) throws IOException
   {
	Socket cs = null;
	String message = null;	
	cs = new Socket("LocalHost",10008);
	System.out.println("Client socket is created and waiting for server");
	DataOutputStream ostream = new DataOutputStream(cs.getOutputStream());
	DataInputStream istream = new DataInputStream(cs.getInputStream());	
	while(true)
	{
		System.out.println("Client Says:");
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	 
	 message = br.readLine();
	 ostream.writeUTF(message);
	 ostream.flush();
	 message = istream.readUTF();
	 System.out.println("Server Says:" +message);
	 if(message.contains("error"))
	 {
		 String m = "Resending the frames"; 
		 System.out.println("Client Says:" +m);
		 ostream.flush();
	}	  		 
    }	}	
}


