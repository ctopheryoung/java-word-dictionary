import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    // ProcessBuilder process = new ProcessBuilder();
    //  Integer port;
    //  if (process.environment().get("PORT") != null) {
    //      port = Integer.parseInt(process.environment().get("PORT"));
    //  } else {
    //      port = 4567;
    //  }
    //
    // setPort(port);

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object> ();
      String term = request.queryParams("term");
      Word newWord = new Word(term);
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object> ();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object> ();

    Word word = Word.find(Integer.parseInt(request.params(":id")));
    ArrayList<Definition> definitions = word.getDefinitions();
    model.put("word", word);
    model.put("definitions", definitions);
    model.put("template", "templates/word-definition-form.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

}
