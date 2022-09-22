package nb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class Nb {
    int n = 8;
    List<Paire> ens0 = new ArrayList<>();
    Supplier<IntStream> I = () -> range(1, n + 1);
    List<Paire>[][] tens = new ArrayList[n + 1][n + 1];

    {
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++)
                tens[i][j] = new ArrayList<>();
    }


    public Nb() {

//        I.get().forEach(k -> I.get().forEach(l ->
//                {
//                    if (k <= l) ens0.add(new Paire(k, l));
//                }
//        ));
//        for(Paire p:ens0)
//            System.out.print(p+";");

        I.get().forEach(j -> I.get().forEach(i ->
                I.get().forEach(k -> I.get().forEach(l ->
                        {
                            if (k != i && k != j && l != i && l != j) tens[i][j].add(new Paire(k, l));
                        }
                ))
        ));
        I.get().forEach(j -> I.get().forEach(i ->

                {
                    System.out.println("("+i+","+j+")");
                    for (Paire t : tens[i][j]) System.out.print(t + ";");
                    System.out.print('\n');
                }
        ));

    }

    public static void main(String[] args) {
        new Nb();

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
}
