package questionbase.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionbase.backend.service.AnswerService;
import questionbase.backend.service.QuestionService;
import questionbase.frontend.dto.Question;

@Controller
@RequestMapping(value = {"/", "/question"})
@SessionAttributes("sessionUser")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    // GET

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("questions", questionService.findAll());
        model.addAttribute("answers", answerService.findAll());
        return "question/index";
    }

    @GetMapping(value="/show/{id}")
    public String getShow(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.find(id));
        model.addAttribute("answers", questionService.findAnswersByQuestionId(id));
        model.addAttribute("comments", questionService.findCommentsByQuestionId(id));
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
            @RequestParam String text,
            @RequestParam(defaultValue = "false") Boolean isMulti) {
        questionService.create(new Question(text, isMulti));

        return "redirect:/";
    }

    @PostMapping(value="/update")
    public String postUpdate(
            @RequestParam Long id,
            @RequestParam String text,
            @RequestParam(defaultValue = "false") Boolean isMulti) {
        Question question = questionService.find(id);

        question.setText(text);
        question.setMulti(isMulti);
        questionService.update(question);

        return "redirect:/";
    }

    @PostMapping(value="/delete/{id}")
    String postDelete (@PathVariable("id") Long id) {
        questionService.delete(id);

        return "redirect:/";
    }
}
