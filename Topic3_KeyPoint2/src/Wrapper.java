public class Wrapper {

    private String string;
    private int rowLength;

    // Getters & Setters
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int i) {
        this.rowLength = i;
    }

    // Constructor
    public Wrapper(String string, int i) {
        this.string = string;
        this.rowLength = i;
    }

    public String split() {

        char[] charArray = this.getString().toCharArray();

        String a = "";
        String result = "";

        for (int i = 0; i < charArray.length; i++) {

            a += charArray[i];

            if ((i + 1) % this.getRowLength() == 0 || i == charArray.length - 1) {
                result += a + ",";
                a = "";

            }
        }

        result = result.replaceAll("^\\s+", "").replaceAll(",+$", "");

        return result;
    }

}
