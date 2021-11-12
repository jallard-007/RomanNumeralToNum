public class RomanNumeral implements Comparable<RomanNumeral> {
    String numeral;

    public RomanNumeral(String str){
        numeral = str;
    }
    public String toString(){
        return numeral;
    }
    public int compareTo(RomanNumeral otherRomNum){
        int thisNum = Roman2Arabic.convertWholeNumeral(numeral);
        int otherNum = Roman2Arabic.convertWholeNumeral(otherRomNum.toString());

        if (thisNum > otherNum){
            return 1;
        }
        if (thisNum == otherNum){
            return 0;
        }
        return -1;
    }
}
