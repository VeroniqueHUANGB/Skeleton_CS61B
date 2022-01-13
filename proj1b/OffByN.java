public class OffByN implements CharacterComparator{
    public int N;
    public OffByN(int N){
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int abs = Math.abs(x-y);
        if (abs <= N){
            return true;
        }else{
            return false;
        }

    }
}
