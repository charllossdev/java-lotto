package lotto.modal;

import java.util.Arrays;

public enum LottoRank {

	NOTHING_RANK(0, 0),
	FIFTH_RANK(3, 5000),
	FOURTH_RANK(4, 50000),
	THIRD_RANK(5, 1500000),
	SECOND_RANK(5, 30000000),
	FIRST_RANK(6, 2000000000);

	private final int matchCount;
	private final int winnerPrize;
	private final String resultMsg;

	LottoRank(int matchCount, int winnerPrize) {
		String tempResultMsg;
		this.matchCount = matchCount;
		this.winnerPrize = winnerPrize;
		tempResultMsg = matchCount + "개 일치 (" + winnerPrize + "원)-";

		if (winnerPrize == 30000000) {
			tempResultMsg = matchCount + "개 일치, 보너스 볼 일치 (" + winnerPrize + "원)-";
		}
		this.resultMsg = tempResultMsg;
	}

	public static LottoRank getRank(int matchCount, boolean hasBonusNumber) {

		return Arrays.stream(values())
			.filter(lottoRank -> lottoRank.isMatch(matchCount))
			.filter(lottoRank -> !(lottoRank.equals(THIRD_RANK) && hasBonusNumber))
			.findFirst()
			.orElse(NOTHING_RANK);
	}

	public int getWinnerPrize() {
		return winnerPrize;
	}

	public String getRankMessage() {
		return resultMsg;
	}

	private boolean isMatch(int matchCount) {

		return this.matchCount == matchCount;
	}
}
