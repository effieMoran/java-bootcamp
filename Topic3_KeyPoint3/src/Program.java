import java.util.ArrayList;

public class Program {

    private ArrayList<String> listOfFiles = new ArrayList<String>();

    // Getters & Setters
    public ArrayList<String> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(ArrayList<String> listOfFile) {
        this.listOfFiles = listOfFile;
    }

    // Methods
    public void add(String st) {

        if (this.getListOfFiles().contains(st)) {

            int pos = this.getListOfFiles().indexOf(st);

            String value = this.getListOfFiles().get(pos);

            this.getListOfFiles().add(0, value);

            this.getListOfFiles().remove(3);

        } else if (this.getListOfFiles().size() < 4) {

            this.getListOfFiles().add(st);

        }

        else {
            this.removeFirst();

            this.getListOfFiles().add(st);
        }

    }

    public void removeFirst() {

        this.getListOfFiles().remove(0);

    }

}
