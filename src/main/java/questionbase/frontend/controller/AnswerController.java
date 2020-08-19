package questionbase.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionbase.backend.service.AnswerService;
import questionbase.frontend.dto.Answer;

@Controller
@RequestMapping(value = {"/answer"})
@SessionAttributes("sessionUser")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    // GET

    @GetMapping(value="/new")
    String getNew(@RequestParam Long questionId, Model model) {
        model.addAttribute("answer", new Answer());
        model.addAttribute("questionId", questionId);
        return "answer/new";
    }

    @GetMapping(value="/update/{id}")
    String getUpdate(@PathVariable Long id, Model model){
        model.addAttribute("answer", answerService.find(id));
        return "answer/update";
    }

    // POST

    @PostMapping(value="/new")
    String postNew(@RequestParam String text,
                   @RequestParam(defaultValue = "false") Boolean isRight,
                   @RequestParam Long questionId) {
        answerService.create(new Answer(text, isRight), questionId);
        return "redirect:/question/show/" + questionId;
    }

    @PostMapping(value="/update")
    String postUpdate(@RequestParam Long id,
                      @RequestParam String text,
                      @RequestParam(defaultValue = "false") Boolean isRight) {
        Answer answer = answerService.find(id);

        answer.setRight(isRight);
        answer.setText(text);
        answerService.update(answer);

        return "redirect:/question/show/" + answer.getQuestion().getId();
    }

    @PostMapping(value="/delete/{id}")
    String postDelete(@PathVariable Long id) {
        Long questionId = answerService.find(id).getQuestion().getId();
        answerService.delete(id);
        return "redirect:/question/show/" + questionId;
    }
}
