import java.util.*;

class Cowin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Hospital> HosInfo = new ArrayList<>();
        ArrayList<Citizens> CitiInfo = new ArrayList<>();
        ArrayList<Vaccine> VacInfo = new ArrayList<>();
        ArrayList<Slot> slotInfo = new ArrayList<>();

        System.out.println("CoWin Portal initialized....");
        while (true) {

            Menu();

            int opt = sc.nextInt();

            if (opt == 1) {

                addVacc(sc, VacInfo);

            }

            else if (opt == 2) {

                regHos(sc, HosInfo);

            } else if (opt == 3) {

                regCitizen(sc, CitiInfo);

            }

            else if (opt == 4) {

                add_slot(sc, HosInfo, VacInfo, slotInfo);

            }

            else if (opt == 5) {
                System.out.print("Enter patient Unique ID: ");
                long patient_id = sc.nextLong();
                boolean check = false;
                int idx = 0;
                String pName = "";

                for (Citizens i : CitiInfo) {
                    if (i.Unique_ID == patient_id) {
                        pName = i.Person_name;
                        check = true;
                        break;
                    }
                    idx++;

                }

                if (check) {
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter option: ");
                    int option = sc.nextInt();

                    if (option == 1) {
                        by_pin(sc, HosInfo, CitiInfo, VacInfo, slotInfo, idx, pName);

                    }

                    else if (option == 2) {
                        by_vacc(sc, HosInfo, CitiInfo, VacInfo, slotInfo, idx, pName);

                    } else if (option == 3) {
                        continue;
                    }
                }

            }

            else if (opt == 6) {
                list_hos_slots(sc, HosInfo, slotInfo);

            }

            else if (opt == 7) {

                chk_status(sc, CitiInfo, VacInfo);

            }

            else if (opt == 8) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    private static void by_vacc(Scanner sc, ArrayList<Hospital> HosInfo, ArrayList<Citizens> CitiInfo,
            ArrayList<Vaccine> VacInfo, ArrayList<Slot> slotInfo, int idx, String pName) {
        sc.nextLine();
        System.out.print("Enter Vaccine name: ");
        String vname = sc.nextLine();

        for (Slot i : slotInfo) {

            if (i.Vaccine_name.equals(vname)) {
                for (Hospital j : HosInfo) {

                    if (i.Hospital_ID == j.Hospital_ID) {

                        System.out.println(j.Hospital_ID + " " + j.Hospital_name);
                    }

                }

            }
        }
        System.out.print("Enter hospital id: ");
        int Hid = sc.nextInt();

        int count = 0;
        
        for (Slot j : slotInfo) {
            
            if (j.Hospital_ID == Hid && j.Vaccine_name.equals(vname)) {
                System.out.println(count + "-> " + "Day: " + j.day + " Available Qty: " + j.Quantity
                        + " Vaccine: " + j.Vaccine_name);
                count = count + 1;
            }
        }
        if(count==0){
            System.out.println("No slots available");
            return;
        }

        System.out.print("Choose Slot: ");
        int Choose_slot = sc.nextInt();
        int temp = 0;
        for (Slot j : slotInfo) {
            if (j.Hospital_ID == Hid && j.Vaccine_name.equals(vname)) {
                if (temp == Choose_slot) {
                    j.Quantity--;
                    System.out.println(pName + " vaccinated with " + j.Vaccine_name);
                    Vaccine maxVac;
                    for (Vaccine k : VacInfo) {
                        if (k.Vaccine_name == j.Vaccine_name) {
                            maxVac = k;
                            if (k.total_doses > CitiInfo.get(idx).dose_count) {
                                CitiInfo.get(idx).PartialVaccinated(vname);
                                CitiInfo.get(idx).dose_count++;
                            } else if (k.total_doses == CitiInfo.get(idx).dose_count) {
                                CitiInfo.get(idx).FullyVaccinated(vname);
                            }
                        }

                    }

                }
                temp = temp + 1;
            }

        }
    }

    private static void by_pin(Scanner sc, ArrayList<Hospital> HosInfo, ArrayList<Citizens> CitiInfo,
            ArrayList<Vaccine> VacInfo, ArrayList<Slot> slotInfo, int idx, String pName) {
        System.out.print("Enter PinCode: ");
        int Pcode = sc.nextInt();
        for (Hospital i : HosInfo) {
            if (i.Pincode == Pcode) {
                System.out.println(i.Hospital_ID + " " + i.Hospital_name);
            }
        }
        System.out.print("Enter hospital id: ");
        int Hid = sc.nextInt();

        int count = 0;

        for (Slot j : slotInfo) {
            if (j.Hospital_ID == Hid) {
                System.out.println(count + "-> " + "Day: " + j.day + " Available Qty: " + j.Quantity
                        + " Vaccine: " + j.Vaccine_name);
                count = count + 1;
            }
        }
        if(count==0){
            System.out.println("No slots available");
            return;
        }

        System.out.print("Choose Slot: ");
        int Choose_slot = sc.nextInt();
        int temp = 0;
        for (Slot j : slotInfo) {
            if (j.Hospital_ID == Hid) {
                if (temp == Choose_slot) {
                    j.Quantity--;
                    System.out.println(pName + " vaccinated with " + j.Vaccine_name);
                    Vaccine maxVac;
                    CitiInfo.get(idx).dose_count++;
                    for (Vaccine k : VacInfo) {
                        if (k.Vaccine_name == j.Vaccine_name) {
                            maxVac = k;
                            if (k.total_doses > CitiInfo.get(idx).dose_count) {
                                CitiInfo.get(idx).PartialVaccinated(k.Vaccine_name);
                            } else if (k.total_doses == CitiInfo.get(idx).dose_count) {
                                CitiInfo.get(idx).FullyVaccinated(k.Vaccine_name);
                            }
                        }

                    }

                }
                temp = temp + 1;
            }

        }
    }

    private static void chk_status(Scanner sc, ArrayList<Citizens> CitiInfo, ArrayList<Vaccine> VacInfo) {
        System.out.print("Enter patient Unique ID: ");
        long patient_id = sc.nextLong();
        boolean check = false;
        int idx = 0;

        for (Citizens i : CitiInfo) {
            if (i.Unique_ID == patient_id) {
                check = true;
                break;
            }
            idx++;

        }

        for (Vaccine j : VacInfo) {

            if (check) {

                if (CitiInfo.get(idx).dose_count == 0) {

                    System.out.println("Citizen REGISTERED.");
                    break;
                } else if (CitiInfo.get(idx).Pvacc.equals(j.Vaccine_name)) {
                    if (j.total_doses > CitiInfo.get(idx).dose_count) {

                        System.out.println("PARTIALLY VACCINATED");
                        System.out.println("Vaccine Given: " + j.Vaccine_name);
                        System.out.println("Number of Doses given: " + CitiInfo.get(idx).dose_count);
                        System.out.println("Next Dose due date: " + (j.Gap_required+1));

                        break;
                    } else if (j.total_doses <= CitiInfo.get(idx).dose_count) {

                        System.out.println("FULLY VACCINATED");
                        System.out.println("Vaccine Given: " + j.Vaccine_name);
                        System.out.println("Number of Doses given: " + CitiInfo.get(idx).dose_count);
                        break;
                    }

                }

                //CitiInfo.get(idx).dose_count++;
            }

        }
    }

    private static void list_hos_slots(Scanner sc, ArrayList<Hospital> HosInfo, ArrayList<Slot> slotInfo) {
        System.out.print("Enter Hospital ID: ");
        int H_id = sc.nextInt();

        for (Hospital i : HosInfo) {

            if (i.Hospital_ID == H_id) {

                for (Slot j : slotInfo) {
                    if (j.Hospital_ID == H_id) {
                        System.out.println("Day: " + j.day + " Vaccine: " + j.Vaccine_name + " Available Qty: "
                                + j.Quantity);
                    }

                }

            }

        }
    }

    private static void add_slot(Scanner sc, ArrayList<Hospital> HosInfo, ArrayList<Vaccine> VacInfo,
            ArrayList<Slot> slotInfo) {
        System.out.print("Hospital ID: ");
        int InpH_id = sc.nextInt();

        boolean check = false;
        int idx = 0;
        for (Hospital i : HosInfo) {

            if (i.Hospital_ID == InpH_id) {

                check = true;
                break;

            }
            idx++;

        }
        Hospital i = HosInfo.get(idx);
        if (check) {
            System.out.print("Enter number of Slots to be added: ");
            int slot = sc.nextInt();
            while (slot > 0) {
                System.out.print("Enter Day Number: ");
                int day = sc.nextInt();

                System.out.print("Enter Quantity: ");
                int Quantity = sc.nextInt();

                System.out.println("Select Vaccine");
                int count = 0;

                for (Vaccine j : VacInfo) {
                    System.out.println(count + ". " + j.Vaccine_name);
                    count = count + 1;

                }

                int select = sc.nextInt();

                System.out.println("Slot added by Hospital " + i.Hospital_ID + " for Day: " + day + ", "
                        + "Available Quantity: " + Quantity + " of Vaccine " + VacInfo.get(select));

                Hospital hosObj1 = new Hospital(InpH_id, slot, day, Quantity);
                HosInfo.add(hosObj1);

                Slot s1 = new Slot(InpH_id, day, Quantity, VacInfo.get(select).Vaccine_name);
                slotInfo.add(s1);
                hosObj1.CreateSlot(InpH_id, slot, day, Quantity);

                slot--;
            }

        }
    }

    private static void regCitizen(Scanner sc, ArrayList<Citizens> CitiInfo) {
        sc.nextLine();
        System.out.print("Citizen Name: ");
        String Person_name = sc.nextLine();

        System.out.print("Age: ");
        int Age = sc.nextInt();

        System.out.print("Unique ID: ");
        long Unique_ID = sc.nextLong();

        Citizens ctObj = new Citizens(Person_name, Age, Unique_ID);

        CitiInfo.add(ctObj);

        ctObj.Register_Citizens(Person_name, Age, Unique_ID);
    }

    private static void regHos(Scanner sc, ArrayList<Hospital> HosInfo) {
        sc.nextLine();
        System.out.print("Hospital Name: ");
        String Hospital_name = sc.nextLine();

        System.out.print("Pincode: ");
        int Pincode = sc.nextInt();

        int Hospital_ID = 100000 + HosInfo.size();

        Hospital hasObj = new Hospital(Hospital_name, Pincode, Hospital_ID);

        HosInfo.add(hasObj);

        hasObj.Register_Hospital(Hospital_name, Pincode, Hospital_ID);
    }

    private static void addVacc(Scanner sc, ArrayList<Vaccine> VacInfo) {
        sc.nextLine();
        System.out.print("Vaccine Name: ");
        String Vname = sc.nextLine();

        System.out.print("Number of Doses: ");
        int Doses = sc.nextInt();

        if (Doses > 1) {
            System.out.print("Gap Between Doses: ");
            int Gap = sc.nextInt();

            Vaccine vacObj = new Vaccine(Vname, Doses, Gap);

            VacInfo.add(vacObj);
            vacObj.AddVaccine(Vname, Doses, Gap);
        } else if (Doses <= 1) {
            Vaccine vacObj = new Vaccine(Vname, Doses, 0);

            VacInfo.add(vacObj);
            vacObj.AddVaccine(Vname, Doses, 0);
        }
    }

    public static void Menu() {

        System.out.println("---------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("---------------------------------");
    }
}

class Hospital {

    String Hospital_name;
    int Hospital_ID;
    int Pincode;

    public Hospital(String Hospital_name, int Pincode, int Hospital_ID) {

        this.Hospital_name = Hospital_name;
        this.Pincode = Pincode;
        this.Hospital_ID = Hospital_ID;

    }

    public Hospital(int Hospital_ID, int slot, int day, int Quantity) {
        /*
         * this.Hospital_ID=Hospital_ID; this.slot=slot; this.day=day;
         * this.Quantity=Quantity; this.select=select;
         */

    }

    public void Register_Hospital(String Hospital_name, int Pincode, int Hospital_ID) {

        System.out.println(
                "Hospital Name: " + Hospital_name + ", " + "Pincode: " + Pincode + ", " + "Unique ID: " + Hospital_ID);

    }

    public void CreateSlot(int Hospital_ID, int slot, int day, int Quantity) {

        /*
         * if(select==0){
         * System.out.println("Slot added by Hospital "+Hospital_ID+" for Day: "
         * +day+", "+"Available Quantity: "+Quantity+" of Vaccine "+"covax"); } else
         * if(select==1){
         * System.out.println("Slot added by Hospital "+Hospital_ID+" for Day: "
         * +day+", "+"Available Quantity: "+Quantity+" of Vaccine "+"Covi"); } else{
         * System.out.println("invalid selection"); }
         */
    }
}

class Citizens {
    String Pvacc;
    String Person_name;
    int Age;
    long Unique_ID;

    int dose_count;

    public Citizens(String Person_name, int Age, long Unique_ID) {
        this.Person_name = Person_name;
        this.Age = Age;
        this.Unique_ID = Unique_ID;

    }

    public void Register_Citizens(String Person_name, int Age, long Unique_ID) {

        if (Age <= 18) {
            System.out
                    .println("Citizen Name: " + Person_name + ", " + "Age: " + Age + ", " + "Unique ID: " + Unique_ID);
            System.out.println("Only above 18 are allowed");
        } else {
            System.out
                    .println("Citizen Name: " + Person_name + ", " + "Age: " + Age + ", " + "Unique ID: " + Unique_ID);

        }

    }

    public void PartialVaccinated(String Pvacc) {
        this.Pvacc = Pvacc;

    }

    public void FullyVaccinated(String Pvacc) {
        this.Pvacc = Pvacc;

    }
}

class Vaccine {

    String Vaccine_name;
    int total_doses;
    int Gap_required;

    public Vaccine(String vName, int doses, int Gap_required) {
        this.Vaccine_name = vName;
        this.total_doses = doses;
        this.Gap_required = Gap_required;
    }

    public void AddVaccine(String vName, int total_doses, int Gap_required) {

        System.out.println("Vaccine Name: " + vName + ", " + "Number of Doses: " + total_doses + ", "
                + "Gap Between Doses: " + Gap_required);
    }

    @Override
    public String toString() {
        return this.Vaccine_name;
    }
}

class Slot {

    int Hospital_ID;
    int day;
    int Quantity;
    String Vaccine_name;

    public Slot(int Hospital_ID, int day, int Quantity, String Vaccine_name) {
        this.Hospital_ID = Hospital_ID;
        this.day = day;
        this.Quantity = Quantity;
        this.Vaccine_name = Vaccine_name;

    }

}
