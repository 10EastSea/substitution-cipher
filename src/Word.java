import java.io.*;
import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Word {
    private String word;
    private boolean isValid;

    public Word(String word) {
        this.word = word;
        this.isValid = checkWord();
    }

    private boolean checkWord() {
        try {
            JSONObject wordData = urlRead();
            String tmpObj = ((JSONObject)wordData.get("query")).get("pages").toString();
            if(tmpObj.charAt(2) != '-') return true;
        } catch(Exception e) { }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONObject strToJson(String str) throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(str);
        return (JSONObject) obj;
    }

    private JSONObject urlRead() throws Exception {
        StringBuilder sb = new StringBuilder();

        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&titles="+ word + "&format=json");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF8"));

        String str;
        while((str = br.readLine()) != null) sb.append(str);
        br.close();

        return strToJson(sb.toString());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public String getWord() { return word; }
    public boolean getIsValid() { return isValid; }
}
