import java.util.HashMap;
import java.util.ArrayList;

public class Matcher {
    private Chunk chunk;

    public Matcher(Chunk chunk){
        this.chunk = chunk;
    }

    public HashMap<String, ArrayList<WordResult>> match(ArrayList<String> names){
        int charOffset = 0;
        HashMap<String, ArrayList<WordResult>> matches = new HashMap<>();

        for(int i = 0; i < chunk.getChunk().size(); i++){
            Line line = chunk.getChunk().get(i);
            String lineText = line.getLine().toLowerCase();
            for(String name : names ) {
                for (int fromIndex = 0; (fromIndex = lineText.indexOf(name.toLowerCase(), fromIndex)) != -1; fromIndex++) {
                    int lineOffset = chunk.getCount() * 1000 + (i + 1);
                    WordResult resultForName = new WordResult(lineOffset, charOffset + fromIndex);

                    if (matches.get(name) == null) {
                        ArrayList<WordResult> resultsForName = new ArrayList<>();
                        resultsForName.add(resultForName);
                        matches.put(name, resultsForName);
                    } else {
                        ArrayList<WordResult> resultsForName = matches.get(name);
                        resultsForName.add(resultForName);
                        matches.put(name, resultsForName);
                    }
                }
            }
            charOffset += line.getLineLength();
        }
        return matches;
    }
}
