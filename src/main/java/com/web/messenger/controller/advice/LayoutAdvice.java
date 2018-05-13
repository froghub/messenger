package com.web.messenger.controller.advice;

import com.samskivert.mustache.Mustache;
import com.web.messenger.view.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.samskivert.mustache.Mustache.Compiler;

@ControllerAdvice
public class LayoutAdvice {
    private final Mustache.Compiler compiler;

    @Autowired
    public LayoutAdvice(Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("layout")
    public Mustache.Lambda layout(Model model) {
        return new Layout(compiler);
    }
    @ModelAttribute("title")
    public Mustache.Lambda defaults(@ModelAttribute Layout layout) {
        return (frag, out) -> {
            layout.title = frag.execute();
        };
    }
}
