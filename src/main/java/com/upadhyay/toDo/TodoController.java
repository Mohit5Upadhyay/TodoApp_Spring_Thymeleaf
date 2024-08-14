package com.upadhyay.toDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

	@Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/todos")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "alltodos";
    }

    @GetMapping("/todos/new")
    public String createTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "create_todo";
    }

    @PostMapping("/todos")
    public String saveTodo(@ModelAttribute("todo") Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/todos/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        return "create_todo";
    }

    @PostMapping("/todos/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute("todo") Todo todo) {
        Todo existingTodo = todoService.getTodoById(id);
        existingTodo.setTitle(todo.getTitle());
        todoService.saveTodo(existingTodo);
        return "redirect:/todos";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/todos";
    }
}
