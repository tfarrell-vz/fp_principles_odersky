type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)

def singletonSet(elem: Int): Set = (x: Int) => x == elem

def union(s: Set, t: Set): Set = (x: Int) => contains(s, x) || contains(t, x)
def intersect(s: Set, t: Set): Set = (x: Int) => contains(s, x) && contains(t, x)
def diff(s: Set, t: Set): Set = (x: Int) => contains(s, x) && !contains(t, x)

def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)

