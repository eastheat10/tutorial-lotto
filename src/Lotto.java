
public class Lotto {

    private final int[] numbers;    // 로또 번호
    private final int bonusNumber;  // 당첨 번호

    public Lotto(int[] numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
