package com.example.watch_shop.controller;

import com.example.watch_shop.dto.CartDTO;
import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.ITypeWatchService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("watch")
public class WatchController {
    @Autowired
    IWatchService iWatchService;
    @Autowired
    IManufactureService iManufactureService;
    @Autowired
    private ITypeWatchService iTypeWatchService;

    @GetMapping("/detail/{idWatch}")
    public String detail(@PathVariable int idWatch, Model model) {
        model.addAttribute("typeWatchList", iTypeWatchService.findAll());
        model.addAttribute("manufactureList", iManufactureService.findAll());
        model.addAttribute("watch", iWatchService.findByIdWatch(idWatch));
        return "detail";
    }

    @GetMapping("type")
    public String type(Model model, @RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<Watch> page1 = iWatchService.findByType(id, PageRequest.of(page, 6));
        model.addAttribute("list", page1);
        model.addAttribute("listManu", iManufactureService.findAll());
        model.addAttribute("id", id);
        model.addAttribute("check", 1);
        return "watches";
    }


    @GetMapping("watches")
    public String watches(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("list", iWatchService.findAll(PageRequest.of(page, 8)));
        model.addAttribute("listManu", iManufactureService.findAll());
        model.addAttribute("check", 0);
        return "watches";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("search")
    public String searchByName(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "name", required = false) String name) {
        Page<Watch> watchPage = iWatchService.findByName(name, PageRequest.of(page, 6));
        if (watchPage.isEmpty()) {
            String msg="Không tìm thấy sản phẩm";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } else {
            model.addAttribute("list", watchPage);
        }
        model.addAttribute("listManu", iManufactureService.findAll());
        model.addAttribute("check", 2);
        model.addAttribute("name", name);
        return "watches";
    }

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("list", iWatchService.findAll(PageRequest.of(page, 12)));
        return "index";
    }

}