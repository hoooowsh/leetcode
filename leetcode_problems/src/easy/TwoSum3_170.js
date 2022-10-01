var TwoSum = function() {
    this.map = new Map();
};

/** 
 * @param {number} number
 * @return {void}
 */
TwoSum.prototype.add = function(number) {
    this.map.set(number, this.map.get(number) + 1 || 1);
};

/** 
 * @param {number} value
 * @return {boolean}
 */
TwoSum.prototype.find = function(value) {
    for(const num of this.map.keys()) {
        const rest = value - num;
        if(rest === num) {
            if(this.map.get(num) > 1) return true;
            else continue;
        }
        else if(this.map.has(rest)) return true;
    }
    return false;
};

/** 
 * Your TwoSum object will be instantiated and called as such:
 * var obj = new TwoSum()
 * obj.add(number)
 * var param_2 = obj.find(value)
 */