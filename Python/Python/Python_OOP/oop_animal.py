class Animal:
    def __init__(self, name, health):
        self.name = name
        self.health = health
    def walk(self):
        self.health -= 1
        return self
    def run(self):
        self.health -= 5
        return self
    def displayHealth(self):
        print(self.health)
        return self

class Dog(Animal):
    def __init__(self, name):
        super().__init__(name, 150)
    def pet(self):
        self.health += 5
        return self

class Dragon(Animal):
    def __init__(self, name):
        super().__init__(name, 170)
    def fly(self):
        self.health -= 10
        return self
    def displayHealth(self):
        super().displayHealth()
        print("I am a Dragon")

bird = Animal("Petey", 100)
bird.walk().walk().walk().run().run().displayHealth()

myDog = Dog("Barley")
myDog.walk().walk().walk().run().run().pet().displayHealth()

myDragon = Dragon("Tiny")
myDragon.displayHealth()