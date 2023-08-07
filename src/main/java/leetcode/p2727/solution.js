/**
 * @param {Object | Array} obj
 * @return {boolean}
 */
var isEmpty = function (obj) {
    // obj.length is not a good idea
    // e.g. {"length": 0}
    // using Object#keys for array is also fine
    return Object.keys(obj).length === 0;
};

var isEmpty = function (obj) {
    // if empty, for-loop is skipped
    for (const _ in obj) {
        // at least one and any element was found
        // early return
        return false;
    }
    return true;
};
