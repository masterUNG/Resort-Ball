package appewtc.masterung.resortball;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        //Create ListView
        createListView();

    } // Main Method

    private void createListView() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.service_table, null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        String[] iconStrings = new String[intCount];
        String[] priceStrings = new String[intCount];
        String[] nameStrings = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            iconStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Category));

            cursor.moveToNext();
        }   // for
        cursor.close();

        MyAdapter myAdapter = new MyAdapter(this,
                iconStrings, priceStrings, nameStrings);
        serviceListView.setAdapter(myAdapter);


    }   // createListView

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
