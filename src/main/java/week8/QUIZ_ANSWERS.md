# Week 8 Quiz Answers

## Quiz Questions

### Question 1
**Answer: C - Polymorphism**

The repeated if-else if blocks checking document type before calling render() can be eliminated by using polymorphism. Each document type (PDFDocument, WordDocument) implements its own render() method, and the correct implementation is called automatically based on the actual object type at runtime.

### Question 2
**Answers: A, B, C**

- A Car is a Vehicle ✓ (genuine is-a relationship)
- A Rectangle is a Shape ✓ (genuine is-a relationship)
- A DatabaseConnection is a NetworkResource ✓ (genuine is-a relationship)
- A HelperUtility contains a Calculator ✗ (this is composition/has-a, not is-a)

### Question 3
**Answer: C - Runtime method dispatch**

When calling startEngine() on a Vehicle reference that points to a Car or Motorcycle object, the JVM determines which implementation to call at runtime based on the actual object type, not the reference type. This is dynamic method dispatch.

### Question 4
**Answer: C - Inheritance-based polymorphism**

Storing Circle and Rectangle objects in a Shape list and calling calculateArea() on each demonstrates polymorphism through inheritance - the correct implementation is called based on the actual object type.

### Question 5
**Answers: A, C, D**

- A getLoanPeriod() in Book is an example of extending inherited behavior ✓ (Book adds special rule for new releases)
- B getLoanPeriod() in DVD is an example of shared behavior ✗ (DVD sets a fixed period, doesn't share Book's behavior)
- C The LibraryItem class defines the common behavior for all library items ✓ (base class defines common interface)
- D A DVD object can be processed as a LibraryItem through a common reference ✓ (polymorphism)

### Question 6
**Answers: A, C**

- A If a Dog object is referred to by an Animal reference, calling makeSound() will execute Dog's makeSound() ✓ (runtime polymorphism)
- B The makeSound() method in Animal is an example of specialized behavior ✗ (it's the base/generic behavior)
- C The makeSound() method in Dog is an example of overridden behavior ✓ (Dog provides its own implementation)
- D New behavior can only be added to derived classes if it is also declared in the base class ✗ (derived classes can add new methods not in base class)

### Question 7
**Answer: C - It allows adding WalletPayment without modifying the existing PaymentProcessor's iteration logic**

The open/closed principle: the PaymentProcessor is open for extension (new payment types) but closed for modification (no changes needed to processing logic).

### Question 8
**Answer: A - It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid**

Using inheritance solely for code reuse between unrelated classes creates false is-a relationships, leading to tight coupling, fragile designs, and violation of Liskov Substitution Principle.

### Question 9
**Answers: A, C**

- A It allows a generic NotificationSender to send various types of notifications without knowing their concrete types ✓ (polymorphism)
- B It centralizes all notification logic into a single Notification class ✗ (logic is distributed in derived classes)
- C It simplifies adding a new notification channel like InAppNotification without altering existing sender logic ✓ (open/closed principle)
- D It ensures all notification types use the exact same send() implementation ✗ (each overrides with channel-specific logic)

### Question 10
**Answers: A, B, C**

- A It simplifies iterating over diverse but related objects ✓
- B It allows for uniform processing of objects with specialized behavior ✓
- C It reduces the need for explicit type casting in common processing loops ✓
- D It makes it harder to add new derived types to the system ✗ (it makes it easier)

---

## Concept Questions

### Question 1: Inheritance enabling reuse and extension
Inheritance allows a derived class to inherit fields and methods from a base class (reuse), while also allowing the derived class to override methods or add new ones (extend/modify).

**Business Example:** In a payroll system, `Employee` base class has `calculateSalary()` method. `FullTimeEmployee` inherits this and overrides it to compute monthly salary. `HourlyEmployee` inherits and overrides to compute hourly wage × hours worked. Both reuse the employee ID, name fields, and common methods like `getEmployeeInfo()`, while providing specialized salary calculation.

### Question 2: The 'is-a' relationship
The 'is-a' relationship means a derived class is a specialized version of the base class - every instance of the derived class is also an instance of the base class.

**Why crucial:** If you use inheritance without a genuine is-a relationship, you violate Liskov Substitution Principle. The derived class may not behave correctly when used as the base type, leading to bugs. For example, a `Square` inheriting from `Rectangle` seems like an is-a relationship, but breaks when setting width/height independently (a square can't have different width/height).

### Question 3: Method overriding
Method overriding is when a derived class provides its own implementation of a method already defined in its base class, with the same signature.

**Business Example:** `Employee` base class has `calculatePay()`. `SalariedEmployee` overrides to return fixed monthly salary. `CommissionEmployee` overrides to return base salary + commission percentage. `HourlyEmployee` overrides to return hourly rate × hours worked. The payroll system calls `calculatePay()` on any Employee reference and gets the correct calculation for that employee type.

### Question 4: Runtime polymorphism (dynamic dispatch)
When a method is called on a base-type reference pointing to a derived object, the JVM looks at the actual object type at runtime and invokes that object's method implementation. This is dynamic method dispatch - the method to call is determined at runtime, not compile time.

**How it works:** The JVM maintains a virtual method table (vtable) for each class. When a method is called, the JVM follows the reference to the actual object, checks its class's vtable, and calls the appropriate method implementation.

### Question 5: Polymorphic collections
A polymorphic collection holds references of a common base type, but the actual objects are instances of different derived types.

**Example:** `List<Animal> animals = new ArrayList<>(); animals.add(new Dog()); animals.add(new Cat()); animals.add(new Bird());`

**Advantages:**
- Single loop processes all animals: `for (Animal a : animals) a.makeSound();`
- No type checking or casting needed
- Easy to add new animal types without changing processing code
- Uniform interface for diverse objects

### Question 6: Polymorphism vs conditional logic
**Polymorphism approach:** Each type implements its behavior in its own class. Processing code calls common method on base reference.

**Conditional approach:** Processing code has if-else/switch on type, calling type-specific logic.

**Why polymorphism preferred:**
- Open/closed principle: add new types without modifying existing code
- Single responsibility: each class handles its own behavior
- No type checks scattered throughout code
- Easier testing and maintenance
- Eliminates "switch statements" that grow with each new type

### Question 7: Adding new derived types with minimal changes
Inheritance and polymorphism allow new derived types to work with existing processing code automatically.

**Example:** Payment system has `PaymentProcessor` that processes `List<Payment>`. Adding `WalletPayment` only requires creating the new class extending `Payment` with its `calculateFee()`. The `PaymentProcessor` loop `for (Payment p : payments) p.calculateFee()` works without any changes.

### Question 8: Inherited vs overridden behavior
**Inherited behavior:** Derived class uses base class implementation as-is. Used when the base behavior is appropriate for all derived types.

**Example:** `Employee` has `getEmployeeId()` - all employee types use the same ID retrieval logic, so they inherit it.

**Overridden behavior:** Derived class provides its own implementation. Used when derived type needs specialized behavior.

**Example:** `Employee` has `calculateBonus()`. `Manager` overrides to include team performance. `Developer` overrides to include code quality metrics. `Intern` overrides to return 0.

### Question 9: Inheritance solely for code reuse (no is-a)
Using inheritance just to reuse code between unrelated classes creates:
- **Tight coupling:** Changes to base class affect all derived classes
- **Fragile design:** Base class changes can break derived classes unexpectedly
- **Violation of LSP:** Derived class may not be substitutable for base class
- **Misleading semantics:** Implies a relationship that doesn't exist
- **Inflexibility:** Hard to change inheritance hierarchy later

**Better alternative:** Composition - have a field of the reusable class type and delegate to it.

### Question 10: VehicleRental system analysis
**Common behaviors (in VehicleRental base class):**
- Rental ID, customer info, start/end dates
- `calculateRentalDays()`, `getRentalCost()` (base implementation)
- `getVehicleDetails()`, `isOverdue()`

**Specialized behaviors (in derived classes):**
- `CarRental`: `calculateRentalCost()` includes daily rate + insurance, mileage charges
- `TruckRental`: `calculateRentalCost()` includes daily rate + weight-based fees, commercial license verification
- `MotorcycleRental`: `calculateRentalCost()` includes daily rate + helmet rental, seasonal pricing

**Modeling with inheritance:**
```
VehicleRental (abstract)
  ├── CarRental
  ├── TruckRental
  └── MotorcycleRental
```
Base class defines common fields and abstract `calculateCost()`. Each derived class implements its pricing logic. Rental system processes `List<VehicleRental>` uniformly.