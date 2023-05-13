import json

def compile(file_path):
    try:
        with open(file_path, 'r') as file:
            file_content = file.read()

        data = {
            "status": "success",
            "file_content": file_content
        }

    except Exception as e:
        data = {
            "status": "error",
            "error_message": str(e)
        }

    output_file_path = "data/output.json"

    with open(output_file_path, 'w') as output_file:
        json.dump(data, output_file)