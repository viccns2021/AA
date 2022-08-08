import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

	public class Server {
		
		public static void main(String[] args) throws Exception{

	        try{

	        DatagramSocket serverSocket = new DatagramSocket(10078);
	        System.out.println("Servidor Ligado");
	        Mensagem msg = new Mensagem();

	        while(true){

	  // VALOR DO MENU INTERATIVO  

	        byte[] recBuffer = new byte[1024];
	        DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
	        serverSocket.receive(recPkt);//bloking
	        String inf = new String(recPkt.getData(),recPkt.getOffset(),recPkt.getLength());
	        System.out.println(inf);     
	        String inf2 = msg.res;
	        System.out.println(inf2);     
	        
	        if (inf.equalsIgnoreCase(msg.res)) {
	        	
	        	
		        byte[] sendBuf = new byte[1024];
		        sendBuf = "CONEXÂO FEITA".getBytes();
		        InetAddress IPAddress = recPkt.getAddress();
		        int port = recPkt.getPort();

		        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, IPAddress, port);      
		        serverSocket.send(sendPacket);
	        	
	        }
	        	
	        else {
	        byte[] sendBuf = new byte[1024];
	        sendBuf = "ERRO DE CONEXÂO".getBytes();
	        InetAddress IPAddress = recPkt.getAddress();
	        int port = recPkt.getPort();

	        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, IPAddress, port);      
	        serverSocket.send(sendPacket);
	        }
	        
	        }}catch (Exception e) { }}}

