import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static Labirynt readLabirynt( String path ) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int ln = 0;
        String [] words;

        line = br.readLine();
        ln++;

        words = line.split("\\s+");

        if( words.length != 2 ) {
            throw new IOException("zły format pliku");
        }

        int h = Integer.parseInt(words[0]);
        int w = Integer.parseInt(words[1]);

        Labirynt l = new Labirynt(h, w);
        return l;
    }
}
