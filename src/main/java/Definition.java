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

}
