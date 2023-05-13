package com.picsartacademy.leetcodeclone.service;

import org.python.core.Py;
import org.python.util.PythonInterpreter;
import org.python.core.PyObject;
import org.springframework.stereotype.Component;

@Component
public class Runner {
    public boolean run(String path, String solutionPath) {
        try (PythonInterpreter pythonInterpreter = new PythonInterpreter()) {
            pythonInterpreter.execfile(path);

            PyObject compileFunction = pythonInterpreter.get("compile");
            PyObject result = compileFunction.__call__(Py.newString(solutionPath));

            return result.__nonzero__();
        }
    }
}
