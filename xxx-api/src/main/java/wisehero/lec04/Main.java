package wisehero.lec04;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		delayExample();
	}

	private static void callA() {
		callB();
	}

	private static void callB() {
		callC();
	}

	private static void callC() {
		List<String> walk = StackWalker.getInstance()
				.walk(s -> s.map(StackWalker.StackFrame::getMethodName)
						.collect(Collectors.toList()));

		for (String s : walk) {
			System.out.println("Stack : " + s);
		}
	}

	public static void collectionExample() {
		List<Integer> nums = List.of(1, 2);
		nums.add(3); // -> 예외 발생
		nums.remove(0);
	}

	private static void timeOutExample() throws InterruptedException, ExecutionException {
		// 10초간 기다렸다 '작업 완료'를 출력하는 Runnable
		Runnable sleep = () -> {
			try {
				Thread.sleep(500L);
				System.out.println(System.currentTimeMillis() + " - 작업 완료");
			} catch (InterruptedException e) {

			}
		};

		System.out.println(System.currentTimeMillis() + " - 작업 실행");
		CompletableFuture<Void> future = CompletableFuture.runAsync(sleep)
				.orTimeout(1, TimeUnit.SECONDS); // 1초가 넘으면 익셉션 발생!

		// 실행시킨 비동기 작업이 완료될 떄까지 현재 스레드를 멈추는 기능
		future.get();
	}

	public static void delayExample() throws Exception {
		Executor executor = CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS);
		Runnable sleep = () -> {
			System.out.println(System.currentTimeMillis() + " - 작업 완료");
		};

		System.out.println(System.currentTimeMillis() + " - 작업 실행");
		CompletableFuture<Void> future = CompletableFuture.runAsync(sleep, executor);

		future.get();
	}
}
