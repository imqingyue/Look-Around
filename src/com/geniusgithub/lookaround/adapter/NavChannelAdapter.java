package com.geniusgithub.lookaround.adapter;

import java.util.ArrayList;
import java.util.List;

import com.geniusgithub.lookaround.R;
import com.geniusgithub.lookaround.model.BaseType;
import com.geniusgithub.lookaround.util.CommonLog;
import com.geniusgithub.lookaround.util.LogFactory;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NavChannelAdapter extends BaseAdapter{

	private static final CommonLog log = LogFactory.createLog();
	
	private List<BaseType.ListItem> data = new ArrayList<BaseType.ListItem>();
	
	private Context mContext;
	
	public NavChannelAdapter(Context context, List<BaseType.ListItem> data)
	{
		mContext = context;
		this.data = data;
	}
	
	public void refreshData(List<BaseType.ListItem> data)
	{
		this.data = data;
		notifyDataSetChanged();
		
	}
	
	@Override
	public int getCount() {

		return data.size();
	}

	@Override
	public Object getItem(int pos) {

		return data.get(pos);
	}

	@Override
	public long getItemId(int arg0) {
	
		return 0;
	}

	@Override
	public View getView(int pos, View view, ViewGroup parent) {
		
		ViewHolder holder = null; 


		if (view == null)
		{
			view = LayoutInflater.from(mContext).inflate(R.layout.nav_listitem_layout, null);
			holder = new ViewHolder();
			holder.tvNavName = (TextView) view.findViewById(R.id.tvNavName);
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}

		holder.tvNavName.setText(data.get(pos).mTitle);

		return view;
	}
	
	
    static class ViewHolder { 
        public TextView tvNavName;
    } 

}
