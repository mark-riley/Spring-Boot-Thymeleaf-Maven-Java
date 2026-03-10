package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseWebController {

    private final CourseRepository repo;

    public CourseWebController(CourseRepository repo) {
        this.repo = repo;
    }

    // NEW: The "Middle-man" that transforms the form parameter into a path variable
    @GetMapping("/search-redirect")
    public String searchRedirect(@RequestParam String data) {
        return "redirect:/courses/" + data;
    }


    @GetMapping
    public String list(Model model) {
        model.addAttribute("courses", repo.findAll());
        return "courses/list";
    }


    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("mode", "create");
        return "courses/form";
    }


    @PostMapping
    public String create(@ModelAttribute("course") Course course) {
        repo.save(course);
        return "redirect:/courses";
    }

    // EDIT FORM: show a form filled with existing data
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Course course = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Course not found: " + id));
        model.addAttribute("course", course);
        model.addAttribute("mode", "edit");
        return "courses/form";
    }


    @GetMapping("/{data}")
    public String searchForm(@PathVariable String data, Model model) {
        List<Course> filteredCourses = repo.searchAllFields(data);
        model.addAttribute("courses", filteredCourses);
        return "courses/list";
    }

    // UPDATE SUBMIT: update an existing course
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("course") Course updated) {
        Course course = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Course not found: " + id));

        course.setTitle(updated.getTitle());
        course.setInstructor(updated.getInstructor());
        course.setCourseCode(updated.getCourseCode());
        repo.save(course);

        return "redirect:/courses";
    }

    // DELETE: HTML forms use POST for deletes
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/courses";
    }
}