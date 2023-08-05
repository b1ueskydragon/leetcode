Array.prototype.last = function() {
    const n = this.length;
    return (n === 0) ? -1 : this[n - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */