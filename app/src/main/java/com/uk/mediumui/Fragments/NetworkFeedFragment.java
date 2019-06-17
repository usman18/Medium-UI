package com.uk.mediumui.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uk.mediumui.Models.Article;
import com.uk.mediumui.R;

public class NetworkFeedFragment extends Fragment {
	private static final String TAG = "NetworkFeedFragment";
	
	private ImageView imgArticleImage;
	
	private TextView tvAuthor;
	private TextView tvTitle;
	private TextView tvDuration;
	private TextView tvTimestamp;
	
	private Article article;
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.network_feed_item, container, false);
	}
	
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		Log.d(TAG, "onViewCreated: ");
		initialize(view);
		setDataToViews();
		
	}
	
	private void initialize(View view) {
		
		imgArticleImage = view.findViewById(R.id.imgArticleThumbnail);
		
		tvTitle = view.findViewById(R.id.tvTitle);
		tvAuthor = view.findViewById(R.id.tvAuthor);
		tvTimestamp = view.findViewById(R.id.tvTimeStamp);
		tvDuration = view.findViewById(R.id.tvDuration);
		
	}
	
	private void setDataToViews() {
		
		Bundle bundle = getArguments();
		if (bundle != null) {
			article = (Article) bundle.getSerializable("ARTICLE");
			Log.d(TAG, "setDataToViews: bundle not null");
		}
		
		if (article != null) {
			Log.d(TAG, "setDataToViews: Article not null");
			tvTitle.setText(article.getTitle());
			tvAuthor.setText(article.getAuthor());
			//tvTimestamp.setText(article.ge);
			tvDuration.setText(article.getDuration());
			
			if (getContext() != null) {
				if (!isDetached()) {
					
					Glide.with(getContext())
						.load(article.getArticleImage())
						.into(imgArticleImage);
					
				}
			}
			
			
		}
		
	}
}
