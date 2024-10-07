### CDL Kata Checkout - Console Application

#### Overview
The **CDL Kata Checkout System** is a simple Java-based console application built using **Spring Boot** and **Gradle** that simulates a checkout process in a supermarket. 
The system allows users to scan items, define custom pricing rules, view current pricing, and calculate a running total for items in the cart. This application provides flexibility for items and pricing to be frequently updated and supports the concept of multi-buy offers (e.g., 3 items of 'A' for a discounted price).

#### Features
- **Scan an Item**: Add an item to the cart and calculate the running total.
- **View Current Pricing**: Display the current pricing rules for available Stock Keeping Units (SKUs).
- **Define New Pricing**: Modify or define new pricing rules for the available SKUs.
- **Get Final Total**: Retrieve the final total price for all scanned items and clear the checkout.
- **Exit**: Exit the application gracefully.

#### Application Flow
When the application starts, the user is prompted to choose from several options:

1. **Scan an Item (`S`)**:
    - The user is prompted to select an item from the available SKUs to add to the cart.
    - The application will display a running total after each item is scanned using the `CheckoutService`.

2. **View Current Pricing (`V`)**:
    - The user can view the current pricing rules for all available SKUs, including unit prices and any applicable multi-buy discounts.

3. **Define New Pricing (`D`)**:
    - The user can modify existing pricing or define new pricing rules for the SKUs using the `ItemService`. This feature allows for dynamic changes to the pricing scheme.

4. **Get Final Total (`G`)**:
    - The user can request the final total for all scanned items. Once the total is displayed, the checkout is cleared, allowing for a fresh transaction.

5. **Exit (`E`)**:
    - The application exits, clearing any ongoing transactions.

#### Usage Instructions

1. **Run the Application**:
   - you can run the `main()` method in the `CdlKataConsoleServiceApplication` class:
      ```bash
      java -jar build/libs/cdl-kata-console-service.jar
      ```

2. **Application Interface**:
   Upon starting, you will be presented with the following menu options:
   ```
   Welcome to the CDL Kata Checkout System 
   Enter an option to Proceed:
   (S)can an item 
   (V)iew current Pricing 
   (D)efine New Pricing 
   (G)et final Total 
   (E)xit to close
   ```

3. **Scanning Items**:
    - To scan an item, select the `S` option and choose an item from the available SKUs.
    - The system will display the running total after each scanned item.

4. **Viewing Pricing**:
    - Select the `V` option to display the current pricing structure for all SKUs, including unit prices and any multi-buy offers.

5. **Defining New Pricing**:
    - Select the `D` option to enter new pricing rules or modify existing ones. You will be prompted to enter the SKU, unit price, and any special multi-buy offers.

6. **Getting the Final Total**:
    - Select the `G` option to calculate the total for the current transaction. After displaying the total, the checkout is reset for a new transaction.

7. **Exiting the Application**:
    - Select the `E` option to exit the application. All ongoing transactions will be cleared.

#### Example Use Case
Here’s an example of how the CDL Kata Checkout System could be used:

1. Start the application:
   ```
   Welcome to the CDL Kata Checkout System 
   Enter an option to Proceed:
   (S)can an item 
   (V)iew current Pricing 
   (D)efine New Pricing 
   (G)et final Total 
   (E)xit to close
   ```

2. Scan an item:
   ```
   Option entered S
   Enter an item to scan:
   A
   Running total after adding item A: £0.50
   ```

3. Add more items:
   ```
   Option entered S
   Enter an item to scan:
   A
   Running total after adding item A: £1.00
   
   Option entered S
   Enter an item to scan:
   A
   Running total after adding item A: £1.30 (3 for 130 pence)
   ```

4. Get the final total:
   ```
   Option entered G
   Final total: 130 pence, £1.30
   ```

5. Exit the system:
   ```
   Option entered E
   End the checkout
   ```

#### Technical Details

- **CheckoutService**:
  Handles scanning items, applying pricing rules, and maintaining a running total.

- **ItemService**:
  Manages pricing rules and available SKUs, allowing for dynamic modification of item prices.

- **CommandLineRunner**:
  The main entry point of the application, providing a console-based interface for interacting with the checkout system.

#### Requirements
- **Java 8+**
- **Gradle**
- **Spring Boot 3.x**
