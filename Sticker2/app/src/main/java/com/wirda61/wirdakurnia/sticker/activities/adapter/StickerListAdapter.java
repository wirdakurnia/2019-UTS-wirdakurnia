package com.wirda61.wirdakurnia.sticker.activities.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wirda61.wirdakurnia.sticker.R;
import com.wirda61.wirdakurnia.sticker.activities.Settings;
import com.wirda61.wirdakurnia.sticker.activities.model.Sticker;

import java.util.ArrayList;

public class StickerListAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<Sticker> stikersList;
    private Settings settings;

    public StickerListAdapter(Context context, int layout, ArrayList<Sticker> stikersList) {
        this.context = context;
        this.layout = layout;
        this.stikersList = stikersList;
        this.settings = new Settings(context);
    }

    @Override
    public int getCount() {
        return stikersList.size();
    }

    @Override
    public Object getItem(int position) {
        return stikersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = row.findViewById(R.id.txtName);
            holder.txtPrice = row.findViewById(R.id.txtPrice);
            holder.imageView = row.findViewById(R.id.imgSticker);

            float textSize = settings.getTextSize();
            holder.txtName.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            holder.txtPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Sticker sticker = stikersList.get(position);

        holder.txtName.setText(sticker.getName());
        holder.txtPrice.setText("$ "+sticker.getPrice());

        byte[] stickerImage = sticker.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(stickerImage, 0, stickerImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
