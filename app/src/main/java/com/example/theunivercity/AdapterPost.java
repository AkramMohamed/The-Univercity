
package com.example.theunivercity;

        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;

        import java.util.Calendar;
        import java.util.Date;
        import java.util.List;


public class AdapterPost  extends ArrayAdapter<Post> {

    Activity activity;
    int resource;
    List<Post> list;





    public AdapterPost(Activity activity, int resource, List<Post> list) {
        super(activity, resource,list);
        this.activity = activity;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View view = layoutInflater.inflate(resource,null);


        TextView date =  view.findViewById(R.id.datePost);
        TextView theme = view.findViewById(R.id.themePost);
        TextView title = view.findViewById(R.id.titlePost);
        TextView text = view.findViewById(R.id.textPost);
        final Button valid = view.findViewById(R.id.validPost);
        final Button comment = view.findViewById(R.id.commentPost);
Calendar c = Calendar.getInstance();

       // date.setText(list.get(position).getDateP());
        date.setText(String.valueOf(list.get(position).getDateP()));
        theme.setText(String.valueOf(list.get(position).getThemeP()));
        title.setText(String.valueOf(list.get(position).getTitleP()));
        text.setText(list.get(position).getTextP());

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid.setText("Valid (1)");
            }
        });

        return view;
    }
}
