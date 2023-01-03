package practice.chapter05.utility;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableTimeOutExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .map(num -> {
                    long time = 1000L;
                    if (num == 4) {
                        time = 1500L;
                    }
                    TimeUtil.sleep(time);
                    return num;
                })
                .timeout(1200L, TimeUnit.MILLISECONDS)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(4000L);
    }
}
