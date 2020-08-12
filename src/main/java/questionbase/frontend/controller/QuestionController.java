package questionbase.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionbase.backend.service.QuestionService;
import questionbase.frontend.dto.Question;

@Controller
@RequestMapping(value = {"/", "/question"})
public class QuestionController {
    @Autowired
    QuestionService questionService;

    // GET

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "question/index";
    }

    @GetMapping(value="/show/{id}")
    public String getShow(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.find(id));
        model.addAttribute("answers", questionService.findAnswersByQuestionId(id));
        return  "question/show";
    }

    @GetMapping(value="/new")
    public String getNew(Model model) {
        model.addAttribute("question", new Question());
        return "question/new";
    }

    @GetMapping(value="/update/{id}")
    public String getUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.find(id));
        return "question/update";
    }

    // POST

    @PostMapping(value="/new")
    public String postNew(
            @RequestParam String author,
            @RequestParam String text) {
        questionService.create(new Question(author, text));

        return "redirect:/";
    }

    @PostMapping(value="/update")
    public String postUpdate(
            @RequestParam Long id,
            @RequestParam String author,
            @RequestParam String text) {
        Question question = questionService.find(id);

        question.setAuthor(author);
        question.setText(text);
        questionService.update(question);

        return "redirect:/";
    }

    @PostMapping(value="/delete/{id}")
    String postDelete (@PathVariable("id") Long id) {
        questionService.delete(id);

        return "redirect:/";
    }
}
