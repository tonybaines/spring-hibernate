package masterclass.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = {"Accept=application/json"})
  public @ResponseBody Map getBook(@PathVariable("id") long id, Model model) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("Greeting", "Hello world");
    return map;
  }

}
