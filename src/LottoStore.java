public class LottoStore {

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
        return new Lotto[]{};
    }

    /**
     * 당첨 로또 발행
     *
     * @return 당첨번호를 가진 로또
     */
    public Lotto issueWinLotto() {
        return new Lotto(null, 0);
    }

    /**
     * 당첨 여부 판단
     * 결과 출력
     *
     * @see <a href="https://t1.daumcdn.net/cfile/tistory/99E25A3359FB2FF62D">로또 당첨 참고</a>
     */
    public void printResult(Lotto myLotto, Lotto winLotto) {

    }

}
