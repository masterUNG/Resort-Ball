package appewtc.masterung.resortball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 4/6/16 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconStrings, priceStrings, nameStrings;

    public MyAdapter(Context context,
                     String[] iconStrings,
                     String[] priceStrings,
                     String[] nameStrings) {

        this.context = context;
        this.iconStrings = iconStrings;
        this.priceStrings = priceStrings;
        this.nameStrings = nameStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView2);
        Picasso.with(context)
                .load(iconStrings[i])
                .resize(120, 120)
                .into(iconImageView);

        TextView priceTextView = (TextView) view1.findViewById(R.id.textView8);
        priceTextView.setText(priceStrings[i]);

        TextView nameTextView = (TextView) view1.findViewById(R.id.textView9);
        nameTextView.setText(nameStrings[i]);

        return view1;
    }
}   // Main Class
