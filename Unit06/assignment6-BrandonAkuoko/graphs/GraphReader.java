package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {
    public static Graph<String> readGraph(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        Graph<String> graph = new AdjacencyGraph<>();
        br.readLine(); // first line is unnecessary
        br.readLine(); // second line is also irrelevant
        boolean temp = true;
        while(temp){
            String line = br.readLine();
            if(line == null){
                break;
            }
            else{
                String[] tokens = line.split(" ");
                if(!graph.contains(tokens[0])){
                    graph.add(tokens[0]);
                }
                for(int i = 1; i < tokens.length; i++){
                    if(!graph.contains(tokens[i])){
                        graph.add(tokens[i]);
                        graph.connectUndirected(tokens[0], tokens[i]);
                    }
                }
            }
        }
        return graph;
    }
}
