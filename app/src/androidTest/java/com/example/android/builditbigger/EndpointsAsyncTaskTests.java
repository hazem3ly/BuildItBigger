package com.example.android.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;

/**
 * Created by HazemAli on 11/24/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTests {

    @Test
    public void asyncTaskTest() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.OnResultReady() {
            @Override
            public void ResultReady(String result) {
                assertNotNull(result);
                signal.countDown();
            }
        });

        endpointsAsyncTask.execute();
        signal.await();// wait for callback

    }

}

