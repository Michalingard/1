import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static int PORT = 4000;

    public static void main(String [] args) throws IOException {
        log("server starting");
        ServerSocket welcomeSocket = new ServerSocket(PORT);
        log("Server socket opened");

       Socket clientSocket = welcomeSocket.accept();

       String clientAddress = clientSocket.getInetAddress().toString();
       int clientPort = clientSocket.getPort();
       log("Client connected from:" + clientAddress + ":" + clientPort);

        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();

        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        String request = br.readLine();
        log("Request:" + request);

        String[] params = request.split(" ");

        if ("LOGIN".equals(params[0]) && "Ala".equals(params[1])) {
            String response = "LOGIN OK insert PASSWORD";
            bw.write(response);
            bw.newLine();
            bw.flush();
        }

        else {
            String response = "LOGIN INCORRECT. PLEASE, TRY AGAIN";
            bw.write(response);
            bw.newLine();
            bw.flush();
        }

        String request2 = br.readLine();
        log("Request:" + request2);

        params = request2.split(" ");

        if ("PASSWORD".equals(params[0]) && "JAN".equals(params[1])) {
            String response = "PASSWORD OK. WELCOME";
            bw.write(response);
            bw.newLine();
            bw.flush();
        }

        else{
            String response = "PASSWORD INCORRECT. YOU DIED";
            bw.write(response);
            bw.newLine();
            bw.flush();
        }
/*
        String[] params = request.split(" ");

        if ("LOGIN".equals(params[0]) && "Ala".equals(params[1])) {
            String response = "LOGIN OK insert PASSWORD";
            bw.write(response);
            bw.newLine();
            bw.flush();
        }
        */
        welcomeSocket.close();
        log("Server socket closed");
        log("Server ends");
    }

    public static void log(String message){
        System.out.println("(S): " + message);

    }




}
