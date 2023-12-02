import java.io.*;

public class SalvarTime {
    public static void salvarTime(Time time, String nomeArquivo) {
        try {
            FileOutputStream arquivoOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream out = new ObjectOutputStream(arquivoOut);
            out.writeObject(time);
            out.close();
            arquivoOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static Time carregarTime(String nomeArquivo) {
        Time time = null;
        try {
            FileInputStream arquivoIn = new FileInputStream(nomeArquivo);
            ObjectInputStream in = new ObjectInputStream(arquivoIn);

            time = (Time) in.readObject();
            in.close();
            arquivoIn.close();
        } catch(IOException i) {
            i.printStackTrace();
            return null;
        } catch(ClassNotFoundException c) {
            System.out.println("Classe Time nao encontrada");
            c.printStackTrace();
            return null;
        }
        return time;
    }

}