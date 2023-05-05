import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("발행을 원하는 로또 개수를 입력해주세요: ");
        int n = sc.nextInt();   // 로또 개수
        LottoStore lottoStore = new LottoStore();
        Lotto[] myLotto = lottoStore.issueLotto(n);
        Lotto winLotto = lottoStore.issueWinLotto();
        for (Lotto lotto: myLotto) {
            lottoStore.printResult(lotto, winLotto);
        }

    }

}

