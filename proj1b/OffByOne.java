public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        int abs = Math.abs(x-y);
        if(abs <= 1){
            return true;
        }else{
            return false;
        }
    }
}