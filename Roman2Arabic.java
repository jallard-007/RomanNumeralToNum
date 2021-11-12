public class Roman2Arabic {
    public static int convertSingleNumeral(char RomanNumeral){
        if (RomanNumeral == 'I'){
            return 1;
        }
        if (RomanNumeral == 'V'){
            return 5;
        }
        if (RomanNumeral == 'X'){
            return 10;
        }
        if (RomanNumeral == 'L'){
            return 50;
        }
        if (RomanNumeral == 'C'){
            return 100;
        }
        if (RomanNumeral == 'D'){
            return 500;
        }
        if (RomanNumeral == 'M'){
            return 1000;
        }
        throw new RomanNumeralException("Not a roman numeral");
    }
    public static int convertWholeNumeral(String RomanNumeral){
        int convertedNum = 0;
        int repeatCount = 0;
        int currValue;
        int previousValue = 0;
        char previousChar = ' ';
        ArrayStack<Character> RomanNumeralStack = new ArrayStack<>(RomanNumeral.length());

        for (int i = 0; i < RomanNumeral.length(); i++){
            char currChar = RomanNumeral.charAt(i);
            RomanNumeralStack.push(currChar);
            if (previousChar != currChar){
                previousChar = currChar;
                repeatCount = 0;
                continue;
            }
            if (currChar == 'I' || currChar == 'X' ||  currChar == 'C' || currChar == 'M'){
                repeatCount++;
                if (repeatCount < 3){
                    continue;
                }
            }
            throw new RomanNumeralException("Not a Roman Numeral");
        }

        for (int i = 0; i < RomanNumeral.length(); i++){
            currValue = convertSingleNumeral(RomanNumeralStack.pop());
            if (currValue < previousValue){
                convertedNum -= currValue;
                continue;
            }
            else{
                convertedNum += currValue;
            }
            previousValue = currValue;
        }
        return convertedNum;
    }
}
