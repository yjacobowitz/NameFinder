public class Line {
    private String line;

    public Line(String line){
        this.line = line;
    }

    public int getLineLength(){
        return this.line.length();
    }

    public String getLine(){
        return this.line;
    }
}
