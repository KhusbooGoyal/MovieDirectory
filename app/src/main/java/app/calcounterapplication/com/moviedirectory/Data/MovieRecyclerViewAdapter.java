package app.calcounterapplication.com.moviedirectory.Data;

import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.calcounterapplication.com.moviedirectory.Model.Movie;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movieList;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.context = context;
        movieList = movies;
    }

    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MovieRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
