package app.calcounterapplication.com.moviedirectory.Data;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.calcounterapplication.com.moviedirectory.Activities.MovieDetailActivity;
import app.calcounterapplication.com.moviedirectory.Model.Movie;
import app.calcounterapplication.com.moviedirectory.R;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movieList;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.context = context;
        movieList = movies;
    }

    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Movie movie = movieList.get(position);
        String posterLink = movie.getPoster();

        holder.title.setText(movie.getTitle());
        holder.type.setText(movie.getMovieType());


        Picasso.get().load(posterLink).placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.poster);

        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView poster;
        TextView year;
        TextView type;

        public ViewHolder(View itemView, final Context ctx) {
            super(itemView);
            context = ctx;

            title = (TextView) itemView.findViewById(R.id.movieTitleID);
            poster = (ImageView) itemView.findViewById(R.id.movieImageId);
            year = (TextView) itemView.findViewById(R.id.movieReleaseId);
            type = (TextView) itemView.findViewById(R.id.movieCatID);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Movie movie = new Movie();
                    Intent intent = new Intent(context, MovieDetailActivity.class);
                    intent.putExtra("movie", movie);
                    ctx.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
