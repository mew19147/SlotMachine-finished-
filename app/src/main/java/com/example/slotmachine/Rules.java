package com.example.slotmachine;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;

public class Rules extends MainActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private Button back;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);
        back = findViewById(R.id.Back);
        configureback();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void configureback() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
