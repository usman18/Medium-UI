package com.uk.mediumui.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class NetworkFeedPagerAdapter extends FragmentStatePagerAdapter {
	
	private ArrayList<Fragment> fragments;
	
	public NetworkFeedPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}
	
	@Override
	public Fragment getItem(int i) {
		if (fragments != null) {
			return fragments.get(i);
		}
		return null;
	}
	
	@Override
	public int getCount() {
		if (fragments != null) {
			return fragments.size();
		}
		return 0;
	}
}
