<h1 align="center">💰 The Lucky Ledger 💰</h1>  

Welcome to **The Lucky Ledger** — every accountant's dream application!
This Java-based CLI app allows users to securely log in and track personal or business transactions.
With built-in reporting, CSV persistence, and clean organization, you’ll never lose track of your ledger again.

---

## 📦 Features

- **🔐 User Login System**
  
- Secure login using credentials stored in `users.csv`
- Only see and interact with your own data

- **📥 Add Deposit**
  
- Add income/positive transactions

- **💸 Make Payment**
  
- Record expenses (automatically saved as negative amounts)

- **📂 Ledger View**
  
- View All Transactions
- Filter by Deposits or Payments
- Generate Reports (by time or vendor)

- **📊 Reports**
  
- Month-to-Date
- Previous Month
- Year-to-Date
- Previous Year
- Search by Vendor

- **💾 Persistent Storage**
  
- All transactions saved in `transactions.csv`
- Transactions are user-specific

---

## 📋 How to Use

### 🏁 Launch the App

Run the main program:
```bash
java Main
```

### 🔐 Login Prompt

Users must log in before accessing the ledger.
```text
Username: alice
Password: 1234
Login successful.
```

Credentials are stored in `users.csv`:
```
username,password
alice,1234
bob,passw0rd
```

---

### 📜 Main Menu

```text
== HOME ==
D) Add Deposit
P) Make Payment
L) Ledger
X) Exit
Select:
```

### 💰 Adding a Transaction
```text
Select: D
Description: Paycheck
Vendor: ACME Corp
Amount: 2500.00
Transaction recorded.
```

> Payments are stored as **negative** amounts automatically.

---

### 📂 Viewing the Ledger

```text
== LEDGER ==
A) Show Transactions
D) Deposits
P) Payments
R) Reports
H) Home
```

---

### 📊 Reports Menu

```text
== REPORTS ==
1) Month to Date
2) Previous Month
3) Year to Date
4) Previous Year
5) Search by Vendor
0) Back
```

---

## 🗃 Data Files

### `users.csv`
Stores registered usernames and passwords.
```
username,password
alice,1234
bob,passw0rd
```

### `transactions.csv`
All user transactions:
```
username|date|time|description|vendor|amount
nat|2025-05-05|14:33:21|Paycheck|ACME Corp|2500.00
```

---

## 🧱 Code Highlights

### User Login
```java
public static String login(Map<String, String> users) {
Scanner scanner = new Scanner(System.in);
System.out.print("Username: ");
String username = scanner.nextLine();
System.out.print("Password: ");
String password = scanner.nextLine();

if (users.containsKey(username) && users.get(username).equals(password)) {
System.out.println("Login successful.");
return username;
} else {
System.out.println("Invalid login. Try again.");
return null;
}
}
```

### Transaction Parser
```java
public static Transaction fromCSV(String line) {
String[] parts = line.split("\|");
return new Transaction(
LocalDate.parse(parts[0].trim()),
LocalTime.parse(parts[1].trim()),
parts[2].trim(),
parts[3].trim(),
Double.parseDouble(parts[4].trim()),
parts[5].trim()
);
}
```

---

## 🧪 Sample Output

```text
== LEDGER ==
user|date|time|description|vendor|amount
nat | 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50
nat | 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00
```

---


---

## 🧭 Main Menu Structure

The application starts with a dynamic main menu that adapts based on whether the user is logged in or not.

### 🟢 Not Logged In

When the user first launches the app:

```
== HOME ==
R) Register
I) Login
X) Exit
Select:
```

- **R** – Register a new user (saved to `users.csv`)
- **I** – Log in with username/password
- **X** – Exit the application

---

### 🔐 Logged In

Once authenticated, the menu expands:

```
== HOME ==
D) Add Deposit
P) Make Payment
L) Ledger
O) Logout
X) Exit
Select:
```

- **D** – Add a deposit transaction (saved with current user's name)
- **P** – Add a payment (saved as negative amount)
- **L** – Open the Ledger Menu to view or filter transactions
- **O** – Log out the current user
- **X** – Exit the program

---


## 🧑‍💻 Contributors

- **Bemnet** – User authentication, user credential loading, login system
- **Fardosa** – Transaction parser, CSV file integration, deposit/payment logic
- **Marcon** – Report generation features (Month-to-date, YTD, vendor filtering)
- **Nat** – Ledger view filters (All, Deposits, Payments) and menu handling
- **Milly** – Persistent storage, transaction writing and formatting

---

## ✅ TODOs (Optional Enhancements)

- [ ] Password hashing
- [ ] Admin user role
- [ ] Export reports to PDF/Excel
- [ ] GUI interface (JavaFX or Swing)
- [ ] Encrypted transaction file

---

## 📜 License

This project is for educational use and not licensed for commercial deployment.

---

> *"Simple systems make powerful tools. The Lucky Ledger turns string parsing and CSVs into a clean, multi-user ledger app."*

