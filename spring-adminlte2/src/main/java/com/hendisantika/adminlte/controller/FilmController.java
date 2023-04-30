package com.hendisantika.adminlte.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hendisantika.adminlte.model.Customers;
import com.hendisantika.adminlte.model.Film;
import com.hendisantika.adminlte.service.FilmService;

import util.FileUploadUtil;

@Controller
@RequestMapping("film")
public class FilmController {

    private FilmService filmService;
    private final String UPLOAD_DIR = "/src/main/resources/static/photos/films/";

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String index() {
        return "redirect:/film/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Film> page = filmService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("listFilms", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "film/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("film", new Film());
        return "film/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("film", filmService.get(id));
        return "film/form";
    }
	/*
	 * @PostMapping(value = "/save") public String save(@RequestParam("file")
	 * MultipartFile file, Film film, final RedirectAttributes ra) { if
	 * (!file.isEmpty()) { String fileName =
	 * StringUtils.cleanPath(file.getOriginalFilename()); try { String uuid =
	 * UUID.randomUUID().toString(); String uploadDir = UPLOAD_DIR;
	 * FileUploadUtil.saveFile(uploadDir, uuid + fileName, file);
	 * film.setPhoto("/photos/films/" + uuid + fileName); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 * Film save = filmService.save(film); ra.addFlashAttribute("successFlash",
	 * "Film " + save + " ajouté avec succès"); return "redirect:/film"; }
	 */
    
    // vous pouvez trouver deux methode save la methode au dessus permet l'eregistrment d'une photo mais il est n'est pas mentionne dans le modele relationnel
    @PostMapping(value = "/save")
    public String save(Film film, final RedirectAttributes ra) {

    	Film save = filmService.save(film);
        ra.addFlashAttribute("successFlash", "Film added succesfully");
        return "redirect:/film";

    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        filmService.delete(id);
        return "redirect:/film";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        model.addAttribute("film", filmService.get(id));
        return "film/details";
    }

    @GetMapping("/show/list")
    public String showFilms() {
        return "/film/listNG";
    }

    @GetMapping(path="/NG/listf", produces = "application/json")
    public @ResponseBody List<Film> getAllFilms() {
        List<Film> allFilms = filmService.getListAll();
        System.out.println("Size of List allFilms : " + allFilms.size());
        return allFilms;
    }
}





