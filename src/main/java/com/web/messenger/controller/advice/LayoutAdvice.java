package com.web.messenger.controller.advice;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.samskivert.mustache.Mustache.Compiler;

import java.io.IOException;
import java.io.Writer;

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
			System.out.println(layout.title);
		};
    }
}

class Layout implements Mustache.Lambda  {
	String body;
	String title = "Default title";
	private Compiler compiler;

	public Layout(Compiler compiler) {
		this.compiler = compiler;
	}

	@Override
	public void execute(Template.Fragment frag, Writer out) throws IOException {
		body = frag.execute();
		compiler.compile("{{>layout}}").execute(frag.context(), out);
	}
}