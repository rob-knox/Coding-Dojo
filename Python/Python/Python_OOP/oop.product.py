class Product:
    def __init__(self, price, item_name, weight, brand, status):
        self.price = price
        self.item_name = item_name
        self.weight = weight
        self.brand = brand
        self.status = status
    def sell(self):
        if self.price == 0:
            print("sold")
        else:
            print("for sale")
        return self
    def addTax(self, tax):
        self.salesTax = "%.2f" % round(self.price * tax, 2)
        print("Price: ${}".format(self.price))
        print("Sales Tax: ${}".format(self.salesTax))
        return self
    def returnItem(self, reason_for_return):
        if reason_for_return == "defective":
            self.status = "defective"
            self.price = 0
        if reason_for_return == "opened":
            self.status = "used"
            self.price -= self.price * .80 # 20% discount
        if reason_for_return == "like new":
            self.status = "for sale"
        #return self
    def displayInfo(self):
        print("${}".format(self.price))
        print(self.item_name)
        print(self.weight)
        print(self.brand)
        print(self.status)
        return self

apple_tv = Product(199, "Apple TV", "5lbs", "Apple", "new")
apple_tv.addTax(.10)
apple_tv.returnItem("like new")
apple_tv.displayInfo()

