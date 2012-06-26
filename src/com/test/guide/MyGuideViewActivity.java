package com.test.guide;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

public class MyGuideViewActivity extends Activity {
	private static final int more = Menu.FIRST;
	private static final int tell = Menu.FIRST + 1;
	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	private ViewGroup main;
	private LayoutInflater inflater;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置无标题窗口
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		inflater = getLayoutInflater();
		pageViews = new ArrayList<View>();
		pageViews.add(inflater.inflate(R.layout.item05, null));
		pageViews.add(inflater.inflate(R.layout.item06, null));
		pageViews.add(inflater.inflate(R.layout.item01, null));
		pageViews.add(inflater.inflate(R.layout.item02, null));
		pageViews.add(inflater.inflate(R.layout.item03, null));
		pageViews.add(inflater.inflate(R.layout.item04, null));
		main = (ViewGroup) inflater.inflate(R.layout.main, null);
		viewPager = (ViewPager) main.findViewById(R.id.guidePages);
		setContentView(main);
		viewPager.setAdapter(new GuidePageAdapter());
		viewPager.setCurrentItem(1);
		// viewPager.setOnPageChangeListener(new GuidePageChangeListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, more, 0, getString(R.string.more_action)).setIcon(
				this.getResources().getDrawable(R.drawable.more));
		menu.add(0, tell, 1, getString(R.string.tell_action)).setIcon(
				this.getResources().getDrawable(R.drawable.tell));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			for (int i = 0; i < 101; i++)
				pageViews.add(inflater.inflate(R.layout.item05, null));
			viewPager.getAdapter().notifyDataSetChanged();
			break;
		case 2:
			Toast.makeText(MyGuideViewActivity.this,
					"" + this.pageViews.size(), Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// 指引页面数据适配器
	class GuidePageAdapter extends PagerAdapter {
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(pageViews.get(arg1));
			return pageViews.get(arg1);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);
		}

		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			return POSITION_NONE;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			
		}

		@Override
		public void finishUpdate(View arg0) {

		}
	}

	// 指引页面更改事件监听器
	// class GuidePageChangeListener implements OnPageChangeListener {
	//
	// @Override
	// public void onPageScrollStateChanged(int arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onPageScrolled(int arg0, float arg1, int arg2) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onPageSelected(int arg0) {
	// for (int i = 0; i < imageViews.length; i++) {
	// imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
	//
	// if (arg0 != i) {
	// imageViews[i].setBackgroundResource(R.drawable.page_indicator);
	// }
	// }
	// }
	// }
}