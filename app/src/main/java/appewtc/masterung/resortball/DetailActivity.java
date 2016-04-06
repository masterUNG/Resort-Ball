package appewtc.masterung.resortball;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private TextView nameTextView, descripTextView, priceTextView;
    private ImageView imageView;
    private DatePicker datePicker;
    private String[] resultStrings;
    private String[] imageStrings;
    private int imageAnInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Widget
        bindWidget();

        //Get Value from Intent
        getValueFromIntent();

        //Setup Image
        setupImage();

        //Show View
        showView();

    }   // Main Method

    public void clickOrder(View view) {
        Intent intent = new Intent(DetailActivity.this, OrderActivity.class);
        startActivity(intent);
    }   // clickOrder

    public void clickBackDetail(View view) {
        finish();
    }

    public void clickNext(View view) {

        imageAnInt += 1;

        if (imageAnInt >= 4) {
            imageAnInt = 0;
        }

        Picasso.with(this)
                .load(imageStrings[imageAnInt])
                .resize(200, 200)
                .into(imageView);


    }   // clickNext

    public void clickBackImage(View view) {

        imageAnInt -= 1;

        if (imageAnInt <= 0) {
            imageAnInt = 4;
        }

        Picasso.with(this)
                .load(imageStrings[imageAnInt])
                .resize(200, 200)
                .into(imageView);

    }

    private void setupImage() {

        imageStrings = new String[5];
        for (int i = 0; i < 5; i++) {
            imageStrings[i] = resultStrings[2 + i];
        }   // for

    }   // setupImage

    private void showView() {

        nameTextView.setText(resultStrings[1]);
        descripTextView.setText(resultStrings[7]);
        priceTextView.setText(resultStrings[8]);

        Picasso.with(this)
                .load(imageStrings[0])
                .resize(200, 200)
                .into(imageView);

    }   // showView

    private void getValueFromIntent() {

        String strID = getIntent().getStringExtra("id");

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM serviceTABLE WHERE _id = " + "'" + strID + "'", null);
        cursor.moveToFirst();

        resultStrings = new String[cursor.getColumnCount()];
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            resultStrings[i] = cursor.getString(i);
        }   // for
        cursor.close();

    }   // getValue

    private void bindWidget() {
        nameTextView = (TextView) findViewById(R.id.textView10);
        descripTextView = (TextView) findViewById(R.id.textView12);
        priceTextView = (TextView) findViewById(R.id.textView14);
        imageView = (ImageView) findViewById(R.id.imageView3);
    }

}   // Main Class
