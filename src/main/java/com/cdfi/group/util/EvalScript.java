package com.cdfi.group.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EvalScript {
    public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        ClassLoader classLoader = EvalScript.class.getClassLoader();
        InputStream ruleStream = classLoader.getResourceAsStream("files/rules.js");
        engine.eval(new InputStreamReader(ruleStream));
    }
}