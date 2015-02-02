public class IntNum {

    private int intNum;

    // Constructor
    public IntNum(int intNum) {
        this.intNum = intNum;

    }

    // Getters & Setters
    public int getIntNum() {
        return intNum;
    }

    public void setIntNum(int intNum) {
        this.intNum = intNum;
    }

    // Methods
    public String toRoman() {
        String rom[] = { "M", "XM", "CM", "D", "XD", "CD", "C", "XC", "L",
                "XL", "X", "IX", "V", "IV", "I" };
        int arab[] = { 1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9,
                5, 4, 1 };
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (this.getIntNum() > 0 || arab.length == (i - 1)) {
            while ((this.getIntNum() - arab[i]) >= 0) {
                this.setIntNum(this.getIntNum() - arab[i]);
                result.append(rom[i]);
            }
            i++;
        }

        return result.toString();
    }

}
