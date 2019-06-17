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

public class DailyArticleAdapter extends RecyclerView.Adapter<DailyArticleAdapter.ArticleViewHolder>{
	
	private Context context;
	private ArrayList<Article> articles;
	
	public DailyArticleAdapter(Context context, ArrayList<Article> articles) {
		this.context = context;
		this.articles = articles;
	}
	
	@NonNull
	@Override
	public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new ArticleViewHolder(LayoutInflater.from(context)
		.inflate(R.layout.daily_read_item, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
		
		Article article = articles.get(i);
		
		articleViewHolder.tvTitle.setText(article.getTitle());
		articleViewHolder.tvAuthor.setText(article.getAuthor());
		articleViewHolder.tvDuration.setText(article.getDuration());
		
		if (article.isPremium()) {
			articleViewHolder.imgPremiumStar.setVisibility(View.VISIBLE);
		} else {
			articleViewHolder.imgPremiumStar.setVisibility(View.GONE);
		}
		
		
		Glide.with(context)
			.load(article.getArticleImage())
			.into(articleViewHolder.imgArticleImage);
		
		Glide.with(context)
			.load(article.getAuthorProfilePic())
			.into(articleViewHolder.imgAuthorProfilePic);
		
		
	}
	
	@Override
	public int getItemCount() {
		
		if (articles != null) {
			return articles.size();
		}
		return 0;
	}
	
	class ArticleViewHolder extends RecyclerView.ViewHolder {
		
		TextView tvTitle;
		TextView tvAuthor;
		TextView tvDuration;
		
		ImageView imgPremiumStar;
		
		ImageView imgArticleImage;
		ImageView imgAuthorProfilePic;
		
		
		ArticleViewHolder(@NonNull View itemView) {
			super(itemView);
		
			tvTitle = itemView.findViewById(R.id.tvTitle);
			tvAuthor = itemView.findViewById(R.id.tvAuthor);
			tvDuration = itemView.findViewById(R.id.tvDuration);
			
			imgPremiumStar = itemView.findViewById(R.id.imgPremium);
			
			imgArticleImage = itemView.findViewById(R.id.imgArticleThumbnail);
			imgAuthorProfilePic = itemView.findViewById(R.id.imgAuthorProfilePic);
		
		}
	}
}
