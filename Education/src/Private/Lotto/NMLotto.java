package Private.Lotto;

import java.util.Random;

public class NMLotto {
    private int maxNumber, howManyNumber;
    private int[] randomNumbers;

    public NMLotto(int maxNumber, int howManyNumber) {
        this.maxNumber = maxNumber;
        this.howManyNumber = howManyNumber;
        randomNumbers = new int[howManyNumber];
    }

    public void sortNumbers(){
        int n;
        for( int i = 0; i < (howManyNumber -1); i++){
            for( int j = i+1; j < howManyNumber; j++){
                if( randomNumbers[i] > randomNumbers[j]){
                    n = randomNumbers[i];
                    randomNumbers[i] = randomNumbers[j];
                    randomNumbers[j] = n;
                }
            }
        }
    }

    public void generateNumbers() {
        Random random = new Random();
        for (int i = 1; i <= this.howManyNumber; i++) {
            this.randomNumbers[i - 1] = random.nextInt(this.maxNumber) + 1;
            try {
                random.wait(i,i);
            } catch (Exception e){}
        }
        sortNumbers();
    }

    public void printNumbers() {
        System.out.print("A(z) " + this.howManyNumber + "-s lottó számai: ");
        for (int i = 1; i <= this.howManyNumber; i++) {
            System.out.print(randomNumbers[i - 1] + " ");
        }
        System.out.println();
        System.out.println();

    }
}
