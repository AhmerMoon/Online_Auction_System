# Online Auction System

A Java-based desktop application that simulates an online auction platform with administrative controls, item management, and real-time bidding functionality.

## Features

- **Admin Authentication**: Secure login system for administrators
- **Item Management**: Add, delete, and update auction items with starting prices
- **Bidding System**: Real-time bidding with timer functionality
- **Bidding History**: Track all bids and identify winners
- **File Persistence**: All items are stored in a text file for data persistence
- **GUI Interface**: User-friendly Swing-based graphical interface

## Classes Overview

### Core Classes
- **OnlineAuctionSystem**: Main application class that coordinates all components
- **MenuFrame**: Graphical user interface for the main menu
- **AdminLogin**: Login window for administrator authentication
- **FileHandler**: Handles all file operations for item persistence

### Auction Components
- **AuctionSystem**: Manages the bidding process and timer functionality
- **BiddingHistory**: Tracks and manages bidding history
- **Customer**: Represents a customer with bidding information
- **AuctionTimer**: Handles the timing functionality for auctions

### Utility Classes
- **Menu**: Console-based menu system (alternative to GUI)
- **Admin**: Admin authentication logic

## Installation & Setup

1. **Prerequisites**: Ensure you have Java JDK 8 or later installed
2. **Clone the repository**: 
   ```bash
   git clone <repository-url>
   cd OnlineAuctionSystem
   ```
3. **Compile the project**:
   ```bash
   javac *.java
   ```
4. **Run the application**:
   ```bash
   java OnlineAuctionSystem
   ```

## Usage

1. **Login**: Use the default credentials (username: `admin`, password: `admin123`)
2. **Manage Items**: 
   - Add new items with starting prices
   - Update existing items
   - Remove items from the auction
3. **View Items**: Browse all available items for bidding
4. **Start Bidding**: Select an item to begin the bidding process
5. **Track History**: View complete bidding history for all auctions

## File Structure

```
OnlineAuctionSystem/
├── OnlineAuctionSystem.java  # Main application class
├── MenuFrame.java            # GUI menu interface
├── AdminLogin.java           # Admin authentication window
├── FileHandler.java          # File operations handler
├── AuctionSystem.java        # Bidding system logic
├── BiddingHistory.java       # Bid tracking and management
├── Customer.java             # Customer data model
├── AuctionTimer.java         # Timer functionality
├── Menu.java                 # Console menu alternative
├── Admin.java                # Admin authentication logic
└── Items.txt                 # Data file for auction items
```

## Default Admin Credentials

- Username: `admin`
- Password: `admin123`

## Data Storage

All auction items are stored in `Items.txt` with the format:
```
Item Name,Starting Price
iPhone 13 pro max,200000
Mehran,600000
```

## Bidding Process

1. Users select an item to bid on
2. Bidding remains open for a fixed time period (10 seconds)
3. Users enter their name and bid amount
4. When time expires, the highest bid above the starting price wins
5. Bidding history is preserved for review

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is available for educational purposes. Feel free to modify and extend according to your needs.
