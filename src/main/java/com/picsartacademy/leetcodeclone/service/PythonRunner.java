package com.picsartacademy.leetcodeclone.service;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonRunner {
    private String pythonPath = "src/main/resources/scripts/compile.py";

    public void run() {
        PythonInterpreter interpreter = new PythonInterpreter();

        // Execute the Python code
        interpreter.execfile(pythonPath);

        // Get a reference to the compile_code function
        PyObject compileCodeFunc = interpreter.get("compile_code");

        // Call the compile_code function with the file and json_file arguments
        PyObject result = compileCodeFunc.__call__(Py.newString("../../../../data/Solution.js"), Py.newString("../../../../data/output.js"));

        // Convert the result to a Java string
        String output = (String) result.__tojava__(String.class);

        // Print the output
        System.out.println(output);

        // Clean up the interpreter
        interpreter.close();
    }
}
