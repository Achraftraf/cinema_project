package com.hendisantika.adminlte.controller;

import com.hendisantika.adminlte.model.Genre;
import com.hendisantika.adminlte.service.GenreService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("genres")
public class GenreController {

    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String index() {
        return "redirect:/genres/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
    	
    	
        Page<Genre> page = genreService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "genres/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("genre", new Genre());
        return "genres/form";
        

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("genre", genreService.get(id));
        return "genres/form";

    }

    @PostMapping(value = "/save")
    public String save(Genre genre, final RedirectAttributes ra) {

        Genre save = genreService.save(genre);
        ra.addFlashAttribute("successFlash", "Genre has been saved successfully.");
        return "redirect:/genres";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        genreService.delete(id);
        return "redirect:/genres";

    }
    
    @GetMapping(path = "/api/list", produces = "application/json")
    public @ResponseBody
    List<Genre> getAllGenres()
    {
    	List<Genre> allGenres = new ArrayList<Genre>();
        allGenres = genreService.getListAll();
        return allGenres;
    }

}

