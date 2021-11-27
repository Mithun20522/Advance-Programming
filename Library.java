import java.util.*;

class Library {
    // public static int barcode = 99999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library l = new Library();
        ArrayList<Books> bookInfo = new ArrayList<>();
        
        System.out.print("Enter the number of Books a Rack can have : ");
        final int rackNo = sc.nextInt();
        
        while (true) {
            System.out.println("Welcome to my Library........");
            l.Menu();
            System.out.print("Choose: ");
            int opt = sc.nextInt();

            if (opt == 1) {
                System.out.print("No. of Books: ");
                int n = sc.nextInt();

                for (int k = 1; k <= n; k++) {
                    sc.nextLine();
                    System.out.print("Enter Title of book " + k + " : ");
                    String Title = sc.nextLine().toLowerCase();
                    System.out.print("Enter ISBN (3 digit) " + k + " : ");
                    int isbn = sc.nextInt();
                    System.out.print("Enter Bar-Code (5 digit) "+ k + " : ");
                    int barcode = sc.nextInt();

                    boolean hasBook = false;

                    for (Books i : bookInfo) {
                        if ((i.TitleGetter().equals(Title))
                                && (i.BarCodeGetter() == barcode)
                                && (i.ISBNGetter() == isbn)
                                || (i.BarCodeGetter() == barcode)) {
                            hasBook = true;
                            System.out.println(" Already exist...");
                        }

                    }
                    //barcode++;
                    // Books bCode = new Books(barcode);
                    // bookInfo.add(bCode);
                    if (!hasBook) {

                        Books b = new Books(Title, barcode, isbn);
                        bookInfo.add(b);
                        Collections.sort(bookInfo, new Comparator<Books>() {
                            @Override
                            public int compare(Books book1, Books book2) {
                                int temp1 = book1.TitleGetter().compareTo(book2.TitleGetter());
                                if (temp1 == 0) {
                                    int temp2 = (book1.ISBNGetter()) - (book2.ISBNGetter());
                                    if (temp2 == 0) {
                                        return ((book1.BarCodeGetter()) - (book2.BarCodeGetter()));
                                    }

                                    return temp2;

                                }

                                return temp1;

                            }
                        });
                    }

                }

            }

            else if (opt == 2) {
                int sno = 1;
                System.out.println();
                for (Books i : bookInfo) {
                    int rack = (((bookInfo.indexOf(i))/rackNo)+1), idx = (((bookInfo.indexOf(i))%rackNo)+1);
                    System.out.println("-------------------------------");
                    System.out.println(sno + ". " + i.toString() + "\nRack no: " + rack + "; Index of book: " + idx + "; ");
                    System.out.println("-------------------------------");
                    sno++;
                    System.out.println();
                }
                System.out.println();
            }

            else if (opt == 3) {
                System.out.println();
                System.out.println("1. Search Book By Title ");
                System.out.println("2. Search Book By ISBN(3 digit) ");
                System.out.println("3. Search By Bill Details i.e (Title & ISBN & Barcode ) ");
                int slt = sc.nextInt();
                if (slt == 1) {
                    sc.nextLine();
                    System.out.print("Enter Title of book: ");
                    String Title = sc.nextLine().toLowerCase();
                    for (Books j : bookInfo) {
                        if (j.TitleGetter().equals(Title)) {
                            int rack = (((bookInfo.indexOf(j))/rackNo)+1), idx = (((bookInfo.indexOf(j))%rackNo)+1);
                            System.out.println("-------------------------------");
                            System.out.println("Rack no. " + rack + "\nIndex of book = " + idx);
                            System.out.println("-------------------------------");
                            System.out.println();
                        }
                        System.out.println();
                    }
                }

                else if (slt == 2) {
                    System.out.print("Enter ISBN (3 digit): ");
                    int isbn = sc.nextInt();
                    for (Books j : bookInfo) {
                        if (j.ISBNGetter() == isbn) {
                            int rack = (((bookInfo.indexOf(j))/rackNo)+1), idx = (((bookInfo.indexOf(j))%rackNo)+1);
                            System.out.println("-------------------------------");
                            System.out.println("Rack no. " + rack + "\nIndex of book = " + idx);
                            System.out.println("-------------------------------");
                        }
                    }
                    System.out.println();
                }

                else if (slt == 3) {
                    sc.nextLine();
                    System.out.print("Enter Title of book: ");
                    String Title = sc.nextLine().toLowerCase();
                    System.out.print("Enter ISBN (3 digit): ");
                    int isbn = sc.nextInt();
                    System.out.print("Enter Bar-Code: ");
                    int barcode = sc.nextInt();
                    System.out.println();
                    boolean hasBook = false;
                    for (Books i : bookInfo) {
                        if ((i.TitleGetter().equals(Title) 
                                && (i.ISBNGetter() == isbn))
                                && (i.BarCodeGetter() == barcode)) {
                                    hasBook = true;
                                    int rack = (((bookInfo.indexOf(i))/rackNo)+1), idx = (((bookInfo.indexOf(i))%rackNo)+1);
                            System.out.println("-------------------------------");
                            System.out.println("Rack no. " + rack + "\nIndex of book = " + idx);
                            System.out.println("-------------------------------");
                            System.out.println();
                        }
                        System.out.println();
                    }
                }

            }

            else {
                System.out.println("Thanks for using!!!!! ");
                break;
            }
        }

    }

    public void Menu() {
        System.out.println("1. Add Book ");
        System.out.println("2. Display Books ");
        System.out.println("3. Find Rack no (Slot) of specific Book ");
    }

}

class Books {
    Scanner sc = new Scanner(System.in);

    private String Title;
    private int BarCode;
    private int ISBN;

    public Books() {
    }

    public Books(String Title) {
        this.Title = Title;
    }

    public Books(int BarCode) {
        this.BarCode = BarCode;
    }

    public Books(String Title, int BarCode, int ISBN) {
        this.Title = Title;
        this.BarCode = BarCode;
        this.ISBN = ISBN;

    }

    public void TitleSetter(String Title) {
        this.Title = Title;
    }

    public String TitleGetter() {
        return Title;
    }

    public void BarCodeSetter(int BarCode) {
        this.BarCode = BarCode;
    }

    public int BarCodeGetter() {
        return BarCode;
    }

    public void ISBNSetter(int ISBN) {
        this.ISBN = ISBN;
    }

    public int ISBNGetter() {
        return ISBN;
    }

    @Override
    public String toString() {

        return "Title: " + TitleGetter() + "; " + "ISBN: " + ISBNGetter() + "; " + "BarCode: " + BarCodeGetter() + "; ";
    }

}
