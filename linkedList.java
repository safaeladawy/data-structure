import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.util.*;

public class linkedList { 
   node head = null;


   
   // Method 1 Load Path
   public void loadPath(String path) throws IOException, ParseException, java.text.ParseException, Exception{

      JSONParser jsonParser = new JSONParser();
      Object Obj = jsonParser.parse(new FileReader(path)); // ".\\.vscode\\medicine.json"
      JSONObject jsonObj = (JSONObject) Obj;

      JSONArray med = (JSONArray) jsonObj.get("med");
      int size = med.size();

      node temp = head;
      boolean flag = false;
      for (int j = 0; j < size; j++) {
         Medicine drug = new Medicine();

         JSONObject address = (JSONObject) med.get(j);
         drug.name = (String) address.get("name");
         drug.id = (Long) address.get("id");
         drug.price = (Long) address.get("price");
         drug.quantity = (Long) address.get("quantity");
         drug.type = (String) address.get("type");
         drug.manf = (String) address.get("Manufacture");
         String date = (String) address.get("expDate");
         drug.exDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

         for (int i = 0; i < date.length(); i++) {
            if (i == 3 || i == 4) {
               drug.month += (date.charAt(i) - '0');
            } else if (i > 5) {
               drug.year += (date.charAt(i) - '0');
            }
         }

         node n = new node(drug);
         if (flag == false) {
            head = n;
            temp = head;
            flag = true;
         } else if (flag == true) {
            temp.next = n;
            temp = temp.next;
         }
      }
   }

   // Method 2 Print All
   public void printAll() {
      node temp = head;
      while (temp != null) {
         System.out.println("Medicine name: " + temp.drug.name);
         System.out.println("Medicine id: " + temp.drug.id);
         System.out.println("Medicine quantity: " + temp.drug.quantity);
         System.out.println("Medicine price: " + temp.drug.price);
         System.out.println("Medicine type: " + temp.drug.type);
         System.out.println("Medicine manufacture date: " + temp.drug.manf);
         System.out.println("Medicine expire date: " + temp.drug.exDate + "\n");
         System.out.println();
         temp = temp.next;
      }
   }

   // Method 3 Print Medicine Data
   public void printMedicineData(String mydrug) {
      node temp = head;
      while (temp != null && !mydrug.equals(temp.drug.name)) {
         temp = temp.next;
      }
      if (temp != null) {
         System.out.println("Medicine name: " + temp.drug.name);
         System.out.println("Medicine id: " + temp.drug.id);
         System.out.println("Medicine quantity: " + temp.drug.quantity);
         System.out.println("Medicine price: " + temp.drug.price);
         System.out.println("Medicine type: " + temp.drug.type);
         System.out.println("Medicine manufacture date: " + temp.drug.manf);
         System.out.println("Medicine expire date: " + temp.drug.exDate + "\n");
      } else {
         System.out.println("This Medicine is not avaliable");
      }
   }

   // Method 4 Update
   public boolean update() {
      if (head == null) {
         System.out.println("Nothing to update");
         return false;
      }

      node temp = head;
      System.out.println("which is medicin you want to update? (Enter the name of medicine)");
      Scanner myObj = new Scanner(System.in);
      String name = myObj.next();
      myObj.close();
      while (temp != null && temp.drug.name != name) {
         temp = temp.next;
      }
      if (temp != null) {
         System.out.println("Enter the new id: ");
         Long previd = temp.drug.id;
         temp.drug.id = myObj.nextLong();
         System.out.println("id of medicine updated from  " + previd + " to " + temp.drug.id);
         System.out.println("Enter the new price: ");
         Long prevprice = temp.drug.price;
         temp.drug.price = myObj.nextLong();
         System.out.println("id of medicine updated from  " + prevprice + " to " + temp.drug.price);
         System.out.println("Enter the new quantity: ");
         Long prevQ = temp.drug.quantity;
         temp.drug.quantity = myObj.nextLong();
         System.out.println("id of medicine updated from  " + prevQ + " to " + temp.drug.quantity);
         return true;
      }
      return false;
   }

   // Method 5 Delete
   public boolean deleteMedicine(String nameMed) {
      if (head != null) {
         if (head.drug.name.equals(nameMed)) {
            head = head.next;
            return true;
         }
         node temp = head;
         while (temp.next != null && !temp.next.drug.name.equals(nameMed)) {
            temp = temp.next;
         }
         if (temp.next != null) {
            temp.next = temp.next.next;
            return true;
         }
      }
      return false;
   }

   // Method 6 Add
   public boolean addNewMedicine() throws java.text.ParseException {
      Scanner myObj = new Scanner(System.in);
      Medicine Mydrug = new Medicine();
      System.out.println("Enter your new medicine name: ");
      Mydrug.name = myObj.nextLine();
      System.out.println("Enter your new medicine type: ");
      Mydrug.type = myObj.nextLine();
      System.out.println("Enter your new medicine manufacture: ");
      Mydrug.manf = myObj.nextLine();
      System.out.println("Enter your new medicine expire date: ");
      Mydrug.exDate = new SimpleDateFormat("dd/M/yyyy").parse(myObj.nextLine());
      System.out.println("Enter your new medicine id: ");
      Mydrug.id = myObj.nextLong();
      System.out.println("Enter your new medicine price: ");
      Mydrug.price = myObj.nextLong();
      System.out.println("Enter your new medicine quantity: ");
      Mydrug.quantity = myObj.nextLong();
      myObj.close();
      boolean retval = false;
      node Node = new node(Mydrug);
      if (Node != null) {
         if (head == null) { // No List
            head = Node;
         } 
         else { // there is a list
            node temp = head;
            while (temp.next != null) {
               temp = temp.next;
            }
            temp.next = Node;
         }
         retval = true;
      }
      return retval;
   }

   // Method 7 Sort by Price
   public void sortListPrice(String order) {
      node current = head, index = null;
      Medicine temp;
      switch (order) {
         case "ascending":
         case "Ascending":

            if (head == null) {
               return;
            } else {
               while (current != null) {
                  index = current.next;

                  while (index != null) {
                     if (current.drug.price > index.drug.price) {
                        temp = current.drug;
                        current.drug = index.drug;
                        index.drug = temp;
                     }
                     index = index.next;
                  }
                  current = current.next;
               }
            }
            break;

         case "descending":
         case "Descending":
            if (head == null) {
               return;
            } else {
               while (current != null) {
                  index = current.next;

                  while (index != null) {
                     if (current.drug.price < index.drug.price) {
                        temp = current.drug;
                        current.drug = index.drug;
                        index.drug = temp;
                     }
                     index = index.next;
                  }
                  current = current.next;
               }
            }
            break;

         default:
            System.out.println("You entered wrog order! Kindly choose (ascending - descending)");
      }
   }

   // Method 8 Sort by Quantity
   public void sortListQuantity(String order) {
      node current = head, index = null;
      Medicine temp;
      switch (order) {
         case "ascending":
         case "Ascending":

            if (head == null) {
               return;
            } else {
               while (current != null) {
                  index = current.next;

                  while (index != null) {
                     if (current.drug.quantity > index.drug.quantity) {
                        temp = current.drug;
                        current.drug = index.drug;
                        index.drug = temp;
                     }
                     index = index.next;
                  }
                  current = current.next;
               }
            }
            break;

         case "descending":
         case "Descending":
            if (head == null) {
               return;
            } else {
               while (current != null) {
                  index = current.next;

                  while (index != null) {
                     if (current.drug.quantity < index.drug.quantity) {
                        temp = current.drug;
                        current.drug = index.drug;
                        index.drug = temp;
                     }
                     index = index.next;
                  }
                  current = current.next;
               }
            }
            break;

         default:
            System.out.println("You entered wrog order! Kindly choose (ascending - descending)");
      }
   }

   // Method 9 Sort by Expire date
   public void sortListExpDate(String order) {
      node current = head, index = null;
      Medicine temp;
      switch (order) {
         case "ascending":
         case "Ascending":

            if (head == null) {
               return;
            } else {
               while (current != null) {
                  index = current.next;

                  while (index != null) {
                     if (current.drug.exDate.after(index.drug.exDate)) {
                        temp = current.drug;
                        current.drug = index.drug;
                        index.drug = temp;
                     }
                     index = index.next;
                  }
                  current = current.next;
               }
            }
            break;

         case "descending":
         case "Descending":
            if (head == null) {
               return;
            } else {
               while (current != null) {
                  index = current.next;
                  while (index != null) {
                     if (current.drug.exDate.before(index.drug.exDate)) {
                        temp = current.drug;
                        current.drug = index.drug;
                        index.drug = temp;
                     }
                     index = index.next;
                  }
                  current = current.next;
               }
            }
            break;

         default:
            System.out.println("You entered wrog order! Kindly choose (ascending - descending)");
      }
   }

   // Method 10 Expire At Date
   public void expireAtDate(String y, String m) {
      node temp = head;
      while (temp != null) {
         if ((temp.drug.year.equals(y)) && (temp.drug.month.equals(m))) {
            System.out.println("Medicin Name: " + temp.drug.name);
            break;
         }
         temp = temp.next;
      }
   }

   // Method 11 Save Data
   public void SaveData(String path) throws IOException {
      FileWriter write = new FileWriter(".\\.vscode\\medicine.json");
      PrintWriter print_line = new PrintWriter(write);
      print_line.println("{ \n \"med\": \n[");
      node temp = head;
      while (temp != null) {
         Medicine m1 = temp.drug;
         String date1 = new SimpleDateFormat("dd/MM/yyyy").format(m1.exDate);
         if (temp.next == null) {
            print_line.println("{ \"name\": " + "\"" + m1.name + "\"" + ", " + "\"id\": " + m1.id + ", "
                  + "\"quantity\": " + m1.quantity + ", " + "\"price\": " + m1.price + ", " + "\"type\": " + "\""
                  + m1.type + "\"" + ", " + "\"Manufacture\": " + "\"" + m1.manf + "\"" + ", " + "\"expDate\": " + "\""
                  + date1 + "\"}");
            break;
         }
         print_line.println("{ \"name\": " + "\"" + m1.name + "\"" + ", " + "\"id\": " + m1.id + ", " + "\"quantity\": "
               + m1.quantity + ", " + "\"price\": " + m1.price + ", " + "\"type\": " + "\"" + m1.type + "\"" + ", "
               + "\"Manufacture\": " + "\"" + m1.manf + "\"" + ", " + "\"expDate\": " + "\"" + date1 + "\"},");
         temp = temp.next;
      }
      print_line.println("]\n}");
      print_line.close();
   }

   // Method 12 Sell Medicin
   public void sellMedicin(String medName, Long quantity) {
      node temp = head;
      while ((!temp.drug.name.equals(medName)) && (temp != null)) {
         temp = temp.next;
      }
      if (temp != null) {
         temp.drug.quantity -= quantity;
         System.out.println("New medicine quantity is: " + temp.drug.quantity);
         return;
      }
      System.out.println("Medicin not found!");
   }

   // Method 13 Exit
   public void exit() throws IOException {
      System.out.println("You Exit from System");
      SaveData(".\\.vscode\\medicine.json");
      System.exit(0);
   }
}
