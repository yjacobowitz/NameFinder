import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TextFinder {

    public static void main(String[] args) {

        try {

            URL url = new URL("http://norvig.com/big.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String text;
            int chunkCount = 0;
            int lineCount = 0;
            Chunk chunk = new Chunk(chunkCount);
            Aggregator aggregator = new Aggregator();
            ArrayList<Chunk> chunks = new ArrayList<>();
            ArrayList<ChunkThread> threads = new ArrayList<>();

            while ((text = in.readLine()) != null) {
                if(lineCount == 1000){
                    chunks.add(chunk);
                    lineCount = 0;
                    chunkCount++;
                    chunk = new Chunk(chunkCount);
                }
                Line line = new Line(text);
                chunk.addLine(line);
                lineCount++;
            }

            if(lineCount < 1000){
                chunks.add(chunk);
            }

            in.close();

            for(Chunk c : chunks){
                Matcher matcher = new Matcher(c);
                ChunkThread thread = new ChunkThread(Integer.toString(c.getCount()), matcher, aggregator);
                threads.add(thread);
                thread.start();
            }

            int running = threads.size();
            do {
                running = threads.size();
                for (ChunkThread thread : threads) {
                    if (thread.isThreadAlive() == false) {
                        running--;
                    }
                }
            } while (running > 0);

            aggregator.printResult();
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

    }

}