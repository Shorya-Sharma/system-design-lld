# Parking Lot System - Low Level Design (LLD)

## 1. System Overview

The Parking Lot System is a comprehensive solution for managing vehicle parking operations including entry, exit, payment processing, and cost computation. The system supports multiple vehicle types (Two-Wheeler, Four-Wheeler) with different parking strategies and payment methods.

## 2. Core Requirements

### Functional Requirements
- **Vehicle Entry**: Generate tickets and assign parking spots
- **Vehicle Exit**: Process payments and release parking spots
- **Multiple Vehicle Types**: Support for Two-Wheeler and Four-Wheeler vehicles
- **Payment Processing**: Support for Cash and UPI payment methods
- **Cost Computation**: Different pricing strategies for different vehicle types
- **Parking Strategy**: Different spot allocation strategies (Near Entrance, Near Exit)

### Non-Functional Requirements
- **Scalability**: Support for multiple parking spots
- **Extensibility**: Easy to add new vehicle types and payment methods
- **Maintainability**: Clean separation of concerns using design patterns
- **Thread Safety**: Support for concurrent operations

## 3. Design Patterns Used

### 1. Factory Pattern
- **ParkingManagerFactory**: Creates appropriate parking managers based on vehicle type
- **CostComputationStrategyFactory**: Creates cost computation strategies

### 2. Strategy Pattern
- **ParkingStrategy**: Different strategies for finding available spots
- **PaymentStrategy**: Different payment methods (Cash, UPI)
- **CostComputationStrategy**: Different pricing algorithms

### 3. Template Method Pattern
- **ParkingSpot**: Abstract class with common parking logic

### 4. Singleton Pattern
- **ParkingManagerFactory**: Singleton instances for each vehicle type

## 4. Class Diagram

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   Vehicle       │    │   VehicleType    │    │   ParkingSpot   │
├─────────────────┤    ├──────────────────┤    ├─────────────────┤
│ -licensePlate   │    │ TWO_WHEELER      │    │ #spotId         │
│ -vehicleType    │    │ FOUR_WHEELER     │    │ #isEmpty        │
├─────────────────┤    └──────────────────┘    │ #vehicle        │
│ +getLicensePlate│                            ├─────────────────┤
│ +getType()      │                            │ +parkVehicle()  │
└─────────────────┘                            │ +unParkVehicle()│
                                               │ +isOccupied()   │
                                               │ +getPrice()     │
                                               │ +getSpotType()  │
                                               └─────────────────┘
                                                        │
                                                        │
                    ┌─────────────────┐    ┌─────────────────┐
                    │TwoWheelerParking│    │FourWheelerParking│
                    │     Spot        │    │     Spot        │
                    ├─────────────────┤    ├─────────────────┤
                    │ +getPrice()     │    │ +getPrice()     │
                    │ +getSpotType()  │    │ +getSpotType()  │
                    │ #canParkVehicle()│   │ #canParkVehicle()│
                    └─────────────────┘    └─────────────────┘

┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│ ParkingManager  │    │ ParkingStrategy  │    │   Ticket        │
├─────────────────┤    ├──────────────────┤    ├─────────────────┤
│ #parkingSpots   │    │ +findAvailableSpot│   │ -ticketId       │
│ #parkingStrategy│    └──────────────────┘    │ -vehicle        │
├─────────────────┤                            │ -entryTime      │
│ +parkVehicle()  │    ┌─────────────────┐    │ -exitTime       │
│ +unParkVehicle()│    │NearEntranceParking│   │ -parkingSpot    │
│ +findSpotByVehicle│  ├─────────────────┤    ├─────────────────┤
│ +getOccupiedSpots│   │ +findAvailableSpot│  │ +getTicketId()  │
│ +getAvailableSpots│  └─────────────────┘    │ +getVehicle()   │
│ +addParkingSpot()│                           │ +getEntryTime() │
│ +removeParkingSpot│                          │ +getExitTime()  │
│ +clearParkingLot()│                          │ +setExitTime()  │
└─────────────────┘                           │ +getParkingSpot()│
        │                                     └─────────────────┘
        │
        │
┌─────────────────┐    ┌─────────────────┐
│TwoWheelerParking│    │FourWheelerParking│
│    Manager      │    │    Manager      │
├─────────────────┤    ├─────────────────┤
│                 │    │                 │
└─────────────────┘    └─────────────────┘

┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│  EntranceGate   │    │   ExitGate       │    │ PaymentStrategy │
├─────────────────┤    ├──────────────────┤    ├─────────────────┤
│ -ticketCounter  │    │                  │    │ +pay(amount)    │
├─────────────────┤    ├──────────────────┤    └──────────────────┘
│ +bookSpot()     │    │ +computeParkingPrice()│
│ -generateTicket()│   │ +unPark()        │    ┌─────────────────┐
└─────────────────┘    └──────────────────┘    │   CashPayment   │
                                               ├─────────────────┤
                                               │ +pay(amount)    │
                                               └─────────────────┘
                                               │
                                               ┌─────────────────┐
                                               │   UpiPayment    │
                                               ├─────────────────┤
                                               │ -upiId          │
                                               │ +pay(amount)    │
                                               └─────────────────┘

┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│CostComputation  │    │TwoWheelerCost   │    │FourWheelerCost  │
│   Strategy      │    │ Computation     │    │ Computation     │
├─────────────────┤    ├──────────────────┤    ├─────────────────┤
│ +computeCost()  │    │ +computeCost()   │    │ +computeCost()  │
└─────────────────┘    └──────────────────┘    └─────────────────┘
```

## 5. Detailed Class Analysis

### 5.1 Core Entities

#### Vehicle
- **Purpose**: Represents a vehicle entering the parking lot
- **Attributes**: licensePlate, vehicleType
- **Responsibilities**: Encapsulate vehicle information

#### VehicleType (Enum)
- **Values**: TWO_WHEELER, FOUR_WHEELER
- **Purpose**: Define supported vehicle types

#### ParkingSpot (Abstract)
- **Purpose**: Represents a parking spot in the lot
- **Key Methods**:
  - `parkVehicle(Vehicle)`: Park a vehicle in the spot
  - `unParkVehicle()`: Remove vehicle from spot
  - `isOccupied()`: Check if spot is occupied
  - `canParkVehicle(Vehicle)`: Abstract method for vehicle compatibility

#### Ticket
- **Purpose**: Represents a parking ticket with entry/exit information
- **Attributes**: ticketId, vehicle, entryTime, exitTime, parkingSpot
- **Responsibilities**: Track parking session details

### 5.2 Management Classes

#### ParkingManager (Abstract)
- **Purpose**: Manages parking operations for a specific vehicle type
- **Key Methods**:
  - `parkVehicle(Vehicle)`: Park a vehicle using strategy
  - `unParkVehicle(String)`: Unpark vehicle by license plate
  - `findSpotByVehicle(String)`: Find spot containing specific vehicle
  - `getAvailableSpots()`: Get list of available spots
  - `getOccupiedSpots()`: Get list of occupied spots

#### ParkingManagerFactory
- **Purpose**: Factory for creating parking managers
- **Pattern**: Factory + Singleton
- **Methods**:
  - `getParkingManager(VehicleType)`: Get appropriate manager

### 5.3 Strategy Classes

#### ParkingStrategy
- **Purpose**: Define strategy for finding available parking spots
- **Implementations**:
  - `NearEntranceParking`: Prefer spots near entrance
  - `NearExitParking`: Prefer spots near exit

#### PaymentStrategy
- **Purpose**: Define payment processing interface
- **Implementations**:
  - `CashPayment`: Cash payment processing
  - `UpiPayment`: UPI payment processing

#### CostComputationStrategy
- **Purpose**: Define cost computation algorithms
- **Implementations**:
  - `TwoWheelerCostComputation`: Pricing for two-wheelers
  - `FourWheelerCostComputation`: Pricing for four-wheelers

### 5.4 Gate Classes

#### EntranceGate
- **Purpose**: Handle vehicle entry process
- **Key Methods**:
  - `bookSpot(Vehicle)`: Generate ticket and assign spot
  - `generateTicket(Vehicle, ParkingSpot)`: Create ticket

#### ExitGate
- **Purpose**: Handle vehicle exit process
- **Key Methods**:
  - `computeParkingPrice(Ticket)`: Calculate parking cost
  - `unPark(Ticket, PaymentStrategy)`: Process exit and payment

## 6. Sequence Diagrams

### 6.1 Vehicle Entry Flow

```
Vehicle → EntranceGate → ParkingManagerFactory → ParkingManager → ParkingStrategy → ParkingSpot → Ticket
```

1. Vehicle arrives at entrance
2. EntranceGate calls ParkingManagerFactory
3. Factory returns appropriate ParkingManager
4. ParkingManager uses ParkingStrategy to find spot
5. Vehicle is parked in selected spot
6. Ticket is generated with entry details

### 6.2 Vehicle Exit Flow

```
Ticket → ExitGate → CostComputationStrategy → PaymentStrategy → ParkingSpot
```

1. Vehicle presents ticket at exit
2. ExitGate computes parking cost using strategy
3. Payment is processed using selected method
4. Vehicle is unparked from spot
5. Exit is completed

## 7. Key Design Decisions

### 7.1 Separation of Concerns
- **Parking Logic**: Separated into ParkingManager and ParkingSpot
- **Payment Logic**: Isolated in PaymentStrategy implementations
- **Cost Computation**: Independent CostComputationStrategy classes
- **Entry/Exit Logic**: Separate gate classes

### 7.2 Extensibility
- **New Vehicle Types**: Add to VehicleType enum and create corresponding managers/spots
- **New Payment Methods**: Implement PaymentStrategy interface
- **New Pricing Models**: Implement CostComputationStrategy interface
- **New Parking Strategies**: Implement ParkingStrategy interface

### 7.3 Thread Safety
- **Atomic Ticket Counter**: Thread-safe ticket ID generation
- **Synchronized Factory Methods**: Thread-safe manager creation
- **Immutable Vehicle**: Thread-safe vehicle representation

## 8. Error Handling

### 8.1 Common Scenarios
- **No Available Spots**: Return null ticket
- **Payment Failure**: Prevent vehicle exit
- **Invalid Vehicle Type**: Throw IllegalArgumentException
- **Spot Already Occupied**: Return false for parking attempt

### 8.2 Validation
- **Vehicle Validation**: Ensure valid license plate and vehicle type
- **Ticket Validation**: Verify ticket exists and is valid
- **Payment Validation**: Ensure payment amount is positive

## 9. Performance Considerations

### 9.1 Time Complexity
- **Finding Available Spot**: O(n) where n is number of spots
- **Finding Vehicle**: O(n) linear search
- **Parking/Unparking**: O(1) constant time

### 9.2 Space Complexity
- **Parking Spots**: O(n) where n is number of spots
- **Tickets**: O(m) where m is number of active tickets
- **Vehicle Tracking**: O(n) for vehicle-to-spot mapping

## 10. Testing Strategy

### 10.1 Unit Tests
- **ParkingSpot**: Test parking/unparking operations
- **ParkingManager**: Test spot management and vehicle operations
- **PaymentStrategy**: Test payment processing
- **CostComputationStrategy**: Test pricing calculations

### 10.2 Integration Tests
- **Entry Flow**: Test complete entry process
- **Exit Flow**: Test complete exit process
- **Payment Integration**: Test payment with cost computation

### 10.3 Edge Cases
- **Full Parking Lot**: Test behavior when no spots available
- **Invalid Payments**: Test payment failure scenarios
- **Concurrent Operations**: Test thread safety

## 11. Future Enhancements

### 11.1 Additional Features
- **Reservation System**: Pre-book parking spots
- **Multiple Parking Lots**: Support for multiple locations
- **Discount System**: Implement various discount strategies
- **Notification System**: SMS/Email notifications

### 11.2 Technical Improvements
- **Database Integration**: Persistent storage for tickets and spots
- **REST API**: Web service interface
- **Real-time Monitoring**: Live parking lot status
- **Analytics**: Parking usage statistics

## 12. Conclusion

The Parking Lot System demonstrates effective use of multiple design patterns to create a flexible, extensible, and maintainable solution. The separation of concerns, strategy pattern implementation, and factory pattern usage make the system robust and easy to extend with new features.

The system successfully handles the core parking operations while providing clear interfaces for future enhancements. The design prioritizes code reusability, maintainability, and scalability while ensuring thread safety and proper error handling. 