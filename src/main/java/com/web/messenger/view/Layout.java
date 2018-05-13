package com.web.messenger.view;


import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;

import java.io.IOException;
import java.io.Writer;
import com.samskivert.mustache.Mustache.Compiler;

public class Layout implements Mustache.Lambda  {
    String body;
    public String title = "Default title";
    private Compiler compiler;

    public Layout(Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Fragment frag, Writer out) throws IOException {
        body = frag.execute();
        compiler.compile("{{>layout}}").execute(frag.context(), out);
    }
}
