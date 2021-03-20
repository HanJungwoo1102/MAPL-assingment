package edu.skku.map.personal_assignment_1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GridAdapter extends BaseAdapter {
    Tile[] tiles;
    OnClickGridItem onClickGridItem;

    GridAdapter(Tile[] tiles, OnClickGridItem onClickGridItem) {
        this.tiles = tiles;
        this.onClickGridItem = onClickGridItem;
    }


    @Override
    public int getCount() {
        return tiles.length;
    }

    @Override
    public Object getItem(int position) {
        return tiles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        Tile tile = tiles[position];

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        LinearLayout layout = convertView.findViewById(R.id.grid_item);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGridItem.onClick(position);
            }
        });

        if (tile != null) {
            ImageView imageView = convertView.findViewById(R.id.grid_item_image_view);

            imageView.setImageBitmap(tile.image);
        }

        return convertView;
    }
}
