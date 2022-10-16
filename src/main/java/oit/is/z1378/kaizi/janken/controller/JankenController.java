package oit.is.z1378.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1378.kaizi.janken.model.Entry;

@Controller
public class JankenController {

  @Autowired
  private Entry room;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("username", prin.getName());
    model.addAttribute("room", this.room);
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
