package edu.skku.map.personal_assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    BoardManager boardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);
        final Button mode3Button = (Button)findViewById(R.id.buttonMode3);
        final Button mode4Button = (Button)findViewById(R.id.buttonMode4);
        final Button shuffleButton = (Button)findViewById(R.id.buttonShuffle);

        mode3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeGame(3);
            }
        });

        mode4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeGame(4);
            }
        });

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffle();
            }
        });
    }

    private void initializeGame(int mode) {
        gridView.setNumColumns(mode);

        Bitmap imageBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img_uh_eebbda);

        int width = gridView.getWidth();
        Bitmap resizedImageBitmap = Bitmap.createScaledBitmap(imageBitmap, width, width, true);

        Bitmap[] dividedImageBitmaps = divideBitmap(resizedImageBitmap, mode);

        Tile[] tiles = createTiles(dividedImageBitmaps);

        boardManager = new BoardManager(tiles, mode, new OnChangeBoard() {

            @Override
            public void OnSuccessChangeBoard(Tile[] tiles) {
                drawBoard(tiles);
            }

            @Override
            public void OnFailChangeBoard() {

            }

            @Override
            public void OnFinish() {
                Toast.makeText(MainActivity.this, "FINISH!", Toast.LENGTH_LONG).show();
            }
        });

        drawBoard(tiles);
    }

    private void shuffle() {
        boardManager.shuffle();
    }

    private Bitmap[] divideBitmap(Bitmap srcBitmap, int mode) {
        Bitmap[] bitmaps = new Bitmap[mode * mode];

        int targetWidth = srcBitmap.getWidth() / mode;
        int targetHeight = srcBitmap.getHeight() / mode;

        for (int row = 0; row < mode; row++) {
            for (int col = 0; col < mode; col++) {
                bitmaps[row * mode + col] = Bitmap.createBitmap(srcBitmap, col * targetHeight, row * targetWidth, targetWidth, targetHeight);
            }
        }

        return bitmaps;
    }

    private Tile[] createTiles(Bitmap[] bitmaps) {
        Tile[] tiles= new Tile[bitmaps.length];
        for (int i = 0; i < bitmaps.length; i++) {
            tiles[i] = new Tile(bitmaps[i], i);
        }

        tiles[bitmaps.length - 1].image.eraseColor(0x999999);

        return tiles;
    }

    private void drawBoard(Tile[] tiles) {
        GridAdapter gridAdapter = new GridAdapter(tiles, new OnClickGridItem() {
            @Override
            public void onClick(int gridIndex) {
                boardManager.changeTile(gridIndex);
            }
        });

        gridView.setAdapter(gridAdapter);
    }

}