import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("발행을 원하는 로또 개수를 입력해주세요: ");
        int n = sc.nextInt();   // 로또 개수

        Lotto[] myLottoArr;
        LottoStore store = new LottoStore();

        myLottoArr = store.issueLotto(n).clone(); // 로또 n개 구매
        Lotto winLotto = store.issueWinLotto(); // 당첨 로또 발행

        System.out.println("[이번주 로또 번호]");
        for (int i : winLotto.getNumbers()){
            System.out.print(i+" ");
        }
        System.out.println("보너스 번호 : "+winLotto.getBonusNumber());

        for (Lotto lotto : myLottoArr){
            store.printResult(lotto,winLotto);
        }

    }

}
