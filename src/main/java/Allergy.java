
import java.util.*;
import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Allergy {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/outcome", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/outcome.vtl");

      String score = request.queryParams("score");

      Integer intScore = Integer.parseInt(score);
      model.put("allergyName", allergyName(intScore));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static ArrayList<String> allergyName (Integer score) {
    Map<Integer, String> allergyHash = new HashMap<Integer, String>();
    allergyHash.put(1, "eggs");
    allergyHash.put(2, "peanuts");
    allergyHash.put(4, "shellfish");
    allergyHash.put(8, "strawberries");
    allergyHash.put(16, "tomatoes");
    allergyHash.put(32, "chocolate");
    allergyHash.put(64, "pollen");
    allergyHash.put(128, "cats");

    ArrayList<String> userAllergy = new ArrayList<String>();

      while(score > 0 && score <= 256){
        if(score >= 128){
          score -= 128;
          userAllergy.add(allergyHash.get(128));
        }else if(score >= 64){
          score -= 64;
          userAllergy.add(allergyHash.get(64));
        }else if(score >= 32){
          score -= 32;
          userAllergy.add(allergyHash.get(32));
        }else if(score >= 16){
          score -= 16;
          userAllergy.add(allergyHash.get(16));
        }else if(score >= 8){
          score -= 8;
          userAllergy.add(allergyHash.get(8));
        }else if(score >= 4){
          score -= 4;
          userAllergy.add(allergyHash.get(4));
        }else if(score >= 2){
          score -= 2;
          userAllergy.add(allergyHash.get(2));
        }else{
          score -= 1;
          userAllergy.add(allergyHash.get(1));
        }
    }
    // else {
    //   userAllergy.add("Please add a number less than 256.");
    // }

    System.out.println(userAllergy);
    return userAllergy;
  }

}
