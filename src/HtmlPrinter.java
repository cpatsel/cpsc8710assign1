import java.io.FileWriter;
import java.util.Vector;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.IOException;
public class HtmlPrinter {

    private FileWriter file;
    private Vector<String> keywords;
    private SortedMap<String,String> mapCopy;
    HtmlPrinter(SortedMap<String,String> dict){
        try {
            file = new FileWriter("glossary.html");
        } catch(IOException e){
            e.printStackTrace();
        }
        mapCopy = dict;
        keywords = new Vector<>(dict.keySet());

    }

    public void writeString(String s){
        try {
            file.write(s);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void writeHeader(){
        writeString("<!DOCTYPE html>");
        writeString("<head>Glossary</head>");
        writeString("<body>");

    }

    public void writeIndex(){
        writeString("<ul>");
        for (String word : keywords){
            writeString("<a href=\"#"+word+"\">");
            writeString("<li>"+word+"</li>");
            writeString("</a>");

        }
        writeString("</ul>");
    }
    public void writeEntries() {
        writeString("<hr>");
        for (String word : keywords) {
            String def = mapCopy.get(word);

            writeString("<h2 id=\""+word+"\">"+word+"</h2>");
            writeString("<p>"+def+"</p>");

        }
    }

    public void writeFooter(){
        writeString("</body>");
    }
    public void close() {
        try {
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
