package com.catalyst.birdwrangler.utilities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> implements SpinnerAdapter{

	View view = null;
	Context context;
	
	public CustomAdapter(Context context, int textViewResId, String[] strings) {
        super(context, textViewResId, strings);
        this.context = context;
    }

//    public CustomAdapter(Context context, int textViewResourceId, List<String> courseNames) {
//        super(context, textViewResourceId, courseNames);
//        this.context = context;
//	}
	
	 @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        if (convertView == null)
	        {
	          LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	          convertView = vi.inflate(android.R.layout.simple_spinner_item, null);
	        }
	        
	        View view = super.getView(position, convertView, parent);
	        if (position == getCount()) {
	        	((TextView)view.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //Last item is the hint to be displayed
	        }
	        view.setPadding(0, 20, 0, 0);

	        return view;	
	    }     
	    
	    @Override
	    public View getDropDownView(int position, View convertView, ViewGroup parent){
			if (convertView == null){
			    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    convertView = vi.inflate(android.R.layout.simple_spinner_dropdown_item, null);
			}
			
			TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
			textView.setHeight(80);
			textView.setText(getItem(position));
			
			return convertView;
	    }
	
	/**
     * Make the array count one less than the actual to avoid displaying the last item.
     */
    @Override
    public int getCount() {
        return super.getCount()-1;
    }	
	
	/**
     * Sets an error to the textView associated the spinner.
     * Changes the color of the hint text to red for emphasis.
     * @param convertView
     * @param errorMessage
     */
    public void setError(View convertView, String errorMessage){
    	TextView textView =  ((TextView)convertView.findViewById(android.R.id.text1));
    	textView.setError(errorMessage);
    	textView.setTextColor(Color.RED);
    }
}
