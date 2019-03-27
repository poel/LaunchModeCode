package cc.tavan.com.launchmodecode;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.blankj.utilcode.util.LogUtils;

public class ActivityA extends AppCompatActivity {


    private Button toA;
    private Button toB;
    private Button toC;
    private Button toD;
    private Toolbar toolbar;

    public static void launch(Context context) {
        Intent intent = new Intent(context, ActivityA.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.activity_a);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toA = findViewById(R.id.toA);
        toB = findViewById(R.id.toB);
        toC = findViewById(R.id.toC);
        toD = findViewById(R.id.toD);

        toA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityA.launch(ActivityA.this);
            }
        });

        toB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityB.launch(ActivityA.this);
            }
        });

        toC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityC.launch(ActivityA.this);
            }
        });

        toD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityD.launch(ActivityA.this);
            }
        });

        LogUtils.e(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    protected void onResume() {
        super.onResume();

        LogUtils.e(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        LogUtils.e(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
