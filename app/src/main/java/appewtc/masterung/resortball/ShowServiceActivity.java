package appewtc.masterung.resortball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ShowServiceActivity extends AppCompatActivity {

    //Explicit
    private TextView showNameTextView;
    private ListView serviceListView;
    private String nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service);

        //Bind Widget
        bindWidget();

        //Show View
        showView();

    } // Main Method

    private void showView() {
        nameString = getIntent().getStringExtra("NameUser");
        showNameTextView.setText(nameString);
    }

    private void bindWidget() {
        showNameTextView = (TextView) findViewById(R.id.textView7);
        serviceListView = (ListView) findViewById(R.id.listView);
    }

    public void clickReadOrder(View view) {

    }   // clickReadOrder

}   // Main Class
