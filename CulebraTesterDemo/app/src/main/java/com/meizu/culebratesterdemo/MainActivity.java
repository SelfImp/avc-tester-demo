package com.meizu.culebratesterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import br.com.dina.ui.widget.UITableView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    UITableView tableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableView = (UITableView) findViewById(R.id.tableView);
        createTaleList();
        Log.d(TAG, "total items: " + tableView.getCount());
        tableView.commit();

    }

    private void createTaleList() {
        CustomClickListener listener = new CustomClickListener();
        tableView.setClickListener(listener);
        tableView.addBasicItem("CulebraTester 1 - ViewClient", "Touch button");
        tableView.addBasicItem("CulebraTester 2 - ViewClient", "Press");
        tableView.addBasicItem("CulebraTester 3 - ViewClient", "Long press");
        tableView.addBasicItem("CulebraTester 4 - ViewClient", "Drag screen");
        tableView.addBasicItem("CulebraTester 5 - ViewClient", "Reserved");
    }

    private class CustomClickListener implements UITableView.ClickListener {

        @Override
        public void onClick(int index) {
            Log.d(TAG, "item clicked: " + index);
            if(index == 0) {
                Toast.makeText(MainActivity.this, "Do not touch me!!!", Toast.LENGTH_SHORT).show();
            }
            else if(index == 1) {

            }
            else if(index == 2) {

            }
            else if(index == 3) {
                Intent i = new Intent(MainActivity.this, DragScreenActivity.class);
                startActivity(i);
            }
            else if(index == 4) {

            }
        }

    }
}
