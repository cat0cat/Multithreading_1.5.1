import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 23444);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String num;
            while (true) {
                System.out.println("Введите целое число или 'end' для завершения");
                num = scanner.nextLine();
                out.println(num);
                if ("end".equals(num)) {
                    break;
                }
                System.out.println("SERVER: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

// Выбран способ взаимодействия Java IO, т.к. не требуются промежуточные данные, нужен конечный результат.

// Потоки ввода/вывода (streams) в Java IO являются блокирующими.
// Это значит, что когда в потоке выполнения (tread) вызывается read() или write() метод любого класса
// из пакета java.io.*, происходит блокировка до тех пор, пока данные не будут считаны или записаны.
// Поток выполнения в данный момент не может делать ничего другого.

}
