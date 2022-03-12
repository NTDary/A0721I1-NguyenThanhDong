package com.codegym.music.controller;

import com.codegym.music.model.Music;
import com.codegym.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Music> musicList = iMusicService.findAll(pageable);
        modelAndView.addObject("musics",musicList);

        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Music music, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("create");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        iMusicService.save(music);
        return modelAndView;
    }
}
