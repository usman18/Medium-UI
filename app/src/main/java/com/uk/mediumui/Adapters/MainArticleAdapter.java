package com.uk.mediumui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uk.mediumui.Models.Article;
import com.uk.mediumui.R;

import java.util.ArrayList;

public class MainArticleAdapter extends RecyclerView.Adapter<MainArticleAdapter.MainArticleViewHolder>{
	
	private Context context;
	private ArrayList<Article> articles;
	
	public MainArticleAdapter(Context context, ArrayList<Article> articles) {
		this.context = context;
		this.articles = articles;
	}
	
	@NonNull
	@Override
	public MainArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new MainArticleViewHolder(LayoutInflater.from(context)
		.inflate(R.layout.main_feed_item, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull MainArticleViewHolder mainArticleViewHolder, int i) {
		
		Article article = articles.get(i);
		
		mainArticleViewHolder.tvTopic.setText(article.getTopic());
		
		mainArticleViewHolder.tvTitle.setText(article.getTitle());
		mainArticleViewHolder.tvAuthor.setText(article.getAuthor());
		
		mainArticleViewHolder.tvDuration.setText(article.getDuration());
		mainArticleViewHolder.tvTimeStamp.setText(article.getTimestamp());
		
		if (article.isPremium()) {
			mainArticleViewHolder.tvPremium.setVisibility(View.VISIBLE);
		} else  {
			mainArticleViewHolder.tvPremium.setVisibility(View.GONE);
		}
		
		Glide.with(context)
			.load(article.getArticleImage())
			.into(mainArticleViewHolder.imgArticlePic);
		
		Glide.with(context)
			.load(article.getAuthorProfilePic())
			.into(mainArticleViewHolder.imgAuthorPic);
		
		
	}
	
	@Override
	public int getItemCount() {
		if (articles != null) {
			return articles.size();
		}
		return 0;
	}
	
	class MainArticleViewHolder extends RecyclerView.ViewHolder {
		TextView tvTitle;
		TextView tvAuthor;
		TextView tvDuration;
		TextView tvTimeStamp;
		TextView tvPremium;
		TextView tvTopic;
		
		ImageView imgArticlePic;
		ImageView imgAuthorPic;
		
		
		MainArticleViewHolder(@NonNull View itemView) {
			super(itemView);
			
			tvTopic = itemView.findViewById(R.id.tvTopic);
			tvTitle = itemView.findViewById(R.id.tvTitle);
			tvAuthor = itemView.findViewById(R.id.tvAuthor);
			tvDuration = itemView.findViewById(R.id.tvDuration);
			tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp);
			
			imgArticlePic = itemView.findViewById(R.id.imgArticleThumbnail);
			imgAuthorPic = itemView.findViewById(R.id.imgAuthorProfilePic);
		
			tvPremium = itemView.findViewById(R.id.imgPremium);
			
		}
	}
}
