package masterclass.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String getBook(@PathVariable("id") long id, Model model) {
    return "books";
  }

}
