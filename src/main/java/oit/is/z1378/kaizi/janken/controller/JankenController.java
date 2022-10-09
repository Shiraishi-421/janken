package oit.is.z1378.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String janken2(@RequestParam String username, ModelMap model) {
    model.addAttribute("username", username);
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String hand, ModelMap model) {
    String opp = "Gu";
    String w = "Win!", d = "Draw", l = "Lose...";

    model.addAttribute("my", hand);
    model.addAttribute("opponent", opp);

    if (hand.equals(opp)) {
      model.addAttribute("result", d);
    } else if (hand.equals("Pa")) {
      model.addAttribute("result", w);
    } else if (hand.equals("Tyoki")) {
      model.addAttribute("result", l);
    }

    return "janken.html";
  }

}
