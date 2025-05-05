<h1 align="center">💰 The Lucky Ledger 💰</h1>  

Welcome to the Lucky Ledger, every accountant's dream application. My program allows users to track all business and personal transactions with ease. Multiple menu options give you the freedom to personalize and organize your ledger to your liking while also displaying your transactions in a clean and readable manner.


<h2>📦 Features</h2>    

* 📥 Add Deposit: Add positive amount transactions.

* 💸 Make Payment: Record payments as negative transactions.

* 📂 Ledger View:

    * View All Transactions

    * Filter by Deposits or Payments

    * Generate Reports based on time periods or vendor

* 💾 Persistent Storage: All data is saved to and read from transactions.csv.

* 📊 Reports:

    * Month-to-date

    * Previous month

    * Year-to-date

    * Previous year

    * Vendor-specific

* 📋 How to Use
  
Upon launching the application, you'll see a main menu:

```java
== HOME ==
D) Add Deposit
P) Make Payment
L) Ledger
X) Exit
Select:
```
<h2> Adding Transactions</h2>    

* Choose D for Deposit or P for Payment

* You'll be prompted to enter:

    * Description

    * Vendor

    * Amount

* 💡 Payments are automatically saved as negative amounts.

<h2> Viewing the Ledger</h2>  

* Select L to access:
```java
== LEDGER ==
A) All
D) Deposits
P) Payments
R) Reports
H) Home
```
![Screenshot 2025-05-02 093049](https://github.com/user-attachments/assets/65f4e141-857a-4062-9023-b6ad9dd8cbf8)

<h2> Reports Menu </h2>  

``` java
== REPORTS ==
1) Month to Date
2) Previous Month
3) Year to Date
4) Previous Year
5) Search by Vendor
0) Back
```
* Choose options to view filtered transaction lists.

  <img width="659" alt="image" src="https://github.com/user-attachments/assets/1c2db057-055d-4252-a1c3-64e68955be00" />


* 🧪 Sample Output
  
```java

== HOME ==
D) Add Deposit
P) Make Payment
L) Ledger
X) Exit
Select: D
Description: Paycheck
Vendor: ACME Corp
Amount: 2500.00
Transaction recorded.
```
```java
== LEDGER ==
A) All
D) Deposits
P) Payments
R) Reports
H) Home
Select: A
2025-05-05 | 14:33:21 | Paycheck | ACME Corp | 2500.00
```

```java
//Parser
    public static Transaction fromCSV(String line) {
        String[] parts = line.split("\\|");
        return new Transaction(
                LocalDate.parse(parts[0].trim()),
                LocalTime.parse(parts[1].trim()),
                parts[2].trim(),
                parts[3].trim(),
                Double.parseDouble(parts[4].trim())
        );
    }
```
* I found this piece of code interesting because while seemingly simple andboring, it was one of the most crucial parts of my program. This chunk of code is responsible for writing lines of string onto the "transactions.csv" file. It took a little bit of time to work out the kinks and make it as efficient as possible, but I am proud of the way it turned out.

