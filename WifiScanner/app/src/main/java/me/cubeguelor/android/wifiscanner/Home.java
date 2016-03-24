package me.cubeguelor.android.wifiscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button mScanNetworkBtn;
    private Button mHeatmapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mScanNetworkBtn = (Button)findViewById(R.id.scan_Networkbtn);
        mScanNetworkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanNetworkIntent = new Intent(Home.this, MainActivity.class);
                startActivity(scanNetworkIntent);
            }
        });

        mHeatmapBtn = (Button)findViewById(R.id.heat_mapbtn);

        mHeatmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
