import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class ChunkThread extends Thread{
    private Thread t;
    private String threadName;
    private Matcher matcher;
    private Aggregator aggregator;

    ChunkThread( String name, Matcher matcher, Aggregator aggregator) {
        this.matcher = matcher;
        this.aggregator = aggregator;
        this.threadName = name;
    }

    public void run() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("James","John","Robert","Michael",
                "William","David","Richard","Charles","Joseph","Thomas","Christopher","Daniel","Paul","Mark",
                "Donald", "George", "Kenneth", "Steven","Edward","Brian","Ronald","Anthony","Kevin","Jason",
                "Matthew","Gary","Timothy","Jose","Larry","Jeffrey", "Frank","Scott","Eric","Stephen","Andrew",
                "Raymond","Gregory","Joshua","Jerry","Dennis","Walter","Patrick","Peter","Harold","Douglas","Henry",
                "Carl","Arthur","Ryan","Roger"));

        HashMap<String, ArrayList<WordResult>> matchesForChunk = this.matcher.match(names);
        this.aggregator.addResultsFromMatcher(matchesForChunk);
    }

    public Boolean isThreadAlive(){
        return t.isAlive();
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, this.threadName);
            t.start ();
        }
    }
}
