package com.uk.mediumui.Activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.uk.mediumui.Adapters.DailyArticleAdapter;
import com.uk.mediumui.Adapters.NetworkFeedPagerAdapter;
import com.uk.mediumui.Fragments.NetworkFeedFragment;
import com.uk.mediumui.Models.Article;
import com.uk.mediumui.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	
	
	public static final String[] articleImages = {"https://cdn-images-1.medium.com/max/800/0*uxd3eEv1EyIUdvNi.png","https://cdn-images-1.medium.com/fit/t/800/240/0*d4dwuqe3UgDnmW06","https://cdn-images-1.medium.com/max/1200/1*Px8Aru4UCSh-JZTSbONViw.png", "https://cdn-images-1.medium.com/focal/1600/480/52/53/1*bpuuMHXCzmyyFcRrSliuOg.jpeg"};
	public static final String[] authorImages = {"https://www.freecodecamp.org/news/content/images/size/w100/2019/06/avatar.jpg", "https://cdn-images-1.medium.com/fit/c/50/50/2*G9ReroQ6OmXRWJ9JMJ1Kxg.jpeg","https://cdn-images-1.medium.com/fit/c/50/50/2*0_Gqlwqdkk6L5BoTFzye3Q.jpeg", "https://cdn-images-1.medium.com/fit/c/100/100/1*zDKGzyimQ2BBMt_IACFjOg.jpeg"};
	
	private DrawerLayout drawerLayout;
	private NavigationView navigationView;
	
	private RecyclerView rvDailyArticles;
	private DailyArticleAdapter dailyArticleAdapter;
	private ArrayList<Article> dailyReadArticles;
	
	private ViewPager networkFeedViewpager;
	private ArrayList<Article> networkFeedArtices;
	private NetworkFeedPagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeAsUpIndicator(R.drawable.ic_hamburger);
		
		toolbar.setTitle("Home");
		
		drawerLayout = findViewById(R.id.drawer);
		navigationView = findViewById(R.id.navigationView);
		networkFeedViewpager = findViewById(R.id.networkFeedViewpager);
		
		rvDailyArticles = findViewById(R.id.rvDailyReadArticles);
		rvDailyArticles.setLayoutManager(new LinearLayoutManager(MainActivity.this));
		
		dailyReadArticles = new ArrayList<>();
		networkFeedArtices = new ArrayList<>();
		
		populateDailyFeedArticles();
		
		dailyArticleAdapter = new DailyArticleAdapter(MainActivity.this, dailyReadArticles);
		rvDailyArticles.setAdapter(dailyArticleAdapter);
		
		populateNetworkFeed();
		
	}
	
	
	private void populateDailyFeedArticles() {
		
		if (dailyReadArticles == null) {
			dailyReadArticles = new ArrayList<>();
		}
		
		dailyReadArticles.add(new Article(articleImages[0], authorImages[0], "Florin Pop", "How to create a Countdown component using React & MomentJS", "4 min read", true));
		dailyReadArticles.add(new Article(articleImages[1], authorImages[1], "Austin Tindle", "The Plight of a Junior Software Developer", "5 min read", true));
		dailyReadArticles.add(new Article(articleImages[2], authorImages[2], "Paolo Rotolo", "Exploring new Coroutines and Lifecycle Architectural Components integration on Android", "7 min read", false));
		dailyReadArticles.add(new Article(articleImages[3], authorImages[3], "Robert Roy Britt", "Coffee, Even a Lot, Linked to Longer Life", "6 min read", true));
		
	}
	
	
	private void populateNetworkFeed() {
		//Todo : Your businesss logic goes here. Below is just some demonstration code
		networkFeedArtices = dailyReadArticles;
		
		ArrayList<Fragment> feedFragments = new ArrayList<>();
		
		for (Article article : networkFeedArtices) {
			
			NetworkFeedFragment feedFragment = new NetworkFeedFragment();
			Bundle bundle = new Bundle();
			bundle.putSerializable("ARTICLE", article);
			feedFragment.setArguments(bundle);
			
			feedFragments.add(feedFragment);
			
		}
		
		
		pagerAdapter = new NetworkFeedPagerAdapter(getSupportFragmentManager(), feedFragments);
		networkFeedViewpager.setAdapter(pagerAdapter);
		
	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_screen_options, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				drawerLayout.openDrawer(Gravity.START);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
