package com.kmochocki;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {
    public int eval(String equation) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        return Integer.parseInt(engine.eval(equation).toString());
    }

    public int eval1(String equation) throws ScriptException {
        return 6;
    }
}
