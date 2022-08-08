import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws Exception{
        


        try{

            DatagramSocket clientSocket = new DatagramSocket();//escolhe porta pra vc
            InetAddress IPAddress = InetAddress.getByName("127.0.0.1"); 
            Scanner sc = new Scanner(System.in);        
            Mensagem msg = new Mensagem();

System.out.println("Digite sua msg!" );

// Variavel a ser enviada

    byte[] sendData = new byte[1024];  
    sendData = msg.res.getBytes();
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 10078);
    clientSocket.send(sendPacket);
    System.out.println(msg.res);
    

    byte[] recBuffer = new byte[1024];
    DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
    clientSocket.receive(recPkt);
    String informacao = new String(recPkt.getData(),recPkt.getOffset(),recPkt.getLength());
    System.out.println(informacao);

    clientSocket.close();
    sc.close();} catch (Exception e) {}}}

