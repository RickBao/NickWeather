package com.example.library;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class RxSchedulerUtils {

    /**
     * 在Rxjava的使用过程中我们会频繁的调用subscribeOn和observeOn()，通过Transformer结合
     * Observable.compose()我们可以服用这些代码；
     *
     * @return Transformer
     */
    public static <T> Observable.Transformer<T, T> normalSchedulersTransformer() {

        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
