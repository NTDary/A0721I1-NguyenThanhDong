package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import com.codegym.service.impl.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("music")
public class MusicController {
    private final IMusicService iMusicService = new MusicService();

    @GetMapping("")
    public ModelAndView index() {
        List<Music> musicList = iMusicService.showAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("music", musicList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "music", new Music());
    }

    @PostMapping("/save")
    public ModelAndView save(Music music, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView("redirect:/music/");
        // music.setId((int) (Math.random() * 10000));
        iMusicService.save(music);
        redirectAttrs.addFlashAttribute("message", "Added successfully");


        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit", "music", iMusicService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(Music music, RedirectAttributes redirectAttributes) {

        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Updated successfully");
        return new ModelAndView("redirect:/music/");
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        return new ModelAndView("delete","music",iMusicService.findById(id));
    }
    @PostMapping("/delete")
    public ModelAndView delete(Music music, RedirectAttributes redirectAttributes){
        iMusicService.delete(music.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted successfully");
        return new ModelAndView("redirect:/music/");
    }
    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("view","music",iMusicService.findById(id));
    }
//    @PostMapping("/search")
//    public ModelAndView search(@RequestParam("keyword") String keyword){
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("product",iProductService.findByName(keyword));
//        modelAndView.addObject("keyword",keyword);
//        return modelAndView;
//    }
}
