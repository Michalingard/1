import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private final static int  SERVER_PORT = 4000;
    private final static String SERVER_NAME = "localhost";

    public static void main(String[] args) throws IOException {

        log("Client starting");
        InetAddress serverAddress = InetAddress.getByName(SERVER_NAME);
        log("Server address resolved:" + serverAddress.toString());
        log("Connecting to the server:" + serverAddress.toString()+":" + SERVER_PORT);
        Socket clientSocket = new Socket(serverAddress, SERVER_PORT);

        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();

        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        log("Stream collected");

        String request = "LOGIN Ala";
        bw.write(request);
        bw.newLine();
        bw.flush();

        String response = br.readLine();
        log("Response:" + response);

        String request2 = "PASSWORD JAN";
        bw.write(request2);
        bw.newLine();
        bw.flush();

        log("Client socket closing");
        clientSocket.close();
        log("Client socket Closed");
        log("Client ends");
    }

    public static void log(String message) {
        System.out.println("(C): " + message);
    }
}