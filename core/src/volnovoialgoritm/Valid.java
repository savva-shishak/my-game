package volnovoialgoritm;

public interface Valid {
    boolean isValid(int x, int y);

    Valid free = new Valid() {
        @Override
        public boolean isValid(int x, int y) {
            return true;
        }
    };
}
