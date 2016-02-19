import java.util.ArrayList;

public class Word {

  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mTerm;
  private int mId;

  private ArrayList<Definition> mDefinitions;

  public Word(String term) {
    mTerm = term;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

}