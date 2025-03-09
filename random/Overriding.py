class Animal:
    def sound(self):
        print("makes sound")
        
class Dog(Animal):
    def sound(self):
        super().sound()
        print("Woof")
        
obj=Dog()
obj.sound()