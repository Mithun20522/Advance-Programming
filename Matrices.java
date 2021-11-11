import java.util.*;

class Matrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Matrices m = new Matrices();
        Mat1 m1 = new Mat1();
        HashMap<String, Mat1> mMap = new HashMap<>();

        while (true) {

            m.Task_List();
            System.out.println();
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                m.TakeInputOfMatrix(mMap);

            }

            else if (choice == 2) {
                m.GetMatrix(mMap);
            } 

            else if (choice == 3) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                System.out.print("Do you want to change: ");
                String s = sc.nextLine();

                if(s.equals("yes")){
                    m1.ChangeTheElement(names[0], mMap);
                    System.out.println();
                }
                else{
                    continue;
                }

            } 
            else if (choice == 4) {

                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                for (String name : names) {
                    mMap.get(name).DisplayMatrix();
                    System.out.println();
                }

            } 
            else if (choice == 5) {

                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                mMap.get(names[1]).Retrieve();
                System.out.println();
                System.out.println("1. Add");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.print("Choose your choice: ");
                int opt = sc.nextInt();

                if (opt == 1) {
                    System.out.println("Addition is : ");
                    m1.Add(names[0], names[1], mMap);
                    System.out.println();
                } else if (opt == 2) {
                    System.out.println("Subtraction is : ");
                    m1.Sub(names[0], names[1], mMap);
                    System.out.println();
                } else if (opt == 3) {
                    System.out.println("Multiplication is : ");
                    m1.Mul(names[0], names[1], mMap);
                    System.out.println();
                } else if (opt == 4) {
                    System.out.println("Division is : ");
                    m1.Div(names[0], names[1], mMap);
                    System.out.println();
                } else {
                    System.out.println("Invalid choice.....");
                }

            } 
            else if (choice == 6) {

                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                mMap.get(names[1]).Retrieve();
                System.out.println();
                System.out.println("1. Add");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication (elementwise)");
                System.out.println("4. Division");
                System.out.print("Choose your choice: ");
                int opt = sc.nextInt();

                if (opt == 1) {
                    System.out.println("Element wise Addition is : ");
                    m1.Add(names[0], names[1], mMap);
                    System.out.println();
                } else if (opt == 2) {
                    System.out.println("Element wise Subtraction is : ");
                    m1.Sub(names[0], names[1], mMap);
                    System.out.println();
                } else if (opt == 3) {
                    System.out.println("Element wise multiplication is : ");
                    m1.ElementWiseMul(names[0], names[1], mMap);
                    System.out.println();
                } else if (opt == 4) {
                    System.out.println("Element wise Division is : ");
                    m1.Div(names[0], names[1], mMap);
                    System.out.println();
                } else {
                    System.out.println("Invalid choice.....");
                }

            } 
            else if (choice == 7) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                System.out.println("Transpose is: ");
                m1.Transpose_Matrices(names[0], mMap);
                // m.Transpose(names[0], mMap);
                // System.out.println();
            } 
            else if (choice == 8) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                m1.Inverse_Matrices(names[0], mMap);
                System.out.println();
            } 
            else if (choice == 9) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                m1.Compute_Means(names[0], mMap);
                // m.ComputeMeans(names[0], mMap);
                // System.out.println();
            } 
            else if (choice == 10) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                System.out.print("Determinant is: ");
                double x = m1.Compute_Determinants(names[0], mMap);
                System.out.println(x);
                System.out.println();

            } 
            else if (choice == 11) {

                System.out.print("Do you allow using singleton matrices as a scalar value?: ");
                String opt = sc.nextLine();
                System.out.println();
                if(opt.equals("yes")){
                    System.out.print("Enter space spaerated matrix names: ");
                    String[] names = sc.nextLine().strip().split(" ");
                    mMap.get(names[0]).Retrieve();
                    mMap.get(names[1]).Retrieve();
                    int[][] mx1 = mMap.get(names[0]).MatrixGetter();
                    int[][] mx2 = mMap.get(names[1]).MatrixGetter();
                    System.out.println();
                    for (int i = 0; i < mx1.length; i++) {
                        for (int j = 0; j < mx1[0].length; j++) {
                            System.out.print((mx1[i][j]*mx2[0][0])+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                else{
                    continue;
                }
                

            } 
            else if (choice == 12) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                System.out.println("Matrix + (Matrix)' is: ");
                m1.Compute(names[0], mMap);
                System.out.println();

            } 
            else if (choice == 13) {
                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                System.out.println();
                double[] eg = m1.EigenVectorsValues(mMap.get(names[0]).MatrixGetter());
                for (int i = 0; i < eg.length; i++) {
                    System.out.println(eg[i]);
                }
                System.out.println();
            }

            else if (choice == 14) {

                System.out.print("Enter space spaerated matrix names: ");
                String[] names = sc.nextLine().strip().split(" ");
                mMap.get(names[0]).Retrieve();
                mMap.get(names[1]).Retrieve();
                int[][] mx1 = mMap.get(names[0]).MatrixGetter();
                int[][] mx2 = mMap.get(names[1]).MatrixGetter();

                if(mx1.length==1 && mx1[0].length==1){
                  double[][] l1 = m1.SolveSetsOfLinearEquations1(mx1, mx2);
                  for (int i = 0; i < l1.length; i++) {
                      for (int j = 0; j < l1[0].length; j++) {
                          System.out.print(l1[i][j]+" ");
                      }
                  }
                }
                  if(mx1.length==2 && mx1[0].length==2){
                    double[][] l2 = m1.SolveSetsOfLinearEquations2(mx1, mx2);
                    for (int i = 0; i < l2.length; i++) {
                        for (int j = 0; j < l2[0].length; j++) {
                            System.out.print(l2[i][j]+" ");
                        }
                    }
                }

                if(mx1.length==3 && mx1[0].length==3){
                    double[][] l3 = m1.SolveSetsOfLinearEquations3(mx1, mx2 ,names[0],mMap);
                    for (int i = 0; i < l3.length; i++) {
                        for (int j = 0; j < l3[0].length; j++) {
                            System.out.print(l3[i][j]+" ");
                        }
                    }
                }
                System.out.println();

            }
          else if (choice == 15) {

                System.out.print("Enter matrix Type: ");
                String names = sc.nextLine();

                for (String name : mMap.keySet()) {
                    if (mMap.get(name).TypeOfMatrixGetter().equals(names)) {
                        mMap.get(name).Retrieve();
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Thanks For Using...................");
                break;
            }
        }
    }


    public void TakeInputOfMatrix(HashMap<String, Mat1> mMap) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of matrix: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int a = 0; a < n; a++) {
            System.out.print("Enter the name of matrix: ");
            String mName = sc.nextLine();

            System.out.print("No. of rows: ");
            int row = sc.nextInt();

            System.out.print("No. of coloums: ");
            int col = sc.nextInt();
            sc.nextLine();
            if ((row >= 1 && row <= 3) && (col >= 1 && col <= 3)) {
                Mat1 mat = new Mat1(row, col);
                mat.TakeInputOfMatrix();
                mMap.put(mName, mat);
                System.out.println();
            } else {
                System.out.println("Range only 1x1 to 3x3 is allowed here.....");
                System.out.println();
            }
        }
    }

    public int[][] GenerateMatrix(int row , int col) {
        int[][] mx = new int[row][col];
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mx[i][j] = rn.nextInt(50);
            }
        }
        return mx;
    }

    public void AllMatrix() {

        System.out.println("Choose a matrix: ");
        System.out.println();
        System.out.println("1. Rectangular Matrix");
        System.out.println("2. Row Matrix");
        System.out.println("3. Column Matrix");
        System.out.println("4. Square Matrix");
        System.out.println("5. Symmetric Matrix");
        System.out.println("6. Skew-symmetric Matrix");
        System.out.println("7. Upper-triangular Matrix");
        System.out.println("8. Lower-triangular Matrix");
        System.out.println("9. Singular Matrix");
        System.out.println("10. Diagonal Matrix");
        System.out.println("11. Scalar Matrix");
        System.out.println("12. Identity Matrix");
        System.out.println("13. Singleton Matrix");
        System.out.println("14. Ones Matrix");
        System.out.println("15. Null Matrix");
        System.out.println();
    }


    public void GetMatrix(HashMap<String, Mat1> mMap) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        AllMatrix();
        int ch = sc.nextInt();
        sc.nextLine();
        System.out.print("Name of matrix: ");
        String n = sc.nextLine();
        System.out.print("row: ");
        int row=sc.nextInt();
        System.out.print("col: ");
        int col=sc.nextInt();

        if (ch == 1) {
            if (row != col) {
               int[][] gen =  GenerateMatrix(row, col);
               mMap.put(n, new Mat1(row, col, gen, "rectangular"));
            } else {
                System.out.println("Row & column should be diffrent for Rectangular matrix");
            }
            System.out.println();

        } else if (ch == 2) {
            if (row == 1 && col != 1) {
                int[][] gen =  GenerateMatrix(row, col);
                mMap.put(n, new Mat1(row, col, gen, "row"));
            } else {
                System.out.println("Row should be 1 for Row matrix");
            }
            System.out.println();
        } else if (ch == 3) {
            if (col == 1 && row != 1) {
                int[][] gen =  GenerateMatrix(row, col);
               mMap.put(n, new Mat1(row, col, gen, "column"));
            } else {
                System.out.println("Column should be 1 for Column matrix");
            }
            System.out.println();
        } else if (ch == 4) {
            if (row == col) {
                int[][] gen =  GenerateMatrix(row, col);
               mMap.put(n, new Mat1(row, col, gen, "square"));
            } else {
                System.out.println("Row & column should be Same for Square matrix");
            }
            System.out.println();
        } else if (ch == 5) {
            if (row == col) {
                int[][] gen =  GenerateMatrix(row, col);
                int[][] gen1 = new int[row][col];
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(j<i){
                        gen[i][j]=gen[j][i];
                        }
                    }
                }
               mMap.put(n, new Mat1(row, col, gen, "symmetric"));
            } else {
                System.out.println("Not valid for symmetric!!!");
            }
            System.out.println();

        } else if (ch == 6) {
            if (row == col) {
                int[][] gen =  GenerateMatrix(row, col);
                int[][] gen1 = new int[row][col];
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(j<i){
                        gen[i][j]= -gen[j][i];
                        }
                        if(i==j){
                            gen[i][j]=0;
                        }
                    }
                }
               mMap.put(n, new Mat1(row, col, gen, "skew symmetric"));
            } else {
                System.out.println("Not valid for skew symmetric!!!");
            }
            System.out.println();
        } else if (ch == 7) {
            if (row == col) {
                int[][] gen =  GenerateMatrix(row, col);
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(j<i){
                            gen[i][j]=0;
                        }
                    }
                }
               mMap.put(n, new Mat1(row, col, gen, "upper triangular"));
            } else {
                System.out.println("not valid for upper triangular");
            }
            System.out.println();
        } else if (ch == 8) {
            if (row == col) {
                int[][] gen =  GenerateMatrix(row, col);
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(j>i){
                            gen[i][j]=0;
                        }
                    }
                }
               mMap.put(n, new Mat1(row, col, gen, "lower triangular"));
            } else {
                System.out.println("not valid for lower triangular");
            }
            System.out.println();
        } else if (ch == 9) {
            if (row == col) {
                int x=rn.nextInt(50)+1;
                int[][] gen =  new int[row][col];
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                            gen[i][j]=x;
                    }
                }
               mMap.put(n, new Mat1(row, col, gen, "singular"));
            } else {
                System.out.println("not valid for singular");
            }
            System.out.println();

        } else if (ch == 10) {

            int[][] gen = new int[row][col];
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(i==j){
                            gen[i][j]=rn.nextInt(50)+1;
                        }
                        
                    }
                }
                mMap.put(n, new Mat1(row, col, gen, "diagonal"));

        } else if (ch == 11) {

            int x = rn.nextInt(50);

            int[][] gen = new int[row][col];
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(i==j){
                            gen[i][j]=x;
                        }
                        
                    }
                }
                mMap.put(n, new Mat1(row, col, gen, "scalar"));
        } else if (ch == 12) {
                int[][] gen = new int[row][col];
                for (int i = 0; i < gen.length; i++) {
                    for (int j = 0; j < gen[0].length; j++) {
                        if(i==j){
                            gen[i][j]=1;
                        }
                        
                    }
                }
                mMap.put(n, new Mat1(row, col, gen, "identity"));

        } else if (ch == 13) {
            if (row == 1 && col == 1) {
                int[][] gen =  GenerateMatrix(row, col);
               mMap.put(n, new Mat1(row, col, gen, "singleton"));
            } else {
                System.out.println("Row & column , Both should be 1 for Singleton matrix");
            }
            System.out.println();

        } else if (ch == 14) {
            int[][] gen = new int[row][col];
            for (int i = 0; i < gen.length; i++) {
                for (int j = 0; j < gen[0].length; j++) {
                    gen[i][j]=1;
                }
            }
            mMap.put(n, new Mat1(row, col, gen, "ones"));

        } else if (ch == 15) {
            int[][] gen = new int[row][col];
            mMap.put(n, new Mat1(row, col, gen, "null"));
        }

    }


    public void CreateMatrix(HashMap<String, Mat1> mMap) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of matrix: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int a = 0; a < n; a++) {
            System.out.print("Enter the name of matrix: ");
            String mName = sc.nextLine();

            System.out.print("No. of rows: ");
            int row = sc.nextInt();

            System.out.print("No. of coloums: ");
            int col = sc.nextInt();
            sc.nextLine();
            if ((row >= 1 && row <= 3) && (col >= 1 && col <= 3)) {
                Mat1 mat = new Mat1(row, col);
                mat.CreateMatrix();
                mMap.put(mName, mat);
                System.out.println();
            } else {
                System.out.println("Range only 1x1 to 3x3 is allowed here.....");
                System.out.println();
            }
        }
    }

    public void Task_List() {

        System.out.println("1. Take matrices as input and label them with appropriate matrix-types.");
        System.out
                .println("2. Create matrices of requested matrix-types and label them with appropriate matrix-types.");
        System.out.println("3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.");
        System.out.println("4. Display all the matrix-type labels of a requested matrix.");
        System.out.println("5. Perform addition, subtraction, multiplication & division.");
        System.out.println("6. Perform element-wise operations.");
        System.out.println("7. Transpose matrices.");
        System.out.println("8. Inverse matrices.");
        System.out.println("9. Compute means: row-wise mean, column-wise mean, mean of all the elements.");
        System.out.println("10. Compute determinants.");
        System.out.println("11. Use singleton matrices as scalars, if requested.");
        System.out.println("12. Compute A+AT for a matrix A.");
        System.out.println("13. Compute Eigen vectors and values.");
        System.out.println("14. Solve sets of linear equations using matrices.");
        System.out.println(
                "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.");

    }

}

interface Matrices1 {

    void TakeInputOfMatrix();

    void ChangeTheElement(String name1, HashMap<String, Mat1> mMap);

    void DisplayMatrix();

    void Retrieve();

}

interface Matrices2 extends Matrices1 {

    void Add(String name1, String name2, HashMap<String, Mat1> mMap);
    void Sub(String name1, String name2, HashMap<String, Mat1> mMap);
    void Div(String name1, String name2, HashMap<String, Mat1> mMap);
    void Mul(String name1, String name2, HashMap<String, Mat1> mMap);
    void ElementWiseMul(String name1, String name2, HashMap<String, Mat1> mMap); // perform element wise operations

    void Transpose_Matrices(String name1, HashMap<String, Mat1> mMap);

    void Inverse_Matrices(String name1, HashMap<String, Mat1> mMap);

    void Compute_Means(String name1, HashMap<String, Mat1> mMap); // row, col, all elemts

}

interface Matrices3 extends Matrices2 {

    double Compute_Determinants(String name1, HashMap<String, Mat1> mMap);
    void Singleton_Matrices();
    void Compute(String name1, HashMap<String, Mat1> mMap); // compute A+AT for a matrix A
    double[]  EigenVectorsValues(int[][] mx);
    double[][] SolveSetsOfLinearEquations1(int[][] mx, int[][] f);
    double[][] SolveSetsOfLinearEquations2(int[][] mx, int[][] f);
    double[][] SolveSetsOfLinearEquations3(int[][] mx, int[][] f ,String name1, HashMap<String, Mat1> mMap);
}

class Mat1 implements Matrices3 {

    private int row;
    private int col;
    private int[][] mx;
    private String typeOfMatrix;

    public Mat1() {

    }

    public Mat1(int row, int col ,int[][] mx ,String typeOfMatrix ) {
        this.row = row;
        this.col = col;
        this.mx = mx;
        this.typeOfMatrix = typeOfMatrix;
    }


    public Mat1(int row, int col) {
        this.row = row;
        this.col = col;
        this.mx = new int[row][col];


    }

    public void RowSetter(int row) {
        this.row = row;
    }

    public int RowGetter() {
        return row;
    }

    public void ColSetter(int col) {
        this.col = col;
    }

    public int ColGetter() {
        return col;
    }

    public void MatrixSetter(int[][] mx) {
        this.mx = mx;
    }

    public int[][] MatrixGetter() {
        return mx;
    }

    public void TypeOfMatrixSetter(String typeOfMatrix) {
        this.typeOfMatrix = typeOfMatrix;
    }

    public String TypeOfMatrixGetter() {
        return typeOfMatrix;
    }

    @Override
    public void TakeInputOfMatrix() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                mx[i][j] = sc.nextInt();
            }
        }
        this.checkType();
        // this.DisplayMatrix();
    }

    public void checkType() {

        boolean chkfornull = false;
        boolean chkforOne = false;
        boolean chkforIdentity = false;
        boolean chkforDiagonal = false;
        boolean chkforUpp = false;
        boolean chkforLow = false;
        boolean chkSymm = false;
        boolean chkskew = false;
        boolean chkforScalar = false;
        boolean chkforSingleton = false;
        boolean chkforsingular = false;

        int cnt0 = 0;
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[0].length; j++) {
                if (mx[i][j] == 0) {
                    cnt0++;
                }
            }
        }
        if (cnt0 == (mx.length * mx[0].length)) {
            chkfornull = true;
        }

        if (mx.length == 2 && mx[0].length == 2) {
            if (mx[0][0] == mx[0][0] && mx[0][1] == mx[1][0] && 
                mx[1][0] == mx[0][1] && mx[1][1] == mx[1][1]) {
                chkSymm = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3) {
            if (mx[0][0] == mx[0][0] && mx[0][1] == mx[1][0] && mx[0][2] == mx[2][0] && 
                mx[1][0] == mx[0][1] && mx[1][1] == mx[1][1] && mx[1][2] == mx[2][1] && 
                mx[2][0] == mx[0][2] && mx[2][1] == mx[1][2] && mx[2][2] == mx[2][2]) {
                chkSymm = true;
            }
        }

        if (mx.length == 2 && mx[0].length == 2) {
            if (mx[0][0] == mx[0][0] && mx[0][1] == -mx[1][0] && 
                mx[1][0] == -mx[0][1] && mx[1][1] == mx[1][1]) {
                chkskew = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3) {
            if (mx[0][0] == mx[0][0] && mx[0][1] == -mx[1][0] && mx[0][2] == -mx[2][0] && 
                mx[1][0] == -mx[0][1] && mx[1][1] == mx[1][1] && mx[1][2] == -mx[2][1] && 
                mx[2][0] == -mx[0][2] && mx[2][1] == -mx[1][2] && mx[2][2] == mx[2][2]) {
                chkskew = true;
            }
        }

        if (mx.length == 2 && mx[0].length == 2) {
            if (mx[0][0] == 1 && mx[1][1] == 1 && 
                mx[0][1] == 0 && mx[1][0] == 0) {
                chkforIdentity = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3) {
            if (mx[0][0] == 1 && mx[1][1] == 1 && mx[2][2] == 1) {
                if (mx[0][1] == 0 && mx[0][2] == 0 && mx[1][0] == 0 && 
                    mx[1][2] == 0 && mx[2][0] == 0 && mx[2][1] == 0) {

                    chkforIdentity = true;
                }
            }
        }
        if (mx.length == 2 && mx[0].length == 2 && mx[0][0] != 0) {
            int det = mx[0][0] * mx[1][1] - mx[0][1] * mx[1][0];
            if (det == 0) {
                chkforsingular = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3 && mx[0][0] != 0) {
            int det = mx[0][0] * (mx[1][1] * mx[2][2] - mx[1][2] * mx[2][1])
                    - mx[0][1] * (mx[2][2] * mx[1][0] - mx[1][2] * mx[2][0])
                    + mx[0][2] * (mx[1][0] * mx[2][1] - mx[1][1] * mx[2][0]);
            if (det == 0) {
                chkforsingular = true;
            }
        }

        if (mx.length == 2 && mx[0].length == 2) {
            if (mx[0][0] != 0 && mx[0][1] == 0 && 
                mx[1][0] == 0 && mx[1][1] != 0) {
                chkforDiagonal = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3) {
            if (mx[0][0] != 0 && mx[0][1] == 0 && mx[0][2] == 0 && 
                mx[1][0] == 0 && mx[1][1] != 0 && mx[1][2] == 0 && 
                mx[2][0] == 0 && mx[2][1] == 0 && mx[2][2] != 0) {
                chkforDiagonal = true;
            }
        }

        if (mx.length == 1 && mx[0].length == 1) {
            chkforSingleton = true;
        }

        if (mx.length == 2 && mx[0].length == 2) {
            if (mx[0][0] != 0 && mx[0][1] == 0 && 
                mx[1][0] != 0 && mx[1][1] != 0) {
                chkforUpp = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3) {
            if (mx[0][0] != 0 && mx[0][1] == 0 && mx[0][2] == 0 && 
                mx[1][0] != 0 && mx[1][1] != 0 && mx[1][2] == 0 && 
                mx[2][0] != 0 && mx[2][1] != 0 && mx[2][2] != 0) {
                chkforUpp = true;
            }
        }

        if (mx.length == 2 && mx[0].length == 2) {
            if (mx[0][0] != 0 && mx[0][1] != 0 && 
                mx[1][0] == 0 && mx[1][1] != 0) {
                chkforLow = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3) {
            if (mx[0][0] != 0 && mx[0][1] != 0 && mx[0][2] != 0 && 
                mx[1][0] == 0 && mx[1][1] != 0 && mx[1][2] != 0 && 
                mx[2][0] == 0 && mx[2][1] == 0 && mx[2][2] != 0) {
                chkforLow = true;
            }
        }

        if (mx.length == 2 && mx[0].length == 2 && mx[0][0] != 0) {
            int temp = mx[0][0];
            if (mx[0][0] == temp && mx[0][1] == 0 && 
                mx[1][0] == 0 && mx[1][1] == temp) {

                chkforScalar = true;
            }
        } else if (mx.length == 3 && mx[0].length == 3 && mx[0][0] != 0) {
            int temp = mx[0][0];
            if (mx[0][0] == temp && mx[0][1] == 0 && mx[0][2] == 0 && 
                mx[1][0] == 0 && mx[1][1] == temp && mx[1][2] == 0 && 
                mx[2][0] == 0 && mx[2][1] == 0 && mx[2][2] == temp) {

                chkforScalar = true;
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[0].length; j++) {
                if (mx[i][j] == 1) {
                    cnt1++;
                }
            }
        }
        if (cnt1 == (mx.length * mx[0].length)) {
            chkforOne = true;
        }

        if (chkforSingleton) {
            this.typeOfMatrix = "singleton";

        } else if (chkforOne) {
            this.typeOfMatrix = "ones";

        }

        else if (chkfornull) {
            this.typeOfMatrix = "null";

        } else if (chkforIdentity) {
            this.typeOfMatrix = "identity";

        } else if (chkforScalar) {
            this.typeOfMatrix = "scalar";

        }

        else if (chkforDiagonal) {
            this.typeOfMatrix = "diagonal";

        }

        else if (chkforsingular) {
            this.typeOfMatrix = "singular";

        }

        else if (chkSymm) {
            this.typeOfMatrix = "symmetric";

        } else if (chkskew) {
            this.typeOfMatrix = "skew symmetric";

        } else if (chkforUpp) {
            this.typeOfMatrix = "upper triangular";

        } else if (chkforLow) {
            this.typeOfMatrix = "lower triangular";

        }

        else if (row == col) {
            this.typeOfMatrix = "square";


        } else if (row == 1 && col != 1) {
            this.typeOfMatrix = "row";

        } else if (col == 1 && row != 1) {
            this.typeOfMatrix = "column";

        } else if (row != col) {
            this.typeOfMatrix = "rectangular";


        }

        System.out.println();
    }

    

    @Override
    public void Add(String name1, String name2, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] mx2 = mMap.get(name2).MatrixGetter();
        if ((mx1.length == mx2.length)) {
            for (int i = 0; i < mx1.length; i++) {
                for (int j = 0; j < mx1[i].length; j++) {
                    System.out.print((mx1[i][j] + mx2[i][j]) + " ");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void Sub(String name1, String name2, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] mx2 = mMap.get(name2).MatrixGetter();
        if ((mx1.length == mx2.length)) {
            for (int i = 0; i < mx1.length; i++) {
                for (int j = 0; j < mx1[i].length; j++) {
                    System.out.print((mx1[i][j] - mx2[i][j]) + " ");
                }
                System.out.println();
            }
        }

    }

    @Override
    public void Div(String name1, String name2, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] mx2 = mMap.get(name2).MatrixGetter();
        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx1[i].length; j++) {
                System.out.print((double) ((double) mx1[i][j] / (double) mx2[i][j]) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void Mul(String name1, String name2, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] mx2 = mMap.get(name2).MatrixGetter();
        int[][] mx3 = new int[mx1.length][mx2[0].length];
        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx2[0].length; j++) {
                mx3[i][j] = 0;
                for (int j2 = 0; j2 < mx3.length; j2++) {
                    mx3[i][j] = mx3[i][j] + (mx1[i][j2] * mx2[j2][j]);
                }
                System.out.print(mx3[i][j] + " ");
            }
            System.out.println();
        }

    }

    @Override
    public void ElementWiseMul(String name1, String name2, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] mx2 = mMap.get(name2).MatrixGetter();
        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx1[i].length; j++) {
                System.out.print((mx1[i][j] * mx2[i][j]) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void Transpose_Matrices(String name1, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] Trans = new int[mx1.length][mx1.length];
        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx1[i].length; j++) {
                Trans[i][j] = mx1[j][i];
                System.out.print(Trans[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void Inverse_Matrices(String name1, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();

        double d = Compute_Determinants(name1, mMap);

        if (mx1.length == 1 && mx1[0].length == 1) {

            System.out.println(1.0 / (double) mx1[0][0]);
        }

        else if (mx1.length == 2 && mx1[0].length == 2) {

            double[][] inv = { { (double) mx1[1][1] / (double) d, (double) mx1[0][1] * (-1) / (double) d },
                    { (double) mx1[1][0] * (-1) / (double) d, (double) mx1[0][0] / (double) d } };
            for (int i = 0; i < inv.length; i++) {
                for (int j = 0; j < inv.length; j++) {
                    System.out.print(inv[i][j] + " ");
                }
                System.out.println();
            }
        }

        else if (mx1.length == 3 && mx1[0].length == 3) {
            double[][] inv = new double[mx1.length][mx1[0].length];
                for (int i = 0; i < mx1.length; i++) {
                    for (int j = 0; j < mx1[0].length; j++) {
                         inv[i][j] =  (double) ( mx1[(j+1)%mx1.length][(i+1)%mx1[0].length] * (double) mx1[(j+2)%mx1.length][(i+2)%mx1[0].length]) -  (double)(mx1[(j+1)%mx1.length][(i+2)%mx1[0].length] * (double) mx1[(j+2)%mx1.length][(i+1)%mx1[0].length])/d;
                    }
                }

            for (int i = 0; i < inv.length; i++) {
                for (int j = 0; j < inv.length; j++) {
                    System.out.print(inv[i][j] + " ");
                }
                System.out.println();
            }
        }


    }

    @Override
    public void Compute_Means(String name1, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();

        double[] rMean = new double[mx1.length];

        double[] cMean;
        double element_wise = 0;
        double eMean = 0;
        cMean = new double[mx1[0].length];

        for (int i = 0; i < mx1.length; i++) {
            double row_Wise = 0;
            for (int j = 0; j < mx1[i].length; j++) {

                row_Wise = row_Wise + (double) mx1[i][j];

                element_wise = element_wise + (double) mx1[i][j];
                eMean = ((element_wise) / (double) (mx1.length * mx1[i].length));

            }
            rMean[i] = row_Wise / (double) mx1[0].length;

        }

        for (int i = 0; i < mx1[0].length; i++) {
            double col_wise = 0;
            for (int j = 0; j < mx1.length; j++) {

                col_wise = col_wise + (double) mx1[j][i];

            }
            cMean[i] = col_wise / (double) mx1.length;

        }
        System.out.println("Column Wise mean: ");
        for (int i = 0; i < cMean.length; i++) {
            System.out.print(cMean[i] + " ");
        }
        System.out.println();

        System.out.println("Row Wise mean: ");
        for (int i = 0; i < rMean.length; i++) {
            System.out.print(rMean[i] + " ");
        }
        System.out.println();
        System.out.println("Mean of all elements: " + eMean);

    }

    


    @Override
    public void ChangeTheElement(String name1, HashMap<String, Mat1> mMap) {
        Scanner sc = new Scanner(System.in);
        int[][] mx1 = mMap.get(name1).MatrixGetter();

        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx1[i].length; j++) {
                mx1[i][j]= sc.nextInt();

            }

        }

    }

    @Override
    public void DisplayMatrix() {

        System.out.println(this.TypeOfMatrixGetter());
    }

    @Override
    public void Retrieve() {
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                System.out.print(mx[i][j] + " ");
            }
            System.out.println();
        }

    }

    @Override
    public double Compute_Determinants(String name1, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        double det = 0;
        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx1[i].length; j++) {
                if ((mx1.length == 1) && (mx1[i].length == 1)) {
                    det = (double) mx1[i][j];
                }
                if ((mx1.length == 2) && (mx1[i].length == 2)) {
                    det = (double) (mx1[0][0] * mx1[1][1]) - (double) (mx1[0][1] * mx1[1][0]);
                }
                if ((mx1.length == 3) && (mx1[i].length == 3)) {

                    double a = (double) (mx1[1][1] * mx1[2][2]) - (double) (mx1[2][1] * mx1[1][2]);
                    double b = (double) (mx1[1][0] * mx1[2][2]) - (double) (mx1[2][0] * mx1[1][2]);
                    double c = (double) (mx1[1][0] * mx1[2][1]) - (double) (mx1[2][0] * mx1[1][1]);

                    det = (double) (mx1[0][0] * a) - (double) (mx1[0][1] * b) + (double) (mx1[0][2] * c);

                }

            }
        }
        return det;

    }

    @Override
    public void Singleton_Matrices() {
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                System.out.print(mx[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void Compute(String name1, HashMap<String, Mat1> mMap) {
        int[][] mx1 = mMap.get(name1).MatrixGetter();
        int[][] Trans = new int[mx1.length][mx1.length];
        for (int i = 0; i < mx1.length; i++) {
            for (int j = 0; j < mx1[i].length; j++) {
                Trans[i][j] = mx1[j][i];
                System.out.print((Trans[i][j] + mx1[i][j]) + " ");
            }
            System.out.println();
        }

    }


    @Override
    public double[] EigenVectorsValues(int[][] mx) {
        if (mx.length == mx[0].length && mx.length == 1) {
            return new double[] { mx[0][0] };
        } else if (mx.length == mx[0].length && mx.length == 2) {
            int[] y = new int[3];
            y[0] = 1; 
            y[1] = (mx[0][0] * (-1) + mx[1][1] * (-1));
            y[2] = (mx[0][0] * mx[1][1] - mx[0][1] * mx[1][0]);
            return new double[] {
                    (double) ((-1) * y[1] + Math.sqrt((Math.pow(y[1], 2)) - (4 * y[0] * y[2]))) / (2 * y[0]),
                    (double) ((-1) * y[1] - Math.sqrt((Math.pow(y[1], 2)) - (4 * y[0] * y[2]))) / (2 * y[0]) };
        }
        System.out.println("Invalid form of matrix.");
        return new double[] { Integer.MIN_VALUE };
    }


    @Override
    public double[][] SolveSetsOfLinearEquations1(int[][] mx, int[][] f) {
        if (mx.length == mx[0].length && mx.length == 1) {
            return new double[][]{ { (double) f[0][0] / (double) mx[0][0]} };
        }
        System.out.println("Invalid form of matrix.");
        return new double[][] { {Integer.MIN_VALUE } };
    }


    @Override
    public double[][] SolveSetsOfLinearEquations2(int[][] mx, int[][] f ) {
        if (mx.length == mx[0].length && mx.length == 2) {
            int det = mx[0][0] * mx[1][1] - mx[0][1] * mx[1][0];
            double[][] inv = { { (double) mx[1][1] / (double) det, (double) mx[0][1] * (-1) / (double) det },
                    { (double) mx[1][0] * (-1) / (double) det, (double) mx[0][0] / (double) det } };
            return new double[][] { { inv[0][0] * f[0][0] + inv[0][1] * f[1][0] },
                    { inv[1][0] * f[0][0] + inv[1][1] * f[1][0] } };
        }
        System.out.println("Invalid form of matrix.");
        return new double[][] { { Integer.MIN_VALUE }, { Integer.MIN_VALUE } };
    }

    @Override
    public double[][] SolveSetsOfLinearEquations3(int[][] mx, int[][] f ,String name1, HashMap<String, Mat1> mMap) {

        double d = Compute_Determinants(name1, mMap);
        if (mx.length == 3 && mx[0].length == 3) {
            double[][] inv = new double[mx.length][mx[0].length];

                for (int i = 0; i < mx.length; i++) {
                    for (int j = 0; j < mx[0].length; j++) {
                        inv[i][j] =  (double) ( mx[(j+1)%mx.length][(i+1)%mx[0].length] * (double) mx[(j+2)%mx.length][(i+2)%mx[0].length]) -  (double)(mx[(j+1)%mx.length][(i+2)%mx[0].length] * (double) mx[(j+2)%mx.length][(i+1)%mx[0].length])/d;
                    }
                }

                double[][] ans = {{(double)inv[0][0] * f[0][0] + (double)inv[0][1] * f[1][0] +(double) inv[0][2] * f[2][0]} ,{(double) inv[1][0] * f[0][0] +(double) inv[1][1] * f[1][0] + (double)inv[1][2] * f[2][0] },{(double) inv[2][0] * f[0][0] + (double)inv[2][1] * f[1][0] + (double)inv[2][2] * f[2][0]}};

            return ans;
        }
        System.out.println("Invalid form of matrix.");
        return new double[][] { { Integer.MIN_VALUE }, { Integer.MIN_VALUE } };
    }
}

