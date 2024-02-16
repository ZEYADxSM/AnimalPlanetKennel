import java.util.Scanner;

public class Dog extends Animal {
    private boolean likesBones;

    /**
     * No argument constructor
     */
    public Dog() {
        this("unknown", "unknown", 1, false);
    }

    public Dog(String name, String food, int mealsPerDay, boolean likeBones) {
        super(name, food, mealsPerDay);
        this.likesBones = likeBones;

    }
    public boolean getLikesBones() {
        return likesBones;
    }
    public void load(Scanner infile){
        if (infile == null) return;
        super.load(infile);
        likesBones = infile.nextBoolean();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dog name: ").append(super.toString());
        sb.append("\nLikes bones: ").append(likesBones);
        return sb.toString();
    }

}