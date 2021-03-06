import java.util.ArrayList;

public class Definition {

  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mMeaning;
  private int mId;

  public Definition(String meaning) {
    mMeaning = meaning;
    instances.add(this);
    mId = instances.size();
  }

  public String getMeaning() {
    return mMeaning;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id-1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
