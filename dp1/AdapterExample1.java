
import java.io.*;

public class AdapterExample1 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("input.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        char[] buffer = new char[1024];
        int numCharsRead = 0;

        while ((numCharsRead = inputStreamReader.read(buffer)) > 0) {
            String data = new String(buffer, 0, numCharsRead);
            System.out.print(data);
        }

        inputStreamReader.close();
    }
}
