import javax.swing.*;
import javax.swing.text.*;
import java.io.File;
import java.util.ArrayList;


public class ManageScreen extends JPanel {
    private JComboBox<String> survivedComboBox;
    private JComboBox<Integer> survivedComboBox2;
    private JComboBox<String> survivedComboBox3;
    private JComboBox<String> survivedComboBox4;
    private JComboBox<String> survivedComboBox5;
    private JComboBox<String> survivedComboBox6;
    private JComboBox<String> survivedComboBox7;
    private JComboBox<String> survivedComboBox8;
    private JComboBox<String> survivedComboBox9;
    private JComboBox<String> survivedComboBox10;
    private final JButton Filter = new JButton("Filter");
    private final JButton Statistics=new JButton("Statistics");
    private static String selectedClass="";
    private static String selectedName=("");
    private static String selectedGender="";
    private static String selectedSib=("");
    private static String selectedParch=("");
    private static String selectedTicket=("");
    private static String selectedFare=("");
    private static String selectedCabin=("");
    private static String selectedEmbarked=("");

    private static int totalRows;
    private static int survived;
    private static int deceased;

    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);
            this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox);

            this.survivedComboBox.addActionListener((e) -> {

                String num=(String) this.survivedComboBox.getSelectedItem();
                assert num != null;
                if(num.startsWith("1")){
                    selectedClass="1";
                }else {
                    if(num.startsWith("2")){
                        selectedClass="2";
                    }else {
                        if(num.startsWith("3")){
                            selectedClass="3";
                        }else {
                            if(num.equals("ALL")){
                                selectedClass="";
                            }
                        }
                    }
                }

            });



            JLabel survivedLabel2 = new JLabel("Passenger ID: ");
            survivedLabel2.setBounds(survivedComboBox.getX() + survivedComboBox.getWidth() + Constants.gap * 8, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel2);
            this.survivedComboBox2 = new JComboBox<>();
            this.survivedComboBox2.setBounds(survivedLabel2.getX() + survivedLabel2.getWidth(), y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.survivedComboBox2.setEditable(true);
            this.survivedComboBox2.setPrototypeDisplayValue(3);
            this.add(survivedComboBox2);

            JTextComponent editor1 = (JTextComponent) this.survivedComboBox2.getEditor().getEditorComponent();
            DocumentFilter filter1 = new DocumentFilter() {
                public void insertString(FilterBypass filterBypass, int offset, String string, AttributeSet attributeSet) throws BadLocationException {
                    if ((filterBypass.getDocument().getLength() + string.length()) <= 3) {
                        super.insertString(filterBypass, offset, string, attributeSet);
                    }
                }

                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 3) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument) editor1.getDocument()).setDocumentFilter(filter1);

            this.survivedComboBox2.addActionListener(e -> {
                String IDNumber = (String) this.survivedComboBox2.getEditor().getItem();
                int num;
                if(IDNumber.matches("[^0-9],{3}")) {
                    num = Integer.parseInt(IDNumber);
                    Passenger[] passengersByArray=Test.getPassengers().toArray(new Passenger[0]);
                    for(int i=0;i<passengersByArray.length-num;i++){
                        ArrayList<Passenger> basedOnID=new ArrayList<>();

                    }
                }else {
                    IDNumber=null;
                }
                //System.out.println(IDNumber);
            });


            JLabel survivedLabel3 = new JLabel("Passenger Name: ");
            survivedLabel3.setBounds(x + Constants.MARGIN_FROM_LEFT, survivedComboBox.getY() + survivedComboBox.getHeight() + Constants.gap * 3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel3);
            this.survivedComboBox3 = new JComboBox<>();
            this.survivedComboBox3.setBounds(survivedLabel3.getX() + survivedLabel3.getWidth(), survivedLabel3.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.survivedComboBox3.setEditable(true);
            this.add(survivedComboBox3);

          /*  JTextComponent editor2=(JTextComponent)PassengerNameComboBox.getEditor().getEditorComponent();
            DocumentFilter filter2=new DocumentFilter(){
                public void insertString(FilterBypass filterBypass,int offset,String string,AttributeSet attributeSet)throws BadLocationException{
                    if((filterBypass.getDocument().getLength()+string.length())<=3){
                        super.insertString(filterBypass,offset,string,attributeSet);
                    }
                }
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 3) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument)editor2.getDocument()).setDocumentFilter(filter2);*/

            this.survivedComboBox3.addActionListener(e -> {
                String passengerName = (String) this.survivedComboBox3.getEditor().getItem();
                selectedName=passengerName;
                System.out.println("name "+passengerName);
            });

            JLabel survivedLabel4 = new JLabel("Passenger Sex: ");
            survivedLabel4.setBounds(survivedLabel2.getX(), survivedComboBox.getY() + survivedComboBox.getHeight() + Constants.gap * 3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel4);
            this.survivedComboBox4 = new JComboBox<>(Constants.PASSENGERS_SEX_OPTIONS);
            this.survivedComboBox4.setBounds(survivedLabel4.getX() + survivedLabel4.getWidth(), survivedLabel4.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox4);

            this.survivedComboBox4.addActionListener(e -> {
                selectedGender = (String) survivedComboBox4.getSelectedItem();
                System.out.println(selectedGender);
            });


            JLabel survivedLabel5 = new JLabel("Passenger Sib/Sum: ");
            survivedLabel5.setBounds(survivedLabel3.getX(), this.survivedComboBox3.getY() + this.survivedComboBox3.getHeight() + Constants.gap * 3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel5);
            this.survivedComboBox5 = new JComboBox<>();
            this.survivedComboBox5.setBounds(survivedLabel5.getX() + survivedLabel5.getWidth(), survivedLabel5.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.survivedComboBox5.setEditable(true);
            this.add(survivedComboBox5);

            JTextComponent editor3 = (JTextComponent) this.survivedComboBox5.getEditor().getEditorComponent();
            DocumentFilter filter3 = new DocumentFilter() {
                public void insertString(FilterBypass filterBypass, int offset, String string, AttributeSet attributeSet) throws BadLocationException {
                    if ((filterBypass.getDocument().getLength() + string.length()) <= 3) {
                        super.insertString(filterBypass, offset, string, attributeSet);
                    }
                }

                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 1) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument) editor3.getDocument()).setDocumentFilter(filter3);

            this.survivedComboBox5.addActionListener(e -> {
                selectedSib = (String) this.survivedComboBox5.getSelectedItem();
                System.out.println(selectedSib);
            });

            JLabel survivedLabel6 = new JLabel("Passenger Parch: ");
            survivedLabel6.setBounds(survivedLabel4.getX(), survivedLabel5.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel6);
            this.survivedComboBox6 = new JComboBox<>();
            this.survivedComboBox6.setBounds(survivedLabel6.getX() + survivedLabel6.getWidth(), survivedLabel6.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.survivedComboBox6.setEditable(true);
            this.add(survivedComboBox6);

            JTextComponent editor4 = (JTextComponent) this.survivedComboBox6.getEditor().getEditorComponent();
            DocumentFilter filter4 = new DocumentFilter() {
                public void insertString(FilterBypass filterBypass, int offset, String string, AttributeSet attributeSet) throws BadLocationException {
                    if ((filterBypass.getDocument().getLength() + string.length()) <= 3) {
                        super.insertString(filterBypass, offset, string, attributeSet);
                    }
                }

                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 1) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument) editor4.getDocument()).setDocumentFilter(filter4);

            this.survivedComboBox6.addActionListener(e -> {
                selectedParch = (String) this.survivedComboBox6.getSelectedItem();
                System.out.println(selectedParch);
            });


            JLabel survivedLabel7 = new JLabel("Passenger Ticket: ");
            survivedLabel7.setBounds(survivedLabel5.getX(), this.survivedComboBox5.getY() + this.survivedComboBox5.getHeight() + Constants.gap * 3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel7);
            this.survivedComboBox7 = new JComboBox<String>();
            this.survivedComboBox7.setBounds(survivedLabel7.getX() + survivedLabel7.getWidth(), survivedLabel7.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.survivedComboBox7.setEditable(true);
            this.add(survivedComboBox7);

            JTextComponent editor5 = (JTextComponent) this.survivedComboBox7.getEditor().getEditorComponent();
            DocumentFilter filter5 = new DocumentFilter() {
                public void insertString(FilterBypass filterBypass, int offset, String string, AttributeSet attributeSet) throws BadLocationException {
                    if ((filterBypass.getDocument().getLength() + string.length()) <= 3) {
                        super.insertString(filterBypass, offset, string, attributeSet);
                    }
                }

                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 1) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument) editor5.getDocument()).setDocumentFilter(filter5);
            this.survivedComboBox7.addActionListener(e -> {
                selectedTicket = (String) this.survivedComboBox7.getSelectedItem();
                System.out.println(selectedTicket);
            });

            JLabel survivedLabel8 = new JLabel("Passenger Fare");
            survivedLabel8.setBounds(survivedLabel6.getX(), survivedLabel7.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel8);
            this.survivedComboBox8 = new JComboBox<>();
            this.survivedComboBox8.setBounds(survivedLabel8.getX() + survivedLabel8.getWidth(), survivedLabel8.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.survivedComboBox8.setEditable(true);
            this.add(survivedComboBox8);

            JTextComponent editor6 = (JTextComponent) this.survivedComboBox8.getEditor().getEditorComponent();
            DocumentFilter filter6 = new DocumentFilter() {
                public void insertString(FilterBypass filterBypass, int offset, String string, AttributeSet attributeSet) throws BadLocationException {
                    if ((filterBypass.getDocument().getLength() + string.length()) <= 3) {
                        super.insertString(filterBypass, offset, string, attributeSet);
                    }
                }
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 1) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument) editor6.getDocument()).setDocumentFilter(filter6);
            this.survivedComboBox8.addActionListener(e -> {
                selectedFare = (String) this.survivedComboBox8.getSelectedItem();
                System.out.println(selectedFare);
            });

            JLabel survivedLabel9 = new JLabel("Passenger Cabin");
            survivedLabel9.setBounds(survivedLabel7.getX(), this.survivedComboBox7.getY() + this.survivedComboBox7.getHeight() + Constants.gap * 3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel9);
            this.survivedComboBox9 = new JComboBox<>();
            this.survivedComboBox9.setBounds(survivedLabel9.getX() + survivedLabel9.getWidth(), survivedLabel9.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.survivedComboBox9.setEditable(true);
            this.add(survivedComboBox9);

            JTextComponent editor7 = (JTextComponent) this.survivedComboBox9.getEditor().getEditorComponent();
            DocumentFilter filter7 = new DocumentFilter() {
                public void insertString(FilterBypass filterBypass, int offset, String string, AttributeSet attributeSet) throws BadLocationException {
                    if ((filterBypass.getDocument().getLength() + string.length()) <= 3) {
                        super.insertString(filterBypass, offset, string, attributeSet);
                    }
                }
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() - length + text.length()) <= 1) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            };
            ((AbstractDocument) editor7.getDocument()).setDocumentFilter(filter7);
            this.survivedComboBox9.addActionListener(e -> {
                selectedCabin = (String) this.survivedComboBox9.getSelectedItem();
                System.out.println(selectedCabin);
            });


            JLabel survivedLabel10 = new JLabel("Passenger Embarked: ");
            survivedLabel10.setBounds(survivedLabel8.getX(), survivedLabel9.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel10);
            this.survivedComboBox10 = new JComboBox<>(Constants.PASSENGER_PORT_OPTIONS);
            this.survivedComboBox10.setBounds(survivedLabel10.getX() + survivedLabel10.getWidth(), survivedLabel10.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(survivedComboBox10);
            this.survivedComboBox10.addActionListener(e -> {
                selectedEmbarked = (String) survivedComboBox10.getSelectedItem();
                System.out.println(selectedEmbarked);
            });

            Filter.setBounds(survivedLabel9.getX()+Constants.gap*3,survivedLabel9.getY()+survivedLabel9.getHeight()+Constants.gap*5,Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
            this.add(Filter);
            Filter.addActionListener(e -> {
                for(Passenger passenger:Test.getPassengers()){
                    boolean matchClass=selectedClass.equals("")|| selectedClass.equals(passenger.getPclass());
                    boolean matchName=selectedName.equals("")||selectedName.equals(passenger.getName());
                    boolean matchGender=selectedGender.equals("")||selectedGender.equals(passenger.getSex());
                    boolean matchSib=selectedSib.equals("")||passenger.getSibSP().startsWith(selectedSib);
                    boolean matchParch=selectedParch.equals("")||passenger.getParch().startsWith(selectedParch);
                    boolean matchTicket=selectedTicket.equals("")||passenger.getTicket().startsWith(selectedTicket);
                    boolean matchFare=selectedFare.equals("")||selectedFare.equals(passenger.getFare());
                    boolean matchCabin=selectedCabin.equals("")||passenger.getCabin().startsWith(selectedCabin);
                    boolean matchEmbarked=selectedEmbarked.equals("")||passenger.getEmbarked().startsWith(selectedEmbarked);

                    if(matchClass && matchName&&matchGender&&matchSib&&matchParch&&matchTicket&&matchFare&&matchCabin&&matchEmbarked){
                        totalRows++;
                        if(passenger.getSurvived().equals("0")){
                            deceased++;
                        }
                        if(passenger.getSurvived().equals("1")){
                            survived++;
                        }

                    }
                }
                System.out.println("Total Rows: "+totalRows+"("+survived+" survived, "+deceased+" did not)");
                totalRows=0; survived=0; deceased=0;
            });


            Statistics.setBounds(Constants.WINDOW_WIDTH-Filter.getX()-Filter.getWidth(),Filter.getY(),Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
            this.add(Statistics);
            Statistics.addActionListener(e -> {

            });


        }

    }

}