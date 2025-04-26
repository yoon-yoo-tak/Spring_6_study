package com.example.microsns.controller;

import com.example.microsns.domain.Board;
import com.example.microsns.domain.Comment;
import com.example.microsns.service.BoardService;
import com.example.microsns.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "board/list-page";
    }

    // 작성 폼
    @GetMapping("/board/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Board());
        model.addAttribute("mode", "create");
        return "board/form-page";
    }

    // 작성 처리
    @PostMapping("/board")
    public String create(@ModelAttribute Board board) throws SQLException {
        boardService.create(board);
        return "redirect:/";
    }

    // 상세 조회
    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("post", boardService.findById(id));
        model.addAttribute("comments", commentService.getComments(id));
        return "board/detail-page";
    }

    // 수정 폼
    @GetMapping("/board/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", boardService.findById(id));
        model.addAttribute("mode", "edit");
        return "board/form-page";
    }

    // 수정 처리
    @PostMapping("/board/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute Board board) {
        board.setId(id);
        boardService.update(board);
        return "redirect:/board/" + id;
    }

    // 삭제
    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable Long id,
                         @RequestParam String password,
                         RedirectAttributes redirectAttributes) {
        Board board = boardService.findById(id);
        if(!board.getPassword().equals(password)) {
            redirectAttributes.addFlashAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "redirect:/board/" + id;
        }
        boardService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/board/{id}/comments")
    @ResponseBody
    public Comment addComment(@PathVariable Long id, @RequestParam String writer,
                              @RequestParam String password, @RequestParam String content){
        Comment comment = new Comment();
        comment.setBoardId(id);
        comment.setWriter(writer);
        comment.setPassword(password);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());
        commentService.save(comment, id);
        return comment;
    }

    @PostMapping("/comments/{id}/edit")
    @ResponseBody
    public Map<String, Object> editComment(@PathVariable Long id,
                                           @RequestParam String password,
                                           @RequestParam String content) {
        System.out.println("id = " + id);
        boolean success = commentService.updateComment(id, password, content);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        return result;
    }

    @PostMapping("/comments/{id}/delete")
    @ResponseBody
    public Map<String, Object> deleteComment(@PathVariable Long id,
                                             @RequestParam String password) {
        boolean success = commentService.deleteComment(id, password);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        return result;
    }

}
