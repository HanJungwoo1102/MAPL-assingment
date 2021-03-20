package edu.skku.map.personal_assignment_1;

import android.graphics.Bitmap;

public class Tile {
    Bitmap image;
    int position;

    Tile(Bitmap image, int position) {
        this.image = image;
        this.position = position;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getPosition() {
        return position;
    }
}
