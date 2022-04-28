function fibonacci(count:number):Array<number> {
    let f0:number=0;
    let f1:number=1;
    let f:number = f0+f1;
    let array:number[]=[];
    array.push(f0);
    array.push(f1);
    array.push(f);
    for (let i:number=3;i<=count-1;i++) {
        f0=f1;
        f1=f;
        f=f0+f1;
        array.push(f);
    }
    return array;
}
// Tính tổng 5 số Fibonacci đầu tiên.
let sum:number=0;
let array:number[] = fibonacci(5);
console.log("Mảng chứa các số Fibonancci là: ")
console.log(array)git
// for (let i=0;i<=array.length;i++){
//     sum+=array[i];
// }
for (let number of array) {
    sum+=number;
}
console.log("Tổng các số fibonacci là "+sum);