package com.picsartacademy.leetcodeclone.service;

import org.python.core.Py;
import org.python.util.PythonInterpreter;
import org.python.core.PyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Runner {
    private JSONFileChecker jsonFileChecker;

    private final String path = "src/main/resources/scripts/example.py";
    @Autowired
    public Runner(JSONFileChecker jsonFileChecker) {
        this.jsonFileChecker = jsonFileChecker;
    }

    public boolean run(String solutionPath) {
        try (PythonInterpreter pythonInterpreter = new PythonInterpreter()) {
            pythonInterpreter.execfile(path);

            PyObject compileFunction = pythonInterpreter.get("compile");
            PyObject result = compileFunction.__call__(Py.newString(solutionPath));

            return result.__nonzero__();
        }
    }
}
