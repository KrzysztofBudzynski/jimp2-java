import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Labirynt l = new Labirynt(10, 10);
        if (args.length == 1) {     //test czy dobrze powstają punkty i krawędzi
            l.getPkt().forEach(System.out::println);
            long n = l.getPkt().stream().count();
            System.out.println(n + " punktow");
            l.genWagi();
        }
        if (args.length == 2) {
            try {                   //C:\Users\kszyh\IdeaProjects\jimp2-java\Dane\test.txt
                l = Utils.readLabirynt(args[1]);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                return;
            }
        }
        System.out.println("wczytano " + l.getN());
        System.out.println(l.testWag());

        try {
            double[] wynik = Utils.initDijkstra(l, 0);
            for( double d : wynik ) {
                System.out.println(d);
            }
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
        }
    }
}
