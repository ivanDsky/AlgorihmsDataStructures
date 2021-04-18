package homework.hw11;

import java.util.List;

public class FileChooseException extends Exception{
    static final int MIN_AMOUNT_OF_FIlES = 10;
    static final int MIN_FILE_SIZE = 150 * 1024;

    protected String fileName;

    FileChooseException(){}

    FileChooseException(String fileName){
        this.fileName = fileName;
    }


    static class NotEnoughFiles extends FileChooseException{

        @Override
        public String getMessage() {
            return "Not enough selected files, min: " + MIN_AMOUNT_OF_FIlES;
        }
    }

    static class SmallFileSize extends FileChooseException{

        SmallFileSize(String fileName) {
            super(fileName);
        }

        @Override
        public String getMessage() {
            return String.format("Size of %s should be >= %d KB",fileName, MIN_FILE_SIZE / 1024);
        }
    }

    static class NotTextFile extends FileChooseException{
        NotTextFile(String fileName) {
            super(fileName);
        }

        @Override
        public String getMessage() {
            return String.format("Extension of %s is forbidden",fileName);
        }
    }

}