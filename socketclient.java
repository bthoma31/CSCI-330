import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class socketclient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        PrintWriter outputStream = null;
        Scanner inputStream = null;
        try {
            socket = new Socket("localhost", 6789);
            outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()));
            inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
            System.out.println("Enter a message: ");
            String message = scanner.nextLine();
            outputStream.println(message);
            outputStream.flush();
            System.out.println(inputStream.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
            try {
                socket.close();
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
