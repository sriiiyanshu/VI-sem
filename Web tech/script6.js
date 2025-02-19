function checkOddEven() {
    // Get the input value
    const number = document.getElementById('numberInput').value;

    // Convert the input to an integer
    const num = parseInt(number);

    // Check if the input is a valid integer
    if (isNaN(num)) {
        document.getElementById('result').innerText = "Please enter a valid integer.";
        return;
    }

    // Determine if the number is odd or even
    if (num % 2 === 0) {
        document.getElementById('result').innerText = `${num} is EVEN.`;
    } else {
        document.getElementById('result').innerText = `${num} is ODD.`;
    }
}