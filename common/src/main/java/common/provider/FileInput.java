package common.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput implements Provider<Character> {

    private FileInputStream fs;
    private int data;

    public FileInput(String filename) throws FileNotFoundException {
        this.fs = new FileInputStream(new File(filename));
    }

    @Override
    public void next() {
        try {
            this.data = fs.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Character get() {
        return (char) this.data;
    }

    @Override
    public boolean hasNext() {
        try {
            if (data != -1) {
                return true;
            }

            this.fs.close();
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
