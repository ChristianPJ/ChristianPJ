package com.inftel.museoinftel.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapterFragment extends FragmentPagerAdapter {

	public PageAdapterFragment(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case 0:
			   return new HomeFragment();
		case 1:
			   return new GalleryFragment();
		case 2:
			  return new ContactFragment();
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
