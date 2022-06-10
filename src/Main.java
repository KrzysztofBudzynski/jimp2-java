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
            try {
                l = Utils.readLabirynt(args[1]);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                return;
            }
        }
        System.out.println("wczytano " + l.getN());
        System.out.println(l.testWag());

        Dijkstra d = new Dijkstra(l, 0);
        d.launch();

        try {
            double[] wynik = Utils.initDijkstra(l, 0);
            for( double db : wynik ) {
                System.out.println(db);
            }
            for( int i = 0; i < wynik.length; i++ ) {
                if( wynik[i] != d.getMin()[i] ) {
                    System.out.println("TA? TO CHUJOWO");
                }
            }
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
        }

        Dfs df = new Dfs(l, 0);
        df.launch();
        System.out.println(df.getSpojny());
    }
}
