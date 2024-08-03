package org.fernando.salas.part17;

import java.util.concurrent.Flow.*;

public class Main {
    private static Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }

    public static void main(String[] args) {
        getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
    }
}
