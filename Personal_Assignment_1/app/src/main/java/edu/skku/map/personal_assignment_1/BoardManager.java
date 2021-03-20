package edu.skku.map.personal_assignment_1;

import android.util.Log;

public class BoardManager {
    private Tile[] tiles;
    private int mode;
    private OnChangeBoard onChangeBoard;

    BoardManager(Tile[] tiles, int mode, OnChangeBoard onChangeBoard) {
        this.tiles = tiles;
        this.mode = mode;
        this.onChangeBoard = onChangeBoard;
    }

    public void changeTile(int tileIndex) {
        int blankTileIndex = getBlankTileIndex();

        if (isMovablePosition(tileIndex, blankTileIndex)) {
            changeTiles(tileIndex, blankTileIndex);
            onChangeBoard.OnSuccessChangeBoard(tiles);

            if (isFinish()) {
                onChangeBoard.OnFinish();
            }
        } else {
            onChangeBoard.OnFailChangeBoard();
        }
    }

    public void shuffle() {
        for (int i = 0; i < tiles.length; i++) {
            Tile tempTile = tiles[i];

            double dValue = Math.random();
            int iValue = (int)(dValue * mode * mode);

            tiles[i] = tiles[iValue];
            tiles[iValue] = tempTile;
        }
        onChangeBoard.OnSuccessChangeBoard(tiles);
    }

    private void changeTiles(int index1, int index2) {
        Tile temp = tiles[index1];

        tiles[index1] = tiles[index2];
        tiles[index2] = temp;
    }

    private int getBlankTileIndex() {
        int blankTileIndex = -1;

        for (int i = 0; i < tiles.length; i++) {
            Tile iTile = tiles[i];

            if (iTile.position == mode * mode - 1) {
                blankTileIndex = i;
            }
        }

        return blankTileIndex;
    }

    private boolean isMovablePosition(int position, int blankPosition) {
        return
            position == blankPosition + mode
            || position == blankPosition - mode
            || (
                (position / mode == blankPosition / mode)
                && (position == blankPosition + 1 || position == blankPosition - 1)
            );
    }

    private boolean isFinish() {
        boolean isAllRightPosition = true;

        for (int i = 0; i < tiles.length; i ++) {
            if (tiles[i].position != i) {
                isAllRightPosition = false;
                break;
            }
        }

        return isAllRightPosition;
    }
}
