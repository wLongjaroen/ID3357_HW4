
public class Homework {
    // Field
    private String nameOfHomework;
    private String score = "-";
    
    // Constructor 
    public Homework(String name, String score){
        this.nameOfHomework = name;
        this.score = score;
    }
    public Homework(String name){
       nameOfHomework = name;
    }
    // Method
    public boolean isAlready(String hwName){
        return this.nameOfHomework.equals(hwName);
    }
    public void setScore(String score){
        this.score = score;
    }
    public String getHomewrk(){
        return this.nameOfHomework;
    }
    public String getScore(){
        return this.score;
    }
    @Override
    public String toString(){
        System.out.print(this.nameOfHomework+" ");
        return "";
    }
}
