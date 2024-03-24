package wisehero.lec06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		unmodifableExample();
	}

	private static void varExample() {
		var num = 3;
		// num = 10L; -> Compile Error

		var list = List.of(1, 2, 3); // 이렇게 리스트도 만들 수 있고

		Map<String, String> map = Map.of("A", "B"); // 이렇게 만들던 것을
		var map2 = Map.of("A", "B"); // 이렇게 만들 수 있다.

		var var = 3; // 이렇게 만들어도 예약어 제한에 걸리지 않는다. -> 기존 코드와의 호환성 때문!
	}

	private static void copyOfExmaple() {
		List<Integer> oldNums = new ArrayList<>();
		oldNums.add(1);
		oldNums.add(2);

		List<Integer> newNums = List.copyOf(oldNums); // 복사 후 불변 리스트로 생성
		oldNums.add(3);

		oldNums.forEach(x -> System.out.println("old : " + x)); // 1, 2, 3
		newNums.forEach(x -> System.out.println("new : " + x)); // 1, 2
	}

	private static void unmodifableExample() {
		List<Integer> oldNums = new ArrayList<>();
		oldNums.add(1);
		oldNums.add(2);

		List<Integer> newNums = Collections.unmodifiableList(oldNums);
		oldNums.add(3);

		oldNums.forEach(x -> System.out.println("old : " + x)); // 1, 2, 3
		newNums.forEach(x -> System.out.println("new : " + x)); // 1, 2, 3
	}
}
