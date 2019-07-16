import java.util.ArrayList;
import java.util.HashMap;

public class Aggregator {
    private HashMap<String, ArrayList<WordResult>> resultsByName;

    public Aggregator(){
        this.resultsByName = new HashMap<>();
    }

    public HashMap<String, ArrayList<WordResult>> getResults(){
        return this.resultsByName;
    }

    public synchronized void addResultsFromMatcher(HashMap<String, ArrayList<WordResult>> resultsFromMatcher){
        for (String key : resultsFromMatcher.keySet()) {
            ArrayList<WordResult> matchesForName = resultsFromMatcher.get(key);
            if (this.resultsByName.get(key) == null) {
                this.resultsByName.put(key, matchesForName);
            } else {
                this.resultsByName.get(key).addAll(matchesForName);
            }

        }

    }

    public void printResult() {
        HashMap<String, ArrayList<WordResult>> resultsByName = new HashMap<>(this.resultsByName);
        for (String key : resultsByName.keySet()) {
            ArrayList<WordResult> matchesForName = this.resultsByName.get(key);
            System.out.print(key + "\n\r");
            for(int i = 0; i < matchesForName.size(); i++){
                matchesForName.get(i).printWordResult();
            }
            System.out.print("\n\r");
        }
    }
}
