package questionbase.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionbase.backend.service.CommentService;
import questionbase.frontend.dto.Comment;

@Controller
@RequestMapping(value = {"/comment"})
public class CommentController {
    @Autowired
    CommentService commentService;

    // GET

    @GetMapping(value="/new")
    String getNew(@RequestParam Long questionId, Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("questionId", questionId);
        return "comment/new";
    }

    @GetMapping(value="/update/{id}")
    String getUpdate(@PathVariable Long id, Model model){
        model.addAttribute("comment", commentService.find(id));
        return "comment/update";
    }

    // POST

    @PostMapping(value="/new")
    String postNew(@RequestParam String author,
                   @RequestParam String text,
                   @RequestParam Long questionId) {
       commentService.create(new Comment(author, text), questionId);
       return "redirect:/question/show/" + questionId;
    }

    @PostMapping(value="/update")
    String postUpdate(@RequestParam Long id,
                      @RequestParam String author,
                      @RequestParam String text) {
        Comment comment = commentService.find(id);

        comment.setAuthor(author);
        comment.setText(text);
        commentService.update(comment);

        return "redirect:/question/show/" + comment.getQuestion().getId();
    }

    @PostMapping(value="/delete/{id}")
    String postDelete(@PathVariable Long id) {
        Long questionId = commentService.find(id).getQuestion().getId();
        commentService.delete(id);
        return "redirect:/question/show/" + questionId;
    }
}
