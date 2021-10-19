
import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Material> MaterialInfo = new ArrayList<>(); 
        ArrayList<Assesment> AssesmentInfo = new ArrayList<>(); 
        ArrayList<GradeAssesment> GradeassInfo = new ArrayList<>();
        ArrayList<Comment> CommentInfo = new ArrayList<>();


    while(true){

        Intro();
        int choice = sc.nextInt(); 

        if(choice==1){
            System.out.println("Instructor:");
            System.out.println("0 - I0");
            System.out.println("1 - I1");
            System.out.print("Choose id: ");

            int ChooseID = sc.nextInt();
            

            if(ChooseID==0 || ChooseID==1){
                
                while(true){
                    System.out.println();
                    System.out.println("Welcome I"+ChooseID);
                    System.out.println();

                    Material id = new Material(ChooseID);
                    MaterialInfo.add(id);

                    MenuForInstructor();
                    int Opt = sc.nextInt();

                    if(Opt==1){
                        System.out.println("1. Add Lecture Slide");
                        System.out.println("2. Add Lecture Video");
                        int ch1=sc.nextInt();

                        Add_material(sc, MaterialInfo, ch1);
                    }

                   else if(Opt==2){
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        int ch2=sc.nextInt();

                        Add_assesment(sc, AssesmentInfo, ch2);
                    }
                    else if(Opt==3){

                        View_material(MaterialInfo);
                    }
                    else if(Opt==4){

                        View_assesment(AssesmentInfo);
                    }
                    else if(Opt==5){
                        Grade_submission(sc, AssesmentInfo, GradeassInfo);

                        
                    }
                    else if(Opt==6){
                        Close_assesment(sc, AssesmentInfo);
                    }
                    else if(Opt==7){
                        view_comment(CommentInfo);
                    }
                    else if(Opt==8){
                        Add_comment(sc, CommentInfo);
                        
                    }
                    else if(Opt==9){
                        System.out.println("you are logout successfully........");
                        break;
                    }

                }
                
            }

        }
        else if(choice==2){
            System.out.println("Students:");
            System.out.println("0 - S0");
            System.out.println("1 - S1");
            System.out.println("2 - S2");

            System.out.print("Choose id: ");
            int chh=sc.nextInt();
            System.out.println();
            if(chh==0 || chh==1 || chh==2){

                while(true){
                    System.out.println("Welcome S"+chh);
                    System.out.println();
                    MenuForStudent();
                    int opt1=sc.nextInt();

                    if(opt1==1){
                        view_material(MaterialInfo);
                            
                    }
        
                    else if(opt1==2){
                        view_assesment(AssesmentInfo);
                    }

                    else if(opt1==3){
                        Submit_assesment(sc, AssesmentInfo, GradeassInfo);

                    }
                    else if(opt1==4){
                        View_grades(sc, GradeassInfo);
                    }
                    else if(opt1==5){
                        View_comment(CommentInfo);
                    }
                    
                    else if(opt1==6){
                        Add_comment(sc, CommentInfo);

                        
                    }
                    else if(opt1==7){
                        System.out.println("thanx for using..........");
                        break;
                    }
                    else{
                        break;
                    }
                }
                
            }
                
            }


         else if(choice==3){
            System.out.println("thanx for using........");
            break;
        }
        
    }
}

    private static void View_comment(ArrayList<Comment> CommentInfo) {
        for (Comment i : CommentInfo) {
            if(i.cmtS==null && i.dateS==null){
                System.out.println(i.cmtT+"  "+i.dateT);
            }
            if(i.cmtT==null && i.dateT==null){
                System.out.println(i.cmtS+" "+i.dateS);
            }
            
        }
    }

    private static void View_grades(Scanner sc, ArrayList<GradeAssesment> GradeassInfo) {
        sc.nextLine();
        System.out.println("Graded submissions");
        for (GradeAssesment i : GradeassInfo) {
            System.out.println("Submission: "+i.submission);
            System.out.println("Marks scored: "+i.maxScore);
            System.out.println("Graded by: I1");
        }
    }

    private static void Submit_assesment(Scanner sc, ArrayList<Assesment> AssesmentInfo,
            ArrayList<GradeAssesment> GradeassInfo) {
        System.out.println("Pending assessments");
        view_assesment(AssesmentInfo);
        
        System.out.print("Enter ID of assessment: ");
        int ii=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter filename of assignment: ");
        String work=sc.nextLine();
        String extn = ".zip";

        if(work.contains(extn)){
            GradeAssesment gd=new GradeAssesment(work);
            GradeassInfo.add(gd);
        }
    }

    private static void view_assesment(ArrayList<Assesment> AssesmentInfo) {
        int c=0;
        for (Assesment i : AssesmentInfo) {
            if(i.quiz==null){
                System.out.println("ID:"+c+" Assignment: "+i.prblm+" Max Marks: "+i.maxMarks);
            }
            c=1;
            if(i.prblm==null){
                System.out.println("ID:"+c+" Question: "+i.quiz);
            }
            
        }
    }

    private static void view_material(ArrayList<Material> MaterialInfo) {
        int ct=1;
        //int idx=0;
        for (Material i : MaterialInfo) {

            if(i.filename==null && i.titleofslide==null){
                System.out.println("Title: "+i.titleofslide);
                System.out.println("Slide "+ct+" "+i.slide);
                ct++;
            }

            if(i.slide==null && i.titleofvideo==null){
                System.out.println("Title of video: "+i.titleofvideo);
                System.out.print(" "+i.filename);
            }
            System.out.println("Date of upload: "+i.d);
            System.out.println("Uploaded by: I"+i.id);
        }
    }

    private static void Add_comment(Scanner sc, ArrayList<Comment> CommentInfo) {
        sc.nextLine();
        System.out.print("Enter comment: ");
        String cmtT = sc.nextLine();
        Date d = new Date();
        Comment obj1 = new Comment(cmtT , d);
        CommentInfo.add(obj1);
    }

    private static void view_comment(ArrayList<Comment> CommentInfo) {
        for (Comment i : CommentInfo) {
            System.out.println(i.cmtT+"  date: "+i.dateT);
        }
    }

    private static void Close_assesment(Scanner sc, ArrayList<Assesment> AssesmentInfo) {
        int count=0;
        System.out.println("List of Open Assignments:");
        for (Assesment i : AssesmentInfo) {
            System.out.println("ID: "+count+" Assignment: "+i.prblm+" Max Marks: "+i.maxMarks);
            count++;
        }
        int count1=1;
        System.out.println("----------------");
        for (Assesment i : AssesmentInfo) {
            System.out.println("ID: "+count1+"Question: "+i.quiz);
            count1++;
        }
        System.out.println("----------------");

        System.out.print("Enter id of assignment to close: ");
        int clsID = sc.nextInt();
        for (Assesment i : AssesmentInfo){
            
        }
    }

    private static void Grade_submission(Scanner sc, ArrayList<Assesment> AssesmentInfo,
            ArrayList<GradeAssesment> GradeassInfo) {
        int count=0;
        int tt=0;
        System.out.println("List of assessments");
        for (Assesment i : AssesmentInfo) {
            System.out.println("ID: "+count+" Assignment: "+i.prblm+" Max Marks: "+i.maxMarks);
            count++;
            System.out.println("ID: "+count+"Question: "+i.quiz);
            tt=count;
        }
        System.out.println("Enter ID of assessment to view submissions: ");
        int entID =sc.nextInt();
        for (int i = 0; i < tt; i++) {
            System.out.println(i+"S"+i);
        }
        System.out.println("Choose ID from these ungraded submissions: ");
        int idd=sc.nextInt();

        for (GradeAssesment i : GradeassInfo) {
            System.out.println("Submission: "+i.submission);
            for (Assesment j : AssesmentInfo) {
                System.out.println("Max Marks: "+j.maxMarks);
            }
        }
        System.out.print("Marks scored: ");
        int mm=sc.nextInt();

        GradeAssesment gg=new GradeAssesment(mm);
        GradeassInfo.add(gg);
    }

    private static void View_assesment(ArrayList<Assesment> AssesmentInfo) {
        for (Assesment i : AssesmentInfo) {
            if(i.quiz==null){ 
                System.out.println(i.prblm+", max marks: "+i.maxMarks);

            }

            if(i.prblm==null){
                System.out.println(i.quiz);

            }
            
        }
    }

    private static void View_material(ArrayList<Material> MaterialInfo) {
        for (Material i : MaterialInfo) {

            if(i.filename==null){
            System.out.print(" "+i.slide);
            }

            if(i.slide==null){
                System.out.print(" "+i.filename);
            }
            
        }
    }

    private static void Add_assesment(Scanner sc, ArrayList<Assesment> AssesmentInfo, int ch2) {
        if(ch2==1){
            sc.nextLine();
            System.out.print("Enter problem statement: ");
            String prblm = sc.nextLine();
            System.out.print("Enter max marks: ");
            int mm=sc.nextInt();

            Assesment obj1=new Assesment(prblm, mm);
            AssesmentInfo.add(obj1);
        }
        else if(ch2==2){
            sc.nextLine();
            System.out.print("Enter quiz question: ");
            String quizQuest = sc.nextLine();

            Assesment obj2 = new Assesment(quizQuest);
            AssesmentInfo.add(obj2);
        }
    }

    private static void Add_material(Scanner sc, ArrayList<Material> MaterialInfo, int ch1) {
        if(ch1==1){
            sc.nextLine();
            System.out.print("Enter topic of slides: ");
            String topicOfSlide=sc.nextLine();

            Material t = new Material(topicOfSlide);
            MaterialInfo.add(t);
            System.out.print("Enter number of slides: ");
            int Total_Slide=sc.nextInt();

            System.out.println("Enter content of slides");

                sc.nextLine();
                for(int j=1;j<=Total_Slide;j++){
                    System.out.print("Content of slide"+j+" : ");
                    String cont = sc.nextLine();
                    Material insObj = new Material(cont, Total_Slide);
                    MaterialInfo.add(insObj);
                }
                
        }
        else if(ch1==2){
            sc.nextLine();
            System.out.print("Enter topic of Video: ");
            String TopicOfVideo=sc.nextLine();

            Material t = new Material(TopicOfVideo);

            System.out.print("Enter filename of video: ");
            String fileName=sc.nextLine();
            String ext =".mp4";

            Date dt = new Date();
            Material d= new Material(dt); 
            MaterialInfo.add(d);
            if(fileName.contains(ext)){
                Material insobj1 = new Material(fileName);
                MaterialInfo.add(insobj1);
            }
            else{
                System.out.println("only mp4 extentive files are allowed...");
            }
            
        }
    }

    public static void Intro(){
        System.out.println("Welcome to Backpack");
        System.out.println("1. Enter as instructor");
        System.out.println("2. Enter as student");
        System.out.println("3. Exit");
        System.out.println();
    }

    public static void MenuForInstructor(){
        System.out.println("INSTRUCTOR MENU");
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessment");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");
    }

    public static void MenuForStudent(){
        System.out.println("STUDENT MENU");
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
    }

}


class Material{
    String slide;
    int NoOfSlide;
    String titleofslide;
    String titleofvideo;
    String filename;
    Date d;
    int id;

                public Material(String sld , int no){
                    this.slide=sld;
                    this.NoOfSlide=no;
                }
                public Material(String file){
                    this.filename=file;
                }

                public Material(int n){
                    this.NoOfSlide=n;
                }
                public Material(Date d){
                    this.d=d;
                }

}

class Assesment{
    String prblm;
    int maxMarks;
    String quiz;
    String pending;
    int assID;

                public Assesment(String prblm , int maxMarks ){
                    this.maxMarks=maxMarks;
                    this.prblm=prblm; 
                }

                public Assesment(String quiz){
                    this.quiz=quiz;
                    
                }
}

class GradeAssesment {
    int assID;
    String submission;
    int maxScore;
                    public GradeAssesment(int assID , String submission ){
                        this.assID=assID;
                        this.submission=submission;
                        
                    }

                    public GradeAssesment(int maxScore) {
                        this.maxScore=maxScore;
                    }
                    public GradeAssesment(String subm){
                        this.submission=subm;
                    }
}

class Comment {
    String cmtT;
    String cmtS;
    Date dateT;
    Date dateS;
                    public Comment(String cmtT , Date dateT ){
                        this.cmtT=cmtT;
                        this.dateT=dateT;
                    }
                    public Comment(Date dateS , String cmtS ){
                        this.dateS=dateS;
                        this.cmtS=cmtS;
                    }
}


interface Instructor{
    void Add_Material();
    void Add_Assesment();
    void view_material();
    void view_assesment();
    void grade_submission();
    void close_assesment();
    void view_comment();
    void add_comment(); 
}
interface student {
        void show_material();
        void show_assesment();
        void submit_assesment();
        void View_grades();
        void view_comment();
        void add_comments();
}

