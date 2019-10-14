package com.example.zadanierekru;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(@RequestParam(required = false) String sciezka,
                        @RequestParam(required = false) String rozszerzenie,
                        @RequestParam(required = false) Byte bajt_wejsciowy,
                        @RequestParam(required = false) Byte bajt_wyjsciowy,
                        ModelMap modelMap) throws IOException {

        if (sciezka != null && rozszerzenie != null && bajt_wejsciowy != null && bajt_wyjsciowy != null) {
            ByteChanges byteChanges = new ByteChanges();
            modelMap.put("change", "Bajty po zamianie: " + byteChanges.getChange(sciezka, rozszerzenie, bajt_wejsciowy, bajt_wyjsciowy));
            modelMap.put("sciezka", sciezka);
            modelMap.put("rozszerzenie", rozszerzenie);
            modelMap.put("bajt_wejsciowy", bajt_wejsciowy);
            modelMap.put("bajt_wyjsciowy", bajt_wyjsciowy);
        }


        return "index";
    }

    @GetMapping("/help")
    public String ContactPage() {
        return "help";
    }

    @GetMapping("/checkByte")
    public String checkByte(
            @RequestParam(required = false) String sciezka,
            @RequestParam(required = false) String rozszerzenie,

            ModelMap modelMap) throws IOException {

        if (sciezka != null && rozszerzenie != null) {
            ByteChanges byteChanges = new ByteChanges();
            modelMap.put("change", "Bajty Występujące w pliku to: " + byteChanges.getFirstByte(sciezka, rozszerzenie));
            modelMap.put("sciezka", sciezka);
            modelMap.put("rozszerzenie", rozszerzenie);
        }
        return "checkByte";
    }


}
