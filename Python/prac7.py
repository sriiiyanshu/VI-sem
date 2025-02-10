class car:
    
    def __init__(self, brand, model, color, rno, year):
        self.brand=brand
        self.model=model
        self.color=color
        self.registrationNum=rno
        self.make=year
    
    def details(self):
        print(f"Car is {self.make} {self.brand} {self.color} {self.model} registered {self.registrationNum}")
        
car1=car("mercedes","S class","pearl blue", "JH15AZ0010",2030)

car2=car("BMW","7 series M competition","black","JH15AZ0011",2031)

car3=car("Porsche","Cayenne","Red","JH15AZ0001",2029)


car1.details()
car2.details()
car3.details()


