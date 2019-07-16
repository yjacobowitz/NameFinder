import java.util.ArrayList;

public class Chunk {
    private ArrayList<Line> chunk;
    private int count;

    public Chunk(int count){
        this.chunk = new ArrayList<>();
        this.count = count;
    }

    public void addLine(Line line){
        this.chunk.add(line);
    }

    public ArrayList<Line> getChunk(){
        return this.chunk;
    }

    public int getCount(){
        return this.count;
    }
}
