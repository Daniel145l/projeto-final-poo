import java.io.*;

public class GerenciadorArquivo {

    public static void salvarTime(Time time, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(time);
            System.out.println("Time salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("ERRO 1");
            e.printStackTrace();
        }
    }

    public static Time carregarTime(String nomeArquivo) {
        Time time = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            time = (Time) inputStream.readObject();
            System.out.println("Time carregado com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            // e.printStackTrace();
        }
        return time;
    }
}

