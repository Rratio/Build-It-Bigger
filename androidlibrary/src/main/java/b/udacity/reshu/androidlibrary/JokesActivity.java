package b.udacity.reshu.androidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        TextView jokeTxt = findViewById(R.id.joke_txt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Build IT Bigger");
        setSupportActionBar(toolbar);

        String joke = getIntent().getStringExtra("get_joke");

        jokeTxt.setText(joke);

    }
}
