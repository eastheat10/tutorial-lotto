import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    Random random = new Random();

    /**
     * 로또 발행
     * Random class 사용해서 번호 만들기
     * 중복 처리를 어떻게 할지 고민해보세요
     * (참고: boolean 배열 활용, new boolean[46];)
     *
     * @param n 로또 발행 개수
     * @return n개의 로또
     */
    public Lotto[] issueLotto(int n) {
        Lotto[] lottos = new Lotto[n];
        boolean[] checked = new boolean[46];

        for (int i=0;i<n;i++){
            lottos[i] = GenerateLotto();
        }
        return lottos;
    }

    /**
     * 당첨 로또 발행
     *
     * @return 당첨번호를 가진 로또
     */
    public Lotto issueWinLotto() {
        return GenerateLotto();
    }

    /**
     * 당첨 여부 판단
     * 결과 출력
     *
     * @see <a href="https://t1.daumcdn.net/cfile/tistory/99E25A3359FB2FF62D">로또 당첨 참고</a>
     */
    public void printResult(Lotto myLotto, Lotto winLotto) {
        int[] myNumbers = myLotto.getNumbers().clone();
        int[] winNumbers = winLotto.getNumbers().clone();
        int bonusNum = winLotto.getBonusNumber();
        AtomicBoolean bonusTag = new AtomicBoolean(false);
        AtomicInteger count = new AtomicInteger();
        IntStream myNumStream =  Arrays.stream(myNumbers);
        Set<Integer> winNumSet = Arrays.stream(winNumbers).boxed().collect(Collectors.toSet());

        myNumStream.forEach((i)->{
            System.out.print(i+" ");
            if(winNumSet.contains(i)){
                  count.getAndIncrement();
            }
            if(i==bonusNum){
                bonusTag.set(true);
            }
        });
        printRank(count.get(), bonusTag.get());
    }

    public Lotto GenerateLotto(){
        List<Integer> numList = new ArrayList<>();
        boolean[] checked = new boolean[46];
        while (numList.size() != 7){
            int pickNum = random.nextInt(45)+1; // 1~45 까지 픽
            if(checked[pickNum]==true){
                continue;
            }
            numList.add(pickNum);
            checked[pickNum] = true;
        }
        int[] numbers = numList.stream().mapToInt(Integer::intValue).limit(6).toArray();
        Arrays.sort(numbers);

        int bonusNum = numList.get(6);

        Lotto lotto = new Lotto(numbers,bonusNum);
        return lotto;
    }

    public void printRank(int count,boolean bonusTag){
        if(count == 6){
            System.out.println(" -> 1등 당첨!");
        }
        if(count == 5 && bonusTag){
            System.out.println(" -> 2등 당첨!");
        }
        if(count == 5 && !bonusTag){
            System.out.println(" -> 3등 당첨!");
        }
        if(count == 4){
            System.out.println(" -> 4등 당첨!");
        }
        if(count == 3){
            System.out.println(" -> 5등 당첨!");
        }
        if(count < 3){
            System.out.println(" -> 꽝");
        }
    }

}
