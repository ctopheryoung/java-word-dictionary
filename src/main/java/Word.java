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

  public String getTerm() {
    return mTerm;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public static ArrayList<Word> all() {
    return instances;
  }


  public static void clear() {
    instances.clear();
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }
}
