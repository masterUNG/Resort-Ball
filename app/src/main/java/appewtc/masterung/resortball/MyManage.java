package appewtc.masterung.resortball;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 3/31/16 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Name = "Name";
    public static final String column_IDcard = "IDcard";

    public static final String service_table = "serviceTABLE";
    public static final String column_Category = "Category";
    public static final String column_Image1 = "Image1";
    public static final String column_Image2 = "Image2";
    public static final String column_Image3 = "Image3";
    public static final String column_Image4 = "Image4";
    public static final String column_Image5 = "Image5";
    public static final String column_Description = "Description";
    public static final String column_Price = "Price";
    public static final String column_Item = "Item";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   // Constructor

    public long addService(String strCategory,
                           String strImage1,
                           String strImage2,
                           String strImage3,
                           String strImage4,
                           String strImage5,
                           String strDescription,
                           String strPrice,
                           String strItem) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Category, strCategory);
        contentValues.put(column_Image1, strImage1);
        contentValues.put(column_Image2, strImage2);
        contentValues.put(column_Image3, strImage3);
        contentValues.put(column_Image4, strImage4);
        contentValues.put(column_Image5, strImage5);
        contentValues.put(column_Description, strDescription);
        contentValues.put(column_Price, strPrice);
        contentValues.put(column_Item, strItem);

        return sqLiteDatabase.insert(service_table, null, contentValues);
    }


    public long addUser(String strUser,
                        String strPassword,
                        String strName,
                        String strIDcard) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_User, strUser);
        contentValues.put(column_Password, strPassword);
        contentValues.put(column_Name, strName);
        contentValues.put(column_IDcard, strIDcard);

        return sqLiteDatabase.insert(user_table, null, contentValues);
    }


}   // Main Class
