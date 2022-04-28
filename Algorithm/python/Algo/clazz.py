def scope_test():
    def do_local():
        spam = "local spam"

    def do_nonlocal():
        nonlocal spam
        spam = "nonlocal spam"

    def do_global():
        global spam
        spam = "global spam"

    spam = "test spam"
    do_local()
    print("After local assignment:", spam)
    do_nonlocal()
    print("After nonlocal assignment:", spam)
    do_global()
    print("After global assignment:", spam)


scope_test()
print("In global scope:", spam)


class Complex:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y


z = Complex(2, 3)
print(z.x)


class Bag:
    def __init__(self) -> None:
        self.data = []

        def add(selft, x):
            self.data.append(x)

        def addtwice(self, x):
            self.add(x)
            self.add(x)
