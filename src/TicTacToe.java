import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by David on 22.01.2018.
 */
public class TicTacToe {
    String[] positions;
    RandomAccessFile saveGame;

    TicTacToe(String filePath) throws IOException {
        positions = new String[9];
        saveGame = new RandomAccessFile(filePath, "rw");
        readPositionsFromFile();
    }

    public void updatePositions(String[] newPositions){
        positions=newPositions;
    }

    private void readPositionsFromFile() throws IOException {
        String line;
        int i=0;
        while((line = saveGame.readLine()) != null) {
            positions[i]=line;
        }
    }

    public void writePositionsIntoFile() throws IOException {
        saveGame.setLength(0);
        for (int i=0; i<9; i++){
            if(i!=8) saveGame.writeChars(positions[i]+"\n");
            else saveGame.writeChars(positions[i]);
        }
    }
}
