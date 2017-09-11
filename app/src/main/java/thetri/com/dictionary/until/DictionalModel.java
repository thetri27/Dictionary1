package thetri.com.dictionary.until;

/**
 * Created by DELL on 9/11/2017.
 */

public class DictionalModel {
    private String id;
    private String word;
    private String definition;

    public DictionalModel(String id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
