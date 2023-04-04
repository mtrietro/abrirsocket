
import java.net.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        
        String site = JOptionPane.showInputDialog("Digite a URL de um site: ");
        int socket = parseInt(JOptionPane.showInputDialog("Digite sua socket/port: "));
        
        try {
            Socket sock = new Socket(site, socket);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String linha = "";
            out.println("GET / HTTP/1.0\n");
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
