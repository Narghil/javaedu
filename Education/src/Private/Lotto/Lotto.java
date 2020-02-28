package Private.Lotto;

public class Lotto {
    public static void main(String[] args) {
        NMLotto sixerLotto = new NMLotto( 45, 6);
        NMLotto fiverLotto = new NMLotto( 90,5);

        sixerLotto.generateNumbers();
        sixerLotto.printNumbers();

        fiverLotto.generateNumbers();
        fiverLotto.printNumbers();
    }
}
