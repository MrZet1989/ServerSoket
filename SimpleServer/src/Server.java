import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server stated!");

            try (

                Socket socket = server.accept();
                BufferedWriter write =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
                   BufferedReader reader =
                           new BufferedReader(
                                   new InputStreamReader(
                                           socket.getInputStream()));

            )

            {
                String reqest = reader.readLine();
                write.write("Hello From Server " + reqest.length());
                write.newLine();
                write.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
