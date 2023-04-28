package com.hendisantika.adminlte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hendisantika.adminlte.model.Nationalite;
import com.hendisantika.adminlte.service.NationaliteService;

@Controller
@RequestMapping("nationalite")
public class NationaliteController {

    private NationaliteService nationaliteService;

    @Autowired
    public void setNationaliteService(NationaliteService nationaliteService) {
        this.nationaliteService = nationaliteService;
    }

    @GetMapping
    public String index() {
        return "redirect:/nationalite/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Nationalite> page = nationaliteService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "nationalite/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("nationalite", new Nationalite());
        return "nationalite/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("nationalite", nationaliteService.get(id));
        return "nationalite/form";

    }

    @PostMapping(value = "/save")
    public String save(Nationalite nationalite, final RedirectAttributes ra) {

    	Nationalite save = nationaliteService.save(nationalite);
        ra.addFlashAttribute("successFlash", "Nationalite foi salvo com sucesso.");
        return "redirect:/nationalite";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

    	nationaliteService.delete(id);
        return "redirect:/nationalite";

    }
	   
	   
	   
}
