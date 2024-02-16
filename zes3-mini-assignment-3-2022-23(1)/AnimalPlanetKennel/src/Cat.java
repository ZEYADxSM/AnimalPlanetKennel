import java.io.PrintWriter;
import java.util.Scanner;

public class Cat extends Animal {
    private boolean shareRun;

    /**
     * No argument constructor
     */
    public Cat() {
        this("unknown", "unknown", 1, false);
    }
    public Cat (String name, String food, int mealsPerDay, boolean shareRun){
        super(name,food,mealsPerDay);
        this.shareRun = shareRun;
    }
    public boolean canShareRun (){
        return shareRun;
    }

    public void load(Scanner infile){
        if (infile == null) return;
        super.load(infile);
        shareRun = infile.nextBoolean();
    }
    public void save(PrintWriter pw){
        if (pw == null) return;
        pw.println("Cat");
        super.save(pw);
        pw.println(shareRun);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cat name: ").append(super.toString());
        sb.append("\nCan share: ").append(shareRun);
        return sb.toString();
    }



}