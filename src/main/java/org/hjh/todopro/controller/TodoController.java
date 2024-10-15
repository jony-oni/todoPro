package org.hjh.todopro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hjh.todopro.dto.PageRequestDTO;
import org.hjh.todopro.dto.PageResponseDTO;
import org.hjh.todopro.dto.TodoDTO;
import org.hjh.todopro.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    //@Autowired
    private final TodoService todoService;
    @GetMapping("/register")
    public void registerGet(){
    }

    @PostMapping("/register")
    public String regisiterPost(@Valid TodoDTO todoDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        log.info("regisiterPost()"+todoDTO);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult);
            return "redirect:/todo/register";
        }
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

    //@GetMapping("/list")
    public void list(Model model) {
        log.info("list");  //  todo/list
        List<TodoDTO> todoList=todoService.getAll();
        model.addAttribute("todoList", todoList);
        //return "todo/list";
    }

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,Model model) {
        log.info("list");
        if (bindingResult.hasErrors()) {
            pageRequestDTO=PageRequestDTO.builder().build();
        }
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }


    @PostMapping("/remove")
    public String remove(TodoDTO todoDTO, RedirectAttributes redirectAttributes) {
        log.info("remove()");
        todoService.remove(todoDTO.getTno());
        return "redirect:/todo/list";
    }
    @PostMapping("/modify")
    public String modify(TodoDTO todoDTO, RedirectAttributes redirectAttributes){
        log.info("modify()"+todoDTO);
        todoService.modify(todoDTO);
        redirectAttributes.addAttribute("tno",todoDTO.getTno());
        return "redirect:/todo/read";
    }

    @GetMapping({"/read","/modify"})
    public void read(@RequestParam("tno") int tno, PageRequestDTO pageRequestDTO,Model model) {
        log.info("read");
        TodoDTO todoDTO=todoService.getOne(tno);
        model.addAttribute("dto",todoDTO);
    }

}