public class WordResult {
    private int lineOffset;
    private int charOffset;

    public WordResult(int lineOffset, int charOffset){
        this.lineOffset = lineOffset;
        this.charOffset = charOffset;
    }

    public int getLineOffset(){
        return this.lineOffset;
    }

    public int getCharOffset(){
        return this.charOffset;
    }

    public void printWordResult(){
        System.out.println("lineOffset: " + this.lineOffset + ", " + "charOffset: " + this.charOffset);
    }
}
