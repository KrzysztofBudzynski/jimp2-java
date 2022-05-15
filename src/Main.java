public class Main {
    public static void main(String[] args) {
        Labirynt l = new Labirynt(10, 10 );
        if( args.length > 0 ) {     //test czy dobrze powstają punkty i krawędzi
            l.getPkt().forEach(System.out::println);
            long n = l.getPkt().stream().count();
            System.out.println(n + " punktow");
        }
        l.genWagi();
    }
}
