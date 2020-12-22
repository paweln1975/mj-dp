package pl.paweln.dp.behavioral.nullobject.exercise;

public class NullLog implements Log {

    private int recordCount;

    @Override
    public int getRecordLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getRecordCount() {
        return recordCount;
    }

    @Override
    public void logInfo(String message) {
        ++recordCount;
    }

}
