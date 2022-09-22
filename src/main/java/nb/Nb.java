package nb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class Nb {
    int n = 8;
    List<Paire> ens0 = new ArrayList<>();
    Supplier<IntStream> I = () -> range(1, n+1);

    public Nb() {

        I.get().forEach(k -> I.get().forEach(l ->
                {
                    if (k <= l) ens0.add(new Paire(k, l));
                }
        ));
        for(Paire p:ens0)
            System.out.print(p+";");
    }

    private static class Paire {
        int k, l;

        public Paire(int k, int l) {
            this.k = k;
            this.l = l;
        }

        @Override
        public String toString() {
            return "(" + k + "," + l + ")";
        }
    }

    public static void main(String[] args) {
        new Nb();

    }
}
