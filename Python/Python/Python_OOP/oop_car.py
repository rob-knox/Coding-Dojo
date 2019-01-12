class Car:
    def __init__(self, price, speed, fuel, mileage):
        self.price = price
        self.speed = speed
        self.fuel = fuel
        self.mileage = mileage
    def calcTax(self):
        if (self.price > 10000):
            self.tax = 0.15
            return self
        else:
            self.tax = 0.12
            return self
    def display_all(self):
        print("Price: {}".format(self.price))
        print("Speed: {}".format(self.speed))
        print("Fuel: {}".format(self.fuel))
        print("Mileage: {}".format(self.mileage))
        print("Tax: {}".format(self.tax))
        print("*"*50)
        return self
    
car1 = Car(2000, "35mph", "Full", "15mpg")
car1.calcTax().display_all()

car2 = Car(2000, "5mph", "Not Full", "105mpg")
car2.calcTax().display_all()

car3 = Car(2000, "15mph", "Kind of Full", "95mpg")
car3.calcTax().display_all()

car4 = Car(2000, "25mph", "Full", "25mpg")
car4.calcTax().display_all()

car5 = Car(2000, "45mph", "Empty", "25mpg")
car5.calcTax().display_all()

car6 = Car(20000000, "35mph", "Empty", "15mpg")
car6.calcTax().display_all()