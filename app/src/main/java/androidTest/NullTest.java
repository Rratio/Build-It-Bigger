package androidTest;

import android.os.Handler;
import android.os.Looper;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndPointAsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by lenovo-pc on 9/26/2018.
 */

public class NullTest extends AndroidTestCase {

    public void test() {

        String result = null;
        EndPointAsyncTask endPointAsyncTask = new EndPointAsyncTask(getContext(), null);
        endPointAsyncTask.execute();
        try {
            result = endPointAsyncTask.get();
        } catch (InterruptedException e) {
            result = null;
        } catch (ExecutionException e) {
            result = null;
        }

        final String finalResult = result;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        assertNotNull(finalResult);
                    }
                }, 10000);
            }
        }).run();
    }

}