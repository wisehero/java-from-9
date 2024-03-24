package wisehero.lec05;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Future;

public class CoffeePublisher implements Flow.Publisher<String> {
	@Override
	public void subscribe(Flow.Subscriber<? super String> subscriber) {
		subscriber.onSubscribe(new CoffeeSubScription(subscriber));
	}

	public static class CoffeeSubScription implements Flow.Subscription {

		private final Flow.Subscriber<? super String> subscriber;
		private Future<?> future;

		public CoffeeSubScription(Flow.Subscriber<? super String> subscriber) {
			this.subscriber = subscriber;
		}

		@Override
		public void request(long n) {
			if (n < 0) {
				subscriber.onError(new IllegalArgumentException());
			} else {
				future = CompletableFuture.runAsync(() -> {
					try {
						Thread.sleep(1_000);
						subscriber.onNext("아메리카노");
					} catch (InterruptedException e) {

					}
				});
			}
		}

		@Override
		public void cancel() {
			if (future != null) {
				future.cancel(false);
			}
		}
	}
}
