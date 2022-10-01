console(isSubsequence("abc", "ahbgdc"));


/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 var isSubsequence = function(s, t) {
    if(s.length > t.length){
        return false;
    }
    var pointer = 0;
    for(let i = 0; i < s.length; i++){
        var temp = s[i];
        var b = false;
        for(let j = pointer; j < t.length; j++){
            if(t[j] == temp){
                pointer++;
                b = true;
                break;
            }
            pointer++;
        }
        if(b == false){
            return false;
        }
    }
    return true;
};