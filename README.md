Hello, World. Welcome to my Lucky Ledger program, every accountant's dream application. 
My program allows users to track all business and personal transactions with ease.
Multiple menu options give you the freedom to personalize and organize your ledger to your liking while also displaying your transactions in a clean and readable manner.
-
![Screenshot 2025-05-02 093141](https://github.com/user-attachments/assets/2dd5f5f1-0d11-4b99-ba01-a1c64573c0c8)
![Screenshot 2025-05-02 093049](https://github.com/user-attachments/assets/65f4e141-857a-4062-9023-b6ad9dd8cbf8)
![Screenshot 2025-05-02 092952](https://github.com/user-attachments/assets/137e054e-9266-4690-9d4d-d840646df58a)

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
I found this piece of code interesting because while seemingly simple andboring, it was one of the most crucial parts of my program. This chunk of code is responsible for writing lines of string onto the "transactions.csv" file. It took a little bit of time to work out the kinks and make it as efficient as possible, but I am proud of the way it turned out.
-
