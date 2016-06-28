package com.meizu.culebratesterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

public class DragScreenActivity extends Activity {

	private static final String TAG = "DragScreenActivity";

	UITableView tableView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragscreen);

        tableView = (UITableView) findViewById(R.id.tableView);

        createList();
        
        Log.d(TAG, "total items: " + tableView.getCount());
        
        tableView.commit();
    }
    
    private void createList() {
    	CustomClickListener listener = new CustomClickListener();
    	tableView.setClickListener(listener);
    	tableView.addBasicItem("Example 1", "Summary text 1");
    	tableView.addBasicItem("Example 2", "Summary text 2");
    	tableView.addBasicItem("Example 3", "Summary text 3");
    	tableView.addBasicItem("Example 4", "Summary text 4");
    	tableView.addBasicItem("Example 5", "Summary text 5");
    	tableView.addBasicItem("Example 6", "Summary text 6");
    	tableView.addBasicItem("Example 7", "Summary text 7");
    	tableView.addBasicItem("Example 8", "Summary text 8");  
    	tableView.addBasicItem("Example 9", "Summary text 9");
		tableView.addBasicItem("Example 10", "Summary text 10");
		tableView.addBasicItem("Example 11", "Summary text 11");
		tableView.addBasicItem("Example 12", "Summary text 12");
		tableView.addBasicItem("Example 13", "Summary text 13");
		tableView.addBasicItem("Example 14", "Summary text 14");
		tableView.addBasicItem("Example 15", "Summary text 15");
    }
    
    private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Toast.makeText(DragScreenActivity.this, "Item clicked: " + index, Toast.LENGTH_SHORT).show();
		}
    	
    }
    
}