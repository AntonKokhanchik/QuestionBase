package questionbase.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import questionbase.backend.service.QuestionService;

@Controller
@RequestMapping(value = {"/", "/question"})
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "questionIndex";
    }
}
