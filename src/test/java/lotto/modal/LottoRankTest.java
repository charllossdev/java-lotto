package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottoRankTest {

	@Test
	void listTest() {

		List<LottoRank> list = new ArrayList<>(Arrays.asList(LottoRank.values()));

		System.out.println(list);

		System.out.println(list.stream()
			.mapToLong(LottoRank::getWinnerPrize)
			.sum());
	}

	@Test
	void init6MatchRankTest() {

		LottoRank rank = LottoRank.getRank(6, false);
		assertThat(rank).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	void init5MatchBonusRankTest() {

		LottoRank rank = LottoRank.getRank(5, true);
		assertThat(rank).isEqualTo(LottoRank.SECOND_RANK);
	}

	@Test
	void init5MatchRankTest() {

		LottoRank rank = LottoRank.getRank(5, false);
		assertThat(rank).isEqualTo(LottoRank.THIRD_RANK);
	}

	@Test
	void init4MatchRankTest() {

		LottoRank rank = LottoRank.getRank(4, false);
		assertThat(rank).isEqualTo(LottoRank.FOURTH_RANK);
	}

	@Test
	void init3MatchRankTest() {

		LottoRank rank = LottoRank.getRank(3, false);
		assertThat(rank).isEqualTo(LottoRank.FIFTH_RANK);
	}

	@Test
	void initNothingRankTest() {

		LottoRank rank = LottoRank.getRank(0, false);
		assertThat(rank).isEqualTo(LottoRank.NOTHING_RANK);
	}

}
