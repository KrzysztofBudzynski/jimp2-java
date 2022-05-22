import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labirynt {
    private final int h;
    private final int w;
    private final int n;

    private List<Punkt> pkt;

    public Labirynt( int h, int w ) {
        this.h = h;
        this.w = w;
        this.n = w * h;
        pkt = new ArrayList<>();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                pkt.add(new Punkt(i, j, w));
            }
        }
        for( int i = 0; i < n; i++ ) {
            if(i-w < n && i-w >= 0) {
                pkt.get(i).getEdges().add(new Edge(pkt.get(i), pkt.get(i-w)));
            } else pkt.get(i).getEdges().add(new Edge());
            if((i + 1) % w != 0) {
                pkt.get(i).getEdges().add(new Edge(pkt.get(i), pkt.get(i+1)));
            } else pkt.get(i).getEdges().add(new Edge());
            if(i+w < n && i+w >= 0) {
                pkt.get(i).getEdges().add(new Edge(pkt.get(i), pkt.get(i+w)));
            } else pkt.get(i).getEdges().add(new Edge());
            if(i % w != 0) {
                pkt.get(i).getEdges().add(new Edge(pkt.get(i), pkt.get(i-1)));
            } else pkt.get(i).getEdges().add(new Edge());
        }
    }

    public void genWagi() {
        Random r = new Random();
        for( Punkt p : pkt ) {
            for( int i = 0; i < 2; i++ ) {
                if( p.getEdges().get(i).getTo() != null ) {
                    p.getEdges().get(i).setWaga(r.nextDouble());
                    p.getEdges().get(i).getTo().getEdges().get(i+2)
                            .setWaga(p.getEdges().get(i).getWaga());
                }
            }
        }
    }

    public boolean testWag() {      // raczej działa
        for( int i = 0; i < this.n; i++ ) {
            for( int k = 0; k < 2; k++ ) {
                if( pkt.get(i).getEdges().get(k).getTo() != null ) {
                    if( pkt.get(i).getEdges().get(k).getWaga() !=
                        pkt.get(i).getEdges().get(k).getTo().getEdges().get(k+2).getWaga())
                        return false;
                }
            }
        }
        return true;
    }

    public List<Punkt> getPkt() {
        return pkt;
    }

    public int getN() {
        return n;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
}
