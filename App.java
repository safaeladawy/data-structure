import java.io.IOException;
import org.json.simple.parser.*;
import java.util.*;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        linkedList l = new linkedList();
        l.loadPath(".\\.vscode\\medicine.json");
        //l.printAll();
        //l.sortListPrice("ascend");
        //l.sortListExpDate("ascending");
        //l.sortListQuantity("ascending");
        //l.addNewMedicine();
        //l.sellMedicin("pandadol", 2);
        //l.SaveData(".\\.vscode\\medicine.json");
        //l.expireAtDate("2023","01");
        //l.deleteMedicine("panadol");
        //l.update();
        //l.printMedicineData("panadol");
        //l.exit();
        

        // while(true)
        // {
        //     System.out.println("Welcom to our System");
        //     System.out.println("Choose from main menue: ");
        //     System.out.println("1. Print All Medicine data");
        //     System.out.println("2. Add new Medicine");
        //     System.out.println("3. Update info of Existing Medicine");
        //     System.out.println("4. Delete a Medicine from List");
        //     System.out.println("5. Sort Medicine by Price");
        //     System.out.println("6. Sort Medicine by Expire Date");
        //     System.out.println("7. Sort Medicine by Quantity");
        //     System.out.println("8. Find Medicine expiring at date");
        //     System.out.println("9. Sell Medicine");
        //     System.out.println("10. Print Medicine info");
        //     System.out.println("11. Save Changes");
        //     System.out.println("12. Exit");
        //     Scanner sc = new Scanner(System.in);

        //     switch(sc.nextInt()){
        //         case 1:   {l.printAll();}
        //         case 2:   {l.addNewMedicine();}
        //         case 3:   {l.update();}
        //         case 4:
        //         {
        //             System.out.println("Enter name of Medicine you want to delete: ");
        //             l.deleteMedicine(sc.nextLine());
        //         }    

        //         case 5: 
        //         {
        //             System.out.println("Kindly choose ascending or descending");
        //             l.sortListPrice(sc.nextLine());
        //         }

        //         case 6:
        //         {
        //             System.out.println("Kindly choose ascending or descending");
        //             l.sortListExpDate(sc.nextLine());
        //         }
                
        //         case 7: 
        //         {
        //             System.out.println("Kindly choose ascending or descending");
        //             l.sortListQuantity(sc.nextLine());
        //         }
        //         case 8: 
        //         {
        //             System.out.println("year and month of expiring (in order): ");
        //             l.expireAtDate(sc.nextLine(), sc.nextLine());
        //         }

        //         case 9: 
        //         {
        //             System.out.println("medicine name and quantity you sold (in order): ");
        //             l.sellMedicin(sc.nextLine(), sc.nextLong());
        //         }
        //         case 10:
        //         {
        //             System.out.println("Enter Medicine Name: ");
        //             l.printMedicineData(sc.next());
        //         }

        //         case 11: {l.SaveData(".\\.vscode\\medicine.json");}
        //         case 12:
        //         {
        //             l.exit();
        //             break;
        //         } 

        //         default: {System.out.println("You Entered an invalid input");}

        //         System.out.println("Exit or return to main menue: ");
        //         if (sc.next().equals("Exit"))
        //         {
        //             l.exit();
        //             break;
        //         }
        //     }

        // }
    }
}
