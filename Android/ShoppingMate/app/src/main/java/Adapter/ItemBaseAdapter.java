package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.shoppingmate.R;

import java.util.ArrayList;

import DTO.ItemDTO;

/**
 * Created by User on 3/24/2016.
 */
public class ItemBaseAdapter extends BaseAdapter {
    private static ArrayList<ItemDTO> searchResults;
    private LayoutInflater mInflater;

    public ItemBaseAdapter(Context context, ArrayList<ItemDTO> results){
        searchResults = results;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return searchResults.size();
    }

    @Override
    public Object getItem(int position) {
        return searchResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.txtItemName = (TextView) convertView.findViewById(R.id.txtListItemName);
            holder.txtItemDescription = (TextView) convertView.findViewById(R.id.txtListItemDescription);
            holder.txtItemPrice = (TextView) convertView.findViewById(R.id.txtListItemPrice);
            holder.txtItemQuantity = (TextView) convertView.findViewById(R.id.txtListItemQuantity);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.txtItemName.setText(searchResults.get(position).getName());
        holder.txtItemDescription.setText(searchResults.get(position).getDescription());
        holder.txtItemPrice.setText(String.valueOf(searchResults.get(position).getPrice()));
        holder.txtItemQuantity.setText(String.valueOf(searchResults.get(position).getQuantity()));
        return convertView;
    }

    private static class ViewHolder {
        TextView txtItemName;
        TextView txtItemDescription;
        TextView txtItemPrice;
        TextView txtItemQuantity;
    }
}
