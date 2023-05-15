const { foo } = require('./Solution');

function output() {
    const num1 = process.argv[2];
    const num2 = process.argv[3];

    console.log(`You entered: ${num1} and ${num2}`);
    const sum = foo(parseInt(num1), parseInt(num2));
    console.log(`The sum is: ${sum}`);
    const fs = require('fs');
    const data = sum.toString();
    fs.writeFile('output.txt', data, (err) => {
        if (err) throw err;
        console.log('Data written to file');
    });
}

output();