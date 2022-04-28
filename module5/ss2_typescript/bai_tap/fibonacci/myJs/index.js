function fibonacci(count) {
    let f0 = 0;
    let f1 = 1;
    let f = f0 + f1;
    let array = [];
    array.push(f0);
    array.push(f1);
    array.push(f);
    for (let i = 3; i <= count - 1; i++) {
        f0 = f1;
        f1 = f;
        f = f0 + f1;
        array.push(f);
    }
    return array;
}
// Tính tổng 5 số Fibonacci đầu tiên.
let sum = 0;
let array = fibonacci(5);
console.log("Mảng chứa các số Fibonancci là: ");
console.log(array);
// for (let i=0;i<=array.length;i++){
//     sum+=array[i];
// }
for (let number of array) {
    sum += number;
}
console.log("Tổng các số fibonacci là " + sum);
