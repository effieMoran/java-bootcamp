public class RomanNum {

    public String romanNum;

    // Constructor
    public RomanNum(String romanNum) {
        this.setRomanNum(romanNum.toUpperCase());
    }

    // Getters & Setters
    public void setRomanNum(String romanNum) {
        this.romanNum = romanNum;
    }

    public String getRomanNum() {
        return romanNum;
    }

    // Methods
    public int toInt() {
        char roman[] = { ' ', 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int values[] = { 0, 1, 5, 10, 50, 100, 500, 1000 };
        int before = 0;
        int sum = 0;
        char aux = ' ';
        for (int i = 0; i < this.getRomanNum().length(); i++) {
            aux = this.getRomanNum().charAt(i);

            for (int j = 0; j < roman.length; j++) {
                if (aux == roman[j]) {
                    sum += values[j];
                    if (before < values[j]) {
                        sum -= before * 2;
                        before = values[j];

                    } else {
                        before = values[j];
                    }
                }
            }
        }
        return sum;
    }

}
