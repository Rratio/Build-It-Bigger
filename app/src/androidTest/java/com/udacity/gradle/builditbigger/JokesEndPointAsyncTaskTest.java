package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class JokesEndPointAsyncTaskTest {

    private String joke = null;
    private static String TAG = EndPointAsyncTask.class.getSimpleName();

    @Test
    public void testJokeFromAsyncTask() throws Exception {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        EndPointAsyncTask asyncTask = new EndPointAsyncTask(null) {
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                joke = result;
                countDownLatch.countDown();
            }
        };

        try {
            asyncTask.execute((Runnable) new Pair<>(InstrumentationRegistry.getTargetContext(), 0));
            countDownLatch.await();
            assertNotNull(joke);
        } catch (InterruptedException e) {
            Log.d(TAG, e.toString());
        }


    }
}
