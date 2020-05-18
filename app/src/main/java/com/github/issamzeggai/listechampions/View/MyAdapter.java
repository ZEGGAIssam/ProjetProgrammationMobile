package com.github.issamzeggai.listechampions.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.github.issamzeggai.listechampions.Modele.Champion;
import com.github.issamzeggai.listechampions.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Champion> values;
    private Context context;
    private Champion currentChampion;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        private Context context;
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ImageView imageURL;
        private Champion currentChampion;

        public void setContext(Context context) {
            this.context = context;
        }

        public ViewHolder(View v) {
            super(v);
            layout = v;
            context = v.getContext();
            v.setOnClickListener(this);
            //txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            imageURL = v.findViewById(R.id.icon);

            // imageURL = v.findViewById(R.id.icon);
        }

        public void setCurrentChampion(Champion currentChampion) {
            this.currentChampion = currentChampion;
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(context, currentChampion.getName(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (context,InfoStats.class);
            intent.putExtra("champion", currentChampion);
            context.startActivity(intent);
        }
    }

    public void add(int position, Champion item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Champion> values, Context context) {
        this.values = values;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        currentChampion = values.get(position);
        holder.txtFooter.setText(currentChampion.getName());
        holder.setCurrentChampion(currentChampion);
        holder.setContext(context);
        /*holder.txtFooter.setText("Title: " + currentChampion.getTitle());*/
        Picasso.get()
                .load(currentChampion.getIcon())
                .into(holder.imageURL);

        // Return the size of your dataset (invoked by the layout manager)
    }
    @Override
    public int getItemCount() {return values.size();
    }
}
