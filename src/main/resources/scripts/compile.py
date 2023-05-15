import subprocess
import json

def compile_cpp(file:str):
    filename = file
    outname = filename[:filename.find(".cpp")]
    command = ["g++", filename, "-o", outname]
    process = subprocess.run(command, capture_output=True)
    if process.returncode == 1:
        return ("Compile error", process.stderr.decode("utf-8"))
    return ("Success", outname)

def compile_java(file:str):
    filename = file
    outname = filename.replace(".java", ".class")
    command = ["javac", filename]
    process = subprocess.run(command, capture_output=True)
    if process.returncode == 1:
        return ("Compile error", process.stderr.decode("utf-8"))
    return ("Success", outname)

def compile_js(file:str):
    filename = file
    command = ["node", filename]
    process = subprocess.run(command, capture_output=True)
    if process.returncode == 1:
        return ("Compile error", process.stderr.decode("utf-8"))
    return ("Success", file)

def compile_python(file:str):
    filename = file
    command = ["python3", filename]
    process = subprocess.run(command, capture_output=True)
    if process.returncode == 1:
        return ("Compile error", process.stderr.decode("utf-8"))
    return ("Success", file)

def compile_code(file:str, json_file:str):
    extension = file[file.rfind("."):]
    langDict = {".cpp": compile_cpp,
                ".py": compile_python,
                ".java": compile_java,
                ".js": compile_js
                }

    runLangDict = {
        ".cpp": "C++",
        ".py": "python",
        ".java": "Java",
        ".js": "JS"
    }

    res = langDict[extension](file)
    json_res = {"Status": res[0], "Message": res[1]}

    a = subprocess.run(["cppSide/main", runLangDict[extension]], capture_output=True)
    print(a)
    with open(json_file, "w") as file:
        json.dump(json_res, file)