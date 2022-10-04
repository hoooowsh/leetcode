/**
 * @param {number} num
 * @return {number}
 */
 var addDigits = function(num) {
    var temp = 0;
    while(num >= 10){
        while(num != 0){
            temp += num % 10;
            num = Math.floor(num / 10);
        }
        num = temp;
        temp = 0;
    }
    return num;
};