
package Codes;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Accounts extends javax.swing.JFrame {
    
     Connection con;


    public Accounts() {
        initComponents();
        NavPanel.setVisible(true);
        CPanel2.setVisible(false);
        CPanel3.setVisible(false);
        ExitBox.setVisible(true);
        AP.setVisible(false);
        FP.setVisible(false);
        SDP.setVisible(false);
        MP.setVisible(false);
        LP.setVisible(false);
        ExView2.setVisible(false);
        ExView1.setVisible(false);
        ViewPanel.setVisible(true);
        AddPanel.setVisible(false);
        UpdatePanel.setVisible(false);
        DeletePanel.setVisible(false);
        ExitBox.setVisible(false);
        AccDelPanel.setVisible(false);
        AccUpdatePanel.setVisible(false);
        AccDisplayPanel.setVisible(true);
        AccAddPanel.setVisible(false);
        SeedNavPanel.setVisible(true);
        SeedDisplayPanel.setVisible(false);
        SeedAddPanel.setVisible(false);
        SeedUpdatePanel.setVisible(false);
        SeedDelPanel.setVisible(false);
    }
    void createConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccapstone","root","5566");

    }
     
    void getFNMData(String name) throws Exception{
        String query = "select * from FNM where name = '"+name+"';";
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            Cat_Up.setText(rs.getString("Category"));
            Name_Up.setText(rs.getString("Name"));
            Price_Up.setText(rs.getString("Price"));
            Cat_del.setText(rs.getString("Category"));
            Name_del.setText(rs.getString("Name"));
            Price_del.setText(rs.getString("Price"));
            while(jTable6.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable6.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable6.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    void filterFNMData(String attr,String value) throws Exception{
        String query = "select * from FNM where "+ attr +" = '"+ value +"';";   
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(jTable6.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable6.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable6.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void loadFNMData() throws Exception{
        String query = "select * from FNM";        
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(jTable6.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable6.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable6.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    void insertFNMData(String Category, String name, float Price) throws Exception{
        String query = "insert into FNM values ('"+Category+"' ,'"+name+"', "+Price+")";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void updateFNMData(String Category, String name, float Price) throws Exception{
        String query = "update FNM set Category = '"+Category+"', Name = '"+name+"', Price = "+Price+ "where Name = '"+name+"';";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void dropFNMData(String name) throws Exception{
        String query = "delete from FNM where name = '"+name+"';";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void getLoanData(int Loan_ID) throws Exception{
        String query = "select * from Loans where Loan_ID = "+Loan_ID+";";        
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            BankU.setText(rs.getString("Bank"));
            Loan_TypeU.setText(rs.getString("Loan_Type"));
            Loan_IdU.setText(Integer.toString(rs.getInt("Loan_Id")));
            InterestU.setText(Integer.toString(rs.getInt("Interest")));
            DurationU.setText(Integer.toString(rs.getInt("Duration")));
            TotalU.setText(Integer.toString(rs.getInt("Total")));
            LoanF_IdU.setText(rs.getString("FId"));
            LStatusU.setText(rs.getString("LStatus"));
            BankD.setText(rs.getString("Bank"));
            Loan_TypeD.setText(rs.getString("Loan_Type"));
            Loan_IdD.setText(Integer.toString(rs.getInt("Loan_Id")));
            InterestD.setText(Integer.toString(rs.getInt("Interest")));
            DurationD.setText(Integer.toString(rs.getInt("Duration")));
            TotalD.setText(Integer.toString(rs.getInt("Total")));
            F_IdD3.setText(rs.getString("FId"));
            LStatusD.setText(rs.getString("LStatus"));
            while(jTable3.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable3.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable3.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void filterLoansData(String attr,String value) throws Exception{
        String query = "select * from Loans where "+attr+" = "+value+";";   
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(jTable3.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable3.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable3.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void loadLoansData() throws Exception{
        String query = "select * from Loans";        
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(jTable3.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable3.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable3.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void insertLoansData(int Loan_Id,String Loan_Type,String Bank,float Interest,int Duration,float Total, String FId,String LStatus) throws Exception{
        String query = "insert into Loans values ("+Loan_Id+", '"+Loan_Type+"', '"+Bank+"', "+Interest+", "+Duration+", "+Total+",'"+FId+"', '"+LStatus+"');";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void updateLoanData(int Loan_Id,String Loan_Type,String Bank,float Interest,int Duration,int Total, String FId,String LStatus) throws Exception{
        String query = "update Loans set Loan_Type = '"+Loan_Type+"',Bank = '"+Bank+"',LStatus = '"+LStatus+"', Total = "+Total+",Duration = "+Duration+",Interest = "+Interest+" , FId = '"+FId +"' where Loan_Id = "+Loan_Id+";";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void dropLoansData(int Loan_Id) throws Exception{
        String query = "delete from Loans where Loan_Id = "+Loan_Id+";";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    void getMachinesData(int MId) throws Exception{
        String query = "select * from Machines where MId = "+MId+";";
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            MTypeU.setText(rs.getString("MachineType"));
            PriceU.setText(rs.getString("Price"));
            BrandU.setText(rs.getString("Brand"));
            F_IdU.setText(rs.getString("FId"));
            MTypeD.setText(rs.getString("MachineType"));
            PriceD.setText(rs.getString("Price"));
            BrandD.setText(rs.getString("Brand"));
            F_IdD.setText(rs.getString("FId"));
            while(jTable1.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable1.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable1.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void filterMachinesData(String attr,String value) throws Exception{
        String query = "select * from Machines where "+attr+" = "+value+";";   
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(jTable1.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable1.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable1.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    void loadMachinesData() throws Exception{
        String query = "select * from Machines";        
        try {
            createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(jTable1.getRowCount() > 0)
            {
                ((DefaultTableModel)jTable1.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable1.getModel()).insertRow(rs.getRow()-1, rows);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    void insertMachinesData(int MId,String MType,float Price,String Brand,String FId) throws Exception{
        String query = "insert into Machines values ("+MId+",'"+MType+"', "+Price+", '"+Brand+"', '"+FId +"')";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void updateMachinesData(int MId,String MType,float Price,String Brand,String FId) throws Exception{
        String query = "update Machines set MachineType = '"+MType+"', Price = "+Price+", Brand = '"+Brand+"', FId = '"+FId +"' where MId = "+MId+";";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
    void dropMachinesData(int MId) throws Exception{
        String query = "delete from Machines where MId = "+MId+";";
        try {
            createConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public void setColor(JPanel jpanl){
        jpanl.setBackground(new Color(131,239,138));
    }
    public void resetColor(JPanel jpanl){
        jpanl.setBackground(new Color(205,222,255));
    }
    public boolean ifclk(MouseEvent clkm){
        return clkm.getButton() == MouseEvent.BUTTON1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        ExitBox = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        CloseIcon1 = new javax.swing.JLabel();
        side_window = new javax.swing.JPanel();
        AccountsTab = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FertilizersTab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        SeedsTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        MachinesTab = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LoansTab = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        StatusTab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AP = new javax.swing.JPanel();
        NavPanel6 = new javax.swing.JPanel();
        ViewButton6 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        AddButton6 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        UpdateButton6 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        DeleteButton6 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        AccAddPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        inputFid = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        inputAddress = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        inputArea = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        inputLandid = new javax.swing.JTextField();
        inputSoil = new javax.swing.JTextField();
        AccDisplayPanel = new javax.swing.JPanel();
        DisplayButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        AccUpdatePanel = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        editFid = new javax.swing.JTextField();
        editLid = new javax.swing.JTextField();
        editName = new javax.swing.JTextField();
        editAdd = new javax.swing.JTextField();
        editLa = new javax.swing.JTextField();
        editSoil = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        refresh1 = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        AccDelPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        ShowDelAcc = new javax.swing.JButton();
        FP = new javax.swing.JPanel();
        NavPanel_FP = new javax.swing.JPanel();
        ViewButton_FP = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        AddButton_FP = new javax.swing.JPanel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        UpdateButton_FP = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        DeleteButton_FP = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        ViewPanel_FP = new javax.swing.JPanel();
        CPanel20 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        FilVal5 = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        Search5 = new javax.swing.JButton();
        Refresh5 = new javax.swing.JButton();
        FilAttr5 = new javax.swing.JComboBox<>();
        AddPanel_FP = new javax.swing.JPanel();
        CPanel21 = new javax.swing.JPanel();
        AddRecord5 = new javax.swing.JButton();
        PriceBox = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        NameBox = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        CatBox = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        UpdatePanel_FP = new javax.swing.JPanel();
        CPanel22 = new javax.swing.JPanel();
        ExView_FP_Up = new javax.swing.JPanel();
        Price_Up = new javax.swing.JTextField();
        Cat_Up = new javax.swing.JTextField();
        Name_Up = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        Update_FP = new javax.swing.JButton();
        Extract10 = new javax.swing.JButton();
        NameBox1 = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        DeletePanel_FP = new javax.swing.JPanel();
        CPanel23 = new javax.swing.JPanel();
        ExView_FP_del = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        Name_del = new javax.swing.JTextField();
        Cat_del = new javax.swing.JTextField();
        Price_del = new javax.swing.JTextField();
        Drop_FP = new javax.swing.JButton();
        Extract11 = new javax.swing.JButton();
        NameBox2 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        SDP = new javax.swing.JPanel();
        SeedNavPanel = new javax.swing.JPanel();
        SeedViewNav = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        SeedAddNav = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        SeedUpdateNav = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        SeedDelNav = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        SeedDisplayPanel = new javax.swing.JPanel();
        DisplaySeeds = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        SeedDisp = new javax.swing.JTable();
        jLabel73 = new javax.swing.JLabel();
        SeedAddPanel = new javax.swing.JPanel();
        InsertSeed = new javax.swing.JButton();
        inputSeedType = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        inputSeedQuantity = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        inputSeedGrade = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        inputSeedPrice = new javax.swing.JTextField();
        SeedUpdatePanel = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        SeedUpTable = new javax.swing.JTable();
        SeedUpEdit = new javax.swing.JButton();
        editStype = new javax.swing.JTextField();
        editPrice = new javax.swing.JTextField();
        editQuantity = new javax.swing.JTextField();
        editGrade = new javax.swing.JTextField();
        SeedUpUpdate = new javax.swing.JButton();
        SeedUpRefresh = new javax.swing.JButton();
        SeedUpShow = new javax.swing.JButton();
        SeedDelPanel = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        SeedDelTable = new javax.swing.JTable();
        DeleteSeed = new javax.swing.JButton();
        RefreshDelSeed = new javax.swing.JButton();
        ShowDelSeed = new javax.swing.JButton();
        MP = new javax.swing.JPanel();
        NavPanel = new javax.swing.JPanel();
        ViewButton = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AddButton = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        ViewPanel = new javax.swing.JPanel();
        CPanel = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        FilVal = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        FilAttr = new javax.swing.JComboBox<>();
        AddPanel = new javax.swing.JPanel();
        CPanel1 = new javax.swing.JPanel();
        AddRecord = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        F_IdA = new javax.swing.JTextField();
        BrandA = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        PriceA = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        MTypeA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        M_IdA = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        UpdatePanel = new javax.swing.JPanel();
        CPanel2 = new javax.swing.JPanel();
        ExView1 = new javax.swing.JPanel();
        F_IdU = new javax.swing.JTextField();
        BrandU = new javax.swing.JTextField();
        PriceU = new javax.swing.JTextField();
        MTypeU = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        Extract = new javax.swing.JButton();
        M_IdU = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        DeletePanel = new javax.swing.JPanel();
        CPanel3 = new javax.swing.JPanel();
        ExView2 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        MTypeD = new javax.swing.JTextField();
        PriceD = new javax.swing.JTextField();
        BrandD = new javax.swing.JTextField();
        F_IdD = new javax.swing.JTextField();
        DeleteRecord = new javax.swing.JButton();
        Extract1 = new javax.swing.JButton();
        M_IdD = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        LP = new javax.swing.JPanel();
        LoanNavPanel = new javax.swing.JPanel();
        ViewButton2 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        AddButton2 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        UpdateButton2 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        DeleteButton2 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        LoanViewPanel = new javax.swing.JPanel();
        CPanel8 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        FilVal2 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        Search2 = new javax.swing.JButton();
        Refresh2 = new javax.swing.JButton();
        FilAttr2 = new javax.swing.JComboBox<>();
        LoanAddPanel = new javax.swing.JPanel();
        CPanel9 = new javax.swing.JPanel();
        AddRecord2 = new javax.swing.JButton();
        DurationA = new javax.swing.JTextField();
        InterestA = new javax.swing.JTextField();
        LoanTypeA = new javax.swing.JTextField();
        LoanBankA = new javax.swing.JTextField();
        LStatusA = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        TotalA = new javax.swing.JTextField();
        LoanIDA = new javax.swing.JTextField();
        LoanFIdA = new javax.swing.JTextField();
        LoanUpdatePanel = new javax.swing.JPanel();
        CPanel10 = new javax.swing.JPanel();
        ExView5 = new javax.swing.JPanel();
        LStatusU = new javax.swing.JTextField();
        InterestU = new javax.swing.JTextField();
        Loan_TypeU = new javax.swing.JTextField();
        BankU = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        SaveButton2 = new javax.swing.JButton();
        DurationU = new javax.swing.JTextField();
        TotalU = new javax.swing.JTextField();
        Loan_IdU = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        LoanF_IdU = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        Extract4 = new javax.swing.JButton();
        Loan_IdU1 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        LoanDeletePanel = new javax.swing.JPanel();
        CPanel11 = new javax.swing.JPanel();
        LoanDelExtract = new javax.swing.JButton();
        Loan_IdD2 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        ExView7 = new javax.swing.JPanel();
        LStatusD = new javax.swing.JTextField();
        InterestD = new javax.swing.JTextField();
        Loan_TypeD = new javax.swing.JTextField();
        BankD = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        LoanDeleteRec = new javax.swing.JButton();
        DurationD = new javax.swing.JTextField();
        TotalD = new javax.swing.JTextField();
        Loan_IdD = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        F_IdD3 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HELLOWORLD");
        setLocationByPlatform(true);
        setUndecorated(true);

        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Background.setMinimumSize(new java.awt.Dimension(1150, 700));
        Background.setPreferredSize(new java.awt.Dimension(1150, 700));
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        Background.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BackgroundFocusLost(evt);
            }
        });
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitBox.setBackground(new java.awt.Color(0, 0, 0));
        ExitBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("-");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        ExitBox.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 20));

        CloseIcon1.setBackground(new java.awt.Color(255, 0, 0));
        CloseIcon1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CloseIcon1.setForeground(new java.awt.Color(255, 0, 0));
        CloseIcon1.setText("X");
        CloseIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseIcon1MousePressed(evt);
            }
        });
        ExitBox.add(CloseIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 20, -1));

        Background.add(ExitBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 30));

        side_window.setBackground(new java.awt.Color(205, 222, 255));
        side_window.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AccountsTab.setBackground(new java.awt.Color(131, 239, 138));
        AccountsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountsTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AccountsTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AccountsTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AccountsTabMousePressed(evt);
            }
        });
        AccountsTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Account");
        AccountsTab.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 150, 24));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon1.png"))); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(42, 50));
        AccountsTab.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 42, 50));

        side_window.add(AccountsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 300, 50));

        FertilizersTab.setBackground(new java.awt.Color(205, 222, 255));
        FertilizersTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FertilizersTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FertilizersTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FertilizersTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FertilizersTabMousePressed(evt);
            }
        });
        FertilizersTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fertilizers and Manures");
        FertilizersTab.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 187, 24));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon2.png"))); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(42, 50));
        FertilizersTab.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 42, 50));

        side_window.add(FertilizersTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 300, 50));

        SeedsTab.setBackground(new java.awt.Color(205, 222, 255));
        SeedsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeedsTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SeedsTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SeedsTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SeedsTabMousePressed(evt);
            }
        });
        SeedsTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Seed Directory");
        SeedsTab.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 187, 24));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon3.png"))); // NOI18N
        jLabel15.setPreferredSize(new java.awt.Dimension(42, 50));
        SeedsTab.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 42, 50));

        side_window.add(SeedsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 300, 50));

        MachinesTab.setBackground(new java.awt.Color(205, 222, 255));
        MachinesTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MachinesTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MachinesTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MachinesTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MachinesTabMousePressed(evt);
            }
        });
        MachinesTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Machines");
        MachinesTab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 187, 24));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon4.png"))); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(42, 50));
        MachinesTab.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 42, 50));

        side_window.add(MachinesTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 300, 50));

        LoansTab.setBackground(new java.awt.Color(205, 222, 255));
        LoansTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoansTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoansTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoansTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoansTabMousePressed(evt);
            }
        });
        LoansTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Loan");
        LoansTab.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 187, 24));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon5.png"))); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(42, 50));
        LoansTab.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 42, 50));

        side_window.add(LoansTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 300, 50));

        StatusTab.setBackground(new java.awt.Color(205, 222, 255));
        StatusTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StatusTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StatusTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StatusTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StatusTabMousePressed(evt);
            }
        });
        StatusTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Logout");
        StatusTab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 150, 24));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logout-removebg-preview.png"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(42, 50));
        StatusTab.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 30));

        side_window.add(StatusTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        side_window.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 78));

        Background.add(side_window, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 700));

        AP.setBackground(new java.awt.Color(103, 111, 163));
        AP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                APMouseClicked(evt);
            }
        });
        AP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavPanel6.setBackground(new java.awt.Color(255, 204, 255));
        NavPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewButton6.setBackground(new java.awt.Color(153, 153, 255));
        ViewButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewButton6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewButton6MousePressed(evt);
            }
        });
        ViewButton6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("View");
        ViewButton6.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ViewIcon.png"))); // NOI18N
        jLabel61.setPreferredSize(new java.awt.Dimension(42, 50));
        ViewButton6.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel6.add(ViewButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 97, 70));

        AddButton6.setBackground(new java.awt.Color(153, 153, 255));
        AddButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddButton6MousePressed(evt);
            }
        });
        AddButton6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Add");
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel62MousePressed(evt);
            }
        });
        AddButton6.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, 20));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AddIcon.png"))); // NOI18N
        jLabel63.setPreferredSize(new java.awt.Dimension(42, 50));
        AddButton6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel6.add(AddButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, -1));

        UpdateButton6.setBackground(new java.awt.Color(153, 153, 255));
        UpdateButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButton6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateButton6MousePressed(evt);
            }
        });
        UpdateButton6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Update");
        UpdateButton6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, -1));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/UpdateIcon.png"))); // NOI18N
        jLabel65.setPreferredSize(new java.awt.Dimension(42, 50));
        UpdateButton6.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel6.add(UpdateButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 70));

        DeleteButton6.setBackground(new java.awt.Color(153, 153, 255));
        DeleteButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButton6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteButton6MousePressed(evt);
            }
        });
        DeleteButton6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("Delete");
        DeleteButton6.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DeleteIcon.png"))); // NOI18N
        jLabel100.setPreferredSize(new java.awt.Dimension(42, 50));
        DeleteButton6.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel6.add(DeleteButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 70));

        AP.add(NavPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 520, 90));

        AccAddPanel.setBackground(new java.awt.Color(103, 111, 163));
        AccAddPanel.setPreferredSize(new java.awt.Dimension(850, 700));

        jButton1.setBackground(new java.awt.Color(64, 255, 0));
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel53.setForeground(new java.awt.Color(250, 250, 250));
        jLabel53.setText("Soil Type:");

        inputFid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFidActionPerformed(evt);
            }
        });

        jLabel54.setForeground(new java.awt.Color(250, 250, 250));
        jLabel54.setText("F_ID:");

        jLabel55.setForeground(new java.awt.Color(250, 250, 250));
        jLabel55.setText("LandID:");

        jLabel56.setForeground(new java.awt.Color(250, 250, 250));
        jLabel56.setText("Name:");

        jLabel57.setForeground(new java.awt.Color(250, 250, 250));
        jLabel57.setText("Address:");

        jLabel58.setForeground(new java.awt.Color(250, 250, 250));
        jLabel58.setText("Land area:");

        jLabel59.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(250, 250, 250));
        jLabel59.setText("Add Records");

        inputLandid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLandidActionPerformed(evt);
            }
        });

        inputSoil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSoilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AccAddPanelLayout = new javax.swing.GroupLayout(AccAddPanel);
        AccAddPanel.setLayout(AccAddPanelLayout);
        AccAddPanelLayout.setHorizontalGroup(
            AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccAddPanelLayout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(AccAddPanelLayout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel59)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AccAddPanelLayout.createSequentialGroup()
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccAddPanelLayout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(AccAddPanelLayout.createSequentialGroup()
                                    .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel56)
                                            .addComponent(jLabel55)))
                                    .addGap(51, 51, 51)
                                    .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputLandid, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                        .addComponent(inputFid)
                                        .addComponent(inputName)))
                                .addGroup(AccAddPanelLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel57)))
                            .addGroup(AccAddPanelLayout.createSequentialGroup()
                                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel58))
                                .addGap(333, 333, 333))))
                    .addGroup(AccAddPanelLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputArea)
                            .addComponent(inputAddress)
                            .addComponent(inputSoil))))
                .addGap(221, 221, 221))
        );
        AccAddPanelLayout.setVerticalGroup(
            AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccAddPanelLayout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(32, 32, 32)
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(18, 18, 18)
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLandid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(30, 30, 30)
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(24, 24, 24)
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(18, 18, 18)
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addGroup(AccAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSoil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addGap(120, 120, 120))
        );

        AP.add(AccAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        AccDisplayPanel.setBackground(new java.awt.Color(103, 111, 163));
        AccDisplayPanel.setPreferredSize(new java.awt.Dimension(850, 700));

        DisplayButton.setBackground(new java.awt.Color(64, 255, 0));
        DisplayButton.setText("Display Table");
        DisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayButtonActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "F_ID", "Land ID", "Name", "Address", "Land Area", "Soil Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table2);

        jLabel66.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(250, 250, 250));
        jLabel66.setText("Display Farmers Database");

        javax.swing.GroupLayout AccDisplayPanelLayout = new javax.swing.GroupLayout(AccDisplayPanel);
        AccDisplayPanel.setLayout(AccDisplayPanelLayout);
        AccDisplayPanelLayout.setHorizontalGroup(
            AccDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccDisplayPanelLayout.createSequentialGroup()
                .addGroup(AccDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccDisplayPanelLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel66))
                    .addGroup(AccDisplayPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AccDisplayPanelLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(DisplayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        AccDisplayPanelLayout.setVerticalGroup(
            AccDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccDisplayPanelLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel66)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DisplayButton)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        AP.add(AccDisplayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        AccUpdatePanel.setBackground(new java.awt.Color(103, 111, 163));

        jLabel67.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(250, 250, 250));
        jLabel67.setText("Update Table");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "F_ID", "Land ID", "Name", "Address", "Land Area", "Soil Type"
            }
        ));
        jScrollPane7.setViewportView(table1);

        editButton.setBackground(new java.awt.Color(64, 255, 0));
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        editName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNameActionPerformed(evt);
            }
        });

        editSoil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSoilActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(64, 255, 0));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        refresh1.setBackground(new java.awt.Color(64, 255, 0));
        refresh1.setText("Refresh");
        refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh1ActionPerformed(evt);
            }
        });

        Show.setText("Show");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AccUpdatePanelLayout = new javax.swing.GroupLayout(AccUpdatePanel);
        AccUpdatePanel.setLayout(AccUpdatePanelLayout);
        AccUpdatePanelLayout.setHorizontalGroup(
            AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccUpdatePanelLayout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addGroup(AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(AccUpdatePanelLayout.createSequentialGroup()
                            .addComponent(editFid, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(editLid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(editName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(editAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(editLa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(editSoil, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AccUpdatePanelLayout.createSequentialGroup()
                            .addComponent(update)
                            .addGap(31, 31, 31)
                            .addComponent(refresh1)))
                    .addGroup(AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AccUpdatePanelLayout.createSequentialGroup()
                            .addGap(257, 257, 257)
                            .addComponent(jLabel67))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccUpdatePanelLayout.createSequentialGroup()
                            .addComponent(Show)
                            .addGap(18, 18, 18)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        AccUpdatePanelLayout.setVerticalGroup(
            AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccUpdatePanelLayout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(Show))
                .addGap(18, 18, 18)
                .addGroup(AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSoil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editLid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editLa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(AccUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refresh1)
                    .addComponent(update))
                .addGap(101, 101, 101))
        );

        AP.add(AccUpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        AccDelPanel.setBackground(new java.awt.Color(103, 111, 163));

        jLabel27.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(250, 250, 250));
        jLabel27.setText("Delete Records");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "F_ID", "Land ID", "Name", "Address", "Land Area", "Soil Type"
            }
        ));
        jScrollPane2.setViewportView(table);

        Delete.setBackground(new java.awt.Color(64, 255, 0));
        Delete.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(64, 255, 0));
        refresh.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        ShowDelAcc.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        ShowDelAcc.setText("Show");
        ShowDelAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDelAccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AccDelPanelLayout = new javax.swing.GroupLayout(AccDelPanel);
        AccDelPanel.setLayout(AccDelPanelLayout);
        AccDelPanelLayout.setHorizontalGroup(
            AccDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccDelPanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(AccDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccDelPanelLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel27))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AccDelPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(ShowDelAcc)
                        .addGap(76, 76, 76)
                        .addComponent(Delete)
                        .addGap(84, 84, 84)
                        .addComponent(refresh)))
                .addGap(58, 58, 58))
        );
        AccDelPanelLayout.setVerticalGroup(
            AccDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccDelPanelLayout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(AccDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(refresh)
                    .addComponent(ShowDelAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );

        AP.add(AccDelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        Background.add(AP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 700));

        FP.setBackground(new java.awt.Color(103, 111, 163));
        FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FPMouseClicked(evt);
            }
        });
        FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavPanel_FP.setBackground(new java.awt.Color(255, 204, 255));
        NavPanel_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewButton_FP.setBackground(new java.awt.Color(153, 153, 255));
        ViewButton_FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewButton_FPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewButton_FPMousePressed(evt);
            }
        });
        ViewButton_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setText("View");
        ViewButton_FP.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ViewIcon.png"))); // NOI18N
        jLabel174.setPreferredSize(new java.awt.Dimension(42, 50));
        ViewButton_FP.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel_FP.add(ViewButton_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 97, 70));

        AddButton_FP.setBackground(new java.awt.Color(153, 153, 255));
        AddButton_FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton_FPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddButton_FPMousePressed(evt);
            }
        });
        AddButton_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setText("Add");
        jLabel175.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel175MousePressed(evt);
            }
        });
        AddButton_FP.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, 20));

        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AddIcon.png"))); // NOI18N
        jLabel176.setPreferredSize(new java.awt.Dimension(42, 50));
        AddButton_FP.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel_FP.add(AddButton_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, -1));

        UpdateButton_FP.setBackground(new java.awt.Color(153, 153, 255));
        UpdateButton_FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButton_FPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateButton_FPMousePressed(evt);
            }
        });
        UpdateButton_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setText("Update");
        UpdateButton_FP.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, -1));

        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/UpdateIcon.png"))); // NOI18N
        jLabel178.setPreferredSize(new java.awt.Dimension(42, 50));
        UpdateButton_FP.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel_FP.add(UpdateButton_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 70));

        DeleteButton_FP.setBackground(new java.awt.Color(153, 153, 255));
        DeleteButton_FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButton_FPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteButton_FPMousePressed(evt);
            }
        });
        DeleteButton_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setText("Delete");
        DeleteButton_FP.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DeleteIcon.png"))); // NOI18N
        jLabel180.setPreferredSize(new java.awt.Dimension(42, 50));
        DeleteButton_FP.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel_FP.add(DeleteButton_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 70));

        FP.add(NavPanel_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 510, 90));

        ViewPanel_FP.setBackground(new java.awt.Color(103, 111, 163));
        ViewPanel_FP.setForeground(new java.awt.Color(0, 0, 0));
        ViewPanel_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel20.setBackground(new java.awt.Color(103, 111, 163));
        CPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setText("Attribute");
        CPanel20.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable6.setGridColor(new java.awt.Color(255, 255, 255));
        jTable6.setOpaque(false);
        jTable6.setRowHeight(20);
        jTable6.setShowGrid(true);
        jTable6.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTable6);

        CPanel20.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 520, 320));

        FilVal5.setText("1");
        CPanel20.add(FilVal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, 20));

        jLabel182.setText("Value");
        CPanel20.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        Search5.setText("Search");
        Search5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search5MouseClicked(evt);
            }
        });
        CPanel20.add(Search5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        Refresh5.setText("Refresh");
        Refresh5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Refresh5MouseClicked(evt);
            }
        });
        CPanel20.add(Refresh5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        FilAttr5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name" }));
        CPanel20.add(FilAttr5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 70, -1));

        ViewPanel_FP.add(CPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        FP.add(ViewPanel_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, 850, 700));

        AddPanel_FP.setBackground(new java.awt.Color(103, 111, 163));
        AddPanel_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel21.setBackground(new java.awt.Color(103, 111, 163));
        CPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddRecord5.setText("Add Record");
        AddRecord5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRecord5MouseClicked(evt);
            }
        });
        AddRecord5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecord5ActionPerformed(evt);
            }
        });
        CPanel21.add(AddRecord5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));
        CPanel21.add(PriceBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 70, -1));

        jLabel185.setText("Price");
        CPanel21.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 60, 30));
        CPanel21.add(NameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 70, -1));

        jLabel186.setText("Name");
        CPanel21.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 60, 30));

        CatBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CatBoxMouseClicked(evt);
            }
        });
        CatBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatBoxActionPerformed(evt);
            }
        });
        CPanel21.add(CatBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 119, 70, 20));

        jLabel187.setText("Category");
        CPanel21.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 60, 30));

        AddPanel_FP.add(CPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 520, 320));

        FP.add(AddPanel_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 850, 700));

        UpdatePanel_FP.setBackground(new java.awt.Color(103, 111, 163));
        UpdatePanel_FP.setPreferredSize(new java.awt.Dimension(850, 700));
        UpdatePanel_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel22.setBackground(new java.awt.Color(103, 111, 163));
        CPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExView_FP_Up.setBackground(new java.awt.Color(103, 111, 163));
        ExView_FP_Up.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Price_Up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Price_UpActionPerformed(evt);
            }
        });
        ExView_FP_Up.add(Price_Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 63, -1));
        ExView_FP_Up.add(Cat_Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 63, -1));
        ExView_FP_Up.add(Name_Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 63, -1));

        jLabel189.setText("Price");
        ExView_FP_Up.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 20));

        jLabel190.setText("Category");
        ExView_FP_Up.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 53, 50, 20));

        jLabel191.setText("Name");
        ExView_FP_Up.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 84, 20));

        Update_FP.setText("Update");
        Update_FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Update_FPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Update_FPMousePressed(evt);
            }
        });
        ExView_FP_Up.add(Update_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        CPanel22.add(ExView_FP_Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 240, 250));

        Extract10.setText("Extract");
        Extract10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Extract10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Extract10MousePressed(evt);
            }
        });
        CPanel22.add(Extract10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        NameBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameBox1ActionPerformed(evt);
            }
        });
        CPanel22.add(NameBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 63, 20));

        jLabel192.setText("Name");
        CPanel22.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 50, 20));

        UpdatePanel_FP.add(CPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        FP.add(UpdatePanel_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -2, 850, 700));

        DeletePanel_FP.setBackground(new java.awt.Color(103, 111, 163));
        DeletePanel_FP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel23.setBackground(new java.awt.Color(103, 111, 163));
        CPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExView_FP_del.setBackground(new java.awt.Color(103, 111, 163));
        ExView_FP_del.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel193.setText("Name");
        ExView_FP_del.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        jLabel194.setText("Price");
        ExView_FP_del.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, -1, -1));

        jLabel195.setText("Category");
        ExView_FP_del.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 51, -1, -1));
        ExView_FP_del.add(Name_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 12, 70, -1));
        ExView_FP_del.add(Cat_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 49, 70, -1));
        ExView_FP_del.add(Price_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 86, 70, -1));

        Drop_FP.setText("Drop");
        Drop_FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Drop_FPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Drop_FPMousePressed(evt);
            }
        });
        ExView_FP_del.add(Drop_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        CPanel23.add(ExView_FP_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 220, 210));

        Extract11.setText("Extract");
        Extract11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Extract11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Extract11MousePressed(evt);
            }
        });
        CPanel23.add(Extract11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        NameBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameBox2ActionPerformed(evt);
            }
        });
        CPanel23.add(NameBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 63, -1));

        jLabel197.setText("Name");
        CPanel23.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 43, 20));

        DeletePanel_FP.add(CPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        FP.add(DeletePanel_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        Background.add(FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 700));

        SDP.setBackground(new java.awt.Color(103, 111, 163));
        SDP.setPreferredSize(new java.awt.Dimension(1150, 700));
        SDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SDPMouseClicked(evt);
            }
        });
        SDP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeedNavPanel.setBackground(new java.awt.Color(255, 204, 255));
        SeedNavPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeedViewNav.setBackground(new java.awt.Color(153, 153, 255));
        SeedViewNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeedViewNavMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SeedViewNavMousePressed(evt);
            }
        });
        SeedViewNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("View");
        SeedViewNav.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ViewIcon.png"))); // NOI18N
        jLabel79.setPreferredSize(new java.awt.Dimension(42, 50));
        SeedViewNav.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        SeedNavPanel.add(SeedViewNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 97, 70));

        SeedAddNav.setBackground(new java.awt.Color(153, 153, 255));
        SeedAddNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeedAddNavMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SeedAddNavMousePressed(evt);
            }
        });
        SeedAddNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setText("Add");
        jLabel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel114MousePressed(evt);
            }
        });
        SeedAddNav.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, 20));

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AddIcon.png"))); // NOI18N
        jLabel115.setPreferredSize(new java.awt.Dimension(42, 50));
        SeedAddNav.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        SeedNavPanel.add(SeedAddNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, -1));

        SeedUpdateNav.setBackground(new java.awt.Color(153, 153, 255));
        SeedUpdateNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeedUpdateNavMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SeedUpdateNavMousePressed(evt);
            }
        });
        SeedUpdateNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setText("Update");
        SeedUpdateNav.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, -1));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/UpdateIcon.png"))); // NOI18N
        jLabel117.setPreferredSize(new java.awt.Dimension(42, 50));
        SeedUpdateNav.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        SeedNavPanel.add(SeedUpdateNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 70));

        SeedDelNav.setBackground(new java.awt.Color(153, 153, 255));
        SeedDelNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeedDelNavMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SeedDelNavMousePressed(evt);
            }
        });
        SeedDelNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setText("Delete");
        SeedDelNav.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DeleteIcon.png"))); // NOI18N
        jLabel119.setPreferredSize(new java.awt.Dimension(42, 50));
        SeedDelNav.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        SeedNavPanel.add(SeedDelNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 70));

        SDP.add(SeedNavPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 520, 100));

        SeedDisplayPanel.setBackground(new java.awt.Color(103, 111, 163));
        SeedDisplayPanel.setPreferredSize(new java.awt.Dimension(850, 700));

        DisplaySeeds.setBackground(new java.awt.Color(64, 255, 0));
        DisplaySeeds.setText("Display Table");
        DisplaySeeds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplaySeedsActionPerformed(evt);
            }
        });

        SeedDisp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seed Type", "Price", "Quantity", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(SeedDisp);

        jLabel73.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(250, 250, 250));
        jLabel73.setText("Display Seeds Database");

        javax.swing.GroupLayout SeedDisplayPanelLayout = new javax.swing.GroupLayout(SeedDisplayPanel);
        SeedDisplayPanel.setLayout(SeedDisplayPanelLayout);
        SeedDisplayPanelLayout.setHorizontalGroup(
            SeedDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDisplayPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DisplaySeeds, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDisplayPanelLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(SeedDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDisplayPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDisplayPanelLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(324, 324, 324))))
        );
        SeedDisplayPanelLayout.setVerticalGroup(
            SeedDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeedDisplayPanelLayout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel73)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DisplaySeeds)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        SDP.add(SeedDisplayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        SeedAddPanel.setBackground(new java.awt.Color(103, 111, 163));
        SeedAddPanel.setPreferredSize(new java.awt.Dimension(850, 700));

        InsertSeed.setBackground(new java.awt.Color(64, 255, 0));
        InsertSeed.setText("Insert");
        InsertSeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertSeedActionPerformed(evt);
            }
        });

        inputSeedType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSeedTypeActionPerformed(evt);
            }
        });

        jLabel68.setForeground(new java.awt.Color(250, 250, 250));
        jLabel68.setText("Type:");

        jLabel69.setForeground(new java.awt.Color(250, 250, 250));
        jLabel69.setText("Price:");

        jLabel70.setForeground(new java.awt.Color(250, 250, 250));
        jLabel70.setText("Quantity:");

        jLabel71.setForeground(new java.awt.Color(250, 250, 250));
        jLabel71.setText("Grade:");

        jLabel72.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(250, 250, 250));
        jLabel72.setText("Add Records");

        inputSeedPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSeedPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeedAddPanelLayout = new javax.swing.GroupLayout(SeedAddPanel);
        SeedAddPanel.setLayout(SeedAddPanelLayout);
        SeedAddPanelLayout.setHorizontalGroup(
            SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedAddPanelLayout.createSequentialGroup()
                .addGap(0, 245, Short.MAX_VALUE)
                .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel70)
                        .addComponent(jLabel69)
                        .addComponent(jLabel71))
                    .addGroup(SeedAddPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel68)))
                .addGap(61, 61, 61)
                .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(InsertSeed)
                    .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputSeedPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addComponent(inputSeedType)
                        .addComponent(inputSeedQuantity)
                        .addComponent(inputSeedGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)))
                .addGap(221, 221, 221))
        );
        SeedAddPanelLayout.setVerticalGroup(
            SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedAddPanelLayout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addComponent(jLabel72)
                .addGap(42, 42, 42)
                .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputSeedType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addGap(18, 18, 18)
                .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSeedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGap(18, 18, 18)
                .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSeedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addGap(18, 18, 18)
                .addGroup(SeedAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSeedGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addGap(37, 37, 37)
                .addComponent(InsertSeed)
                .addGap(172, 172, 172))
        );

        SDP.add(SeedAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SeedUpdatePanel.setBackground(new java.awt.Color(103, 111, 163));

        jLabel74.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(250, 250, 250));
        jLabel74.setText("Update Seeds Table");

        SeedUpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seed Type", "Price", "Quantity", "Grade"
            }
        ));
        jScrollPane6.setViewportView(SeedUpTable);

        SeedUpEdit.setBackground(new java.awt.Color(64, 255, 0));
        SeedUpEdit.setText("Edit");
        SeedUpEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeedUpEditActionPerformed(evt);
            }
        });

        editQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuantityActionPerformed(evt);
            }
        });

        SeedUpUpdate.setBackground(new java.awt.Color(64, 255, 0));
        SeedUpUpdate.setText("Update");
        SeedUpUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeedUpUpdateActionPerformed(evt);
            }
        });

        SeedUpRefresh.setBackground(new java.awt.Color(64, 255, 0));
        SeedUpRefresh.setText("Refresh");
        SeedUpRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeedUpRefreshActionPerformed(evt);
            }
        });

        SeedUpShow.setText("Show");
        SeedUpShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeedUpShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeedUpdatePanelLayout = new javax.swing.GroupLayout(SeedUpdatePanel);
        SeedUpdatePanel.setLayout(SeedUpdatePanelLayout);
        SeedUpdatePanelLayout.setHorizontalGroup(
            SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedUpdatePanelLayout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SeedUpdatePanelLayout.createSequentialGroup()
                            .addGap(257, 257, 257)
                            .addComponent(jLabel74))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedUpdatePanelLayout.createSequentialGroup()
                            .addComponent(SeedUpShow)
                            .addGap(18, 18, 18)
                            .addComponent(SeedUpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedUpdatePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SeedUpUpdate)
                            .addGroup(SeedUpdatePanelLayout.createSequentialGroup()
                                .addComponent(editStype, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeedUpdatePanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(editQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeedUpdatePanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(SeedUpRefresh)))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        SeedUpdatePanelLayout.setVerticalGroup(
            SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeedUpdatePanelLayout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jLabel74)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeedUpEdit)
                    .addComponent(SeedUpShow))
                .addGap(18, 18, 18)
                .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editStype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(SeedUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeedUpRefresh)
                    .addComponent(SeedUpUpdate))
                .addGap(101, 101, 101))
        );

        SDP.add(SeedUpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        SeedDelPanel.setBackground(new java.awt.Color(103, 111, 163));

        jLabel76.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(250, 250, 250));
        jLabel76.setText("Delete Seeds Records");

        SeedDelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seed Type", "Price", "Quantity", "Grade"
            }
        ));
        jScrollPane9.setViewportView(SeedDelTable);

        DeleteSeed.setBackground(new java.awt.Color(0, 0, 0));
        DeleteSeed.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        DeleteSeed.setText("Delete");
        DeleteSeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSeedActionPerformed(evt);
            }
        });

        RefreshDelSeed.setBackground(new java.awt.Color(0, 0, 0));
        RefreshDelSeed.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        RefreshDelSeed.setText("Refresh");
        RefreshDelSeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshDelSeedActionPerformed(evt);
            }
        });

        ShowDelSeed.setBackground(new java.awt.Color(0, 0, 0));
        ShowDelSeed.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        ShowDelSeed.setText("Show");
        ShowDelSeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDelSeedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeedDelPanelLayout = new javax.swing.GroupLayout(SeedDelPanel);
        SeedDelPanel.setLayout(SeedDelPanelLayout);
        SeedDelPanelLayout.setHorizontalGroup(
            SeedDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDelPanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(SeedDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDelPanelLayout.createSequentialGroup()
                        .addGroup(SeedDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SeedDelPanelLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(ShowDelSeed)
                                .addGap(76, 76, 76)
                                .addComponent(DeleteSeed)
                                .addGap(84, 84, 84)
                                .addComponent(RefreshDelSeed)))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDelPanelLayout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(326, 326, 326))))
        );
        SeedDelPanelLayout.setVerticalGroup(
            SeedDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeedDelPanelLayout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(jLabel76)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(SeedDelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteSeed)
                    .addComponent(RefreshDelSeed)
                    .addComponent(ShowDelSeed, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );

        SDP.add(SeedDelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        Background.add(SDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 700));

        MP.setBackground(new java.awt.Color(103, 111, 163));
        MP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MPMouseClicked(evt);
            }
        });
        MP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavPanel.setBackground(new java.awt.Color(255, 204, 255));
        NavPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewButton.setBackground(new java.awt.Color(153, 153, 255));
        ViewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewButtonMousePressed(evt);
            }
        });
        ViewButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("View");
        ViewButton.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ViewIcon.png"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(42, 50));
        ViewButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel.add(ViewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 97, 70));

        AddButton.setBackground(new java.awt.Color(153, 153, 255));
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddButtonMousePressed(evt);
            }
        });
        AddButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Add");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel31MousePressed(evt);
            }
        });
        AddButton.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, 20));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AddIcon.png"))); // NOI18N
        jLabel33.setPreferredSize(new java.awt.Dimension(42, 50));
        AddButton.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, -1));

        UpdateButton.setBackground(new java.awt.Color(153, 153, 255));
        UpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateButtonMousePressed(evt);
            }
        });
        UpdateButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Update");
        UpdateButton.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/UpdateIcon.png"))); // NOI18N
        jLabel34.setPreferredSize(new java.awt.Dimension(42, 50));
        UpdateButton.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 70));

        DeleteButton.setBackground(new java.awt.Color(153, 153, 255));
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteButtonMousePressed(evt);
            }
        });
        DeleteButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Delete");
        DeleteButton.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DeleteIcon.png"))); // NOI18N
        jLabel35.setPreferredSize(new java.awt.Dimension(42, 50));
        DeleteButton.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        NavPanel.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 70));

        MP.add(NavPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 510, 90));

        ViewPanel.setBackground(new java.awt.Color(103, 111, 163));
        ViewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel.setBackground(new java.awt.Color(103, 111, 163));
        CPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CPanelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        CPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Attribute");
        CPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MId", "Machine_Type", "Price", "Brand", "F_Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(20);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        CPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 520, 320));

        FilVal.setText("1");
        CPanel.add(FilVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, 20));

        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Value");
        CPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        Search.setText("Search");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        CPanel.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        Refresh.setText("Refresh");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });
        CPanel.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        FilAttr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MId", "Machine_Type", "Price", "Brand", "F_Id" }));
        CPanel.add(FilAttr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        ViewPanel.add(CPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        MP.add(ViewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, 850, 700));

        AddPanel.setBackground(new java.awt.Color(103, 111, 163));
        AddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel1.setBackground(new java.awt.Color(103, 111, 163));
        CPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddRecord.setText("Add Record");
        AddRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRecordMouseClicked(evt);
            }
        });
        AddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordActionPerformed(evt);
            }
        });
        CPanel1.add(AddRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("F_Id");
        CPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 43, -1));
        CPanel1.add(F_IdA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 63, -1));
        CPanel1.add(BrandA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 63, -1));

        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Brand");
        CPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 43, -1));
        CPanel1.add(PriceA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 63, -1));

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Price");
        CPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 43, -1));
        CPanel1.add(MTypeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 63, -1));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Machine Type");
        CPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 86, -1));

        M_IdA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                M_IdAMouseClicked(evt);
            }
        });
        M_IdA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_IdAActionPerformed(evt);
            }
        });
        CPanel1.add(M_IdA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 63, -1));

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("M_Id");
        CPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 37, -1));

        AddPanel.add(CPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 520, 320));

        MP.add(AddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 850, 700));

        UpdatePanel.setBackground(new java.awt.Color(103, 111, 163));
        UpdatePanel.setPreferredSize(new java.awt.Dimension(850, 700));
        UpdatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel2.setBackground(new java.awt.Color(103, 111, 163));
        CPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExView1.setBackground(new java.awt.Color(103, 111, 163));
        ExView1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ExView1.add(F_IdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 119, 69, -1));
        ExView1.add(BrandU, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 88, 63, -1));
        ExView1.add(PriceU, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 53, 63, -1));
        ExView1.add(MTypeU, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 22, 63, -1));

        jLabel44.setBackground(new java.awt.Color(0, 0, 0));
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("F_Id");
        ExView1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 123, 43, -1));

        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Brand");
        ExView1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 90, 43, -1));

        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Price");
        ExView1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 55, 43, -1));

        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Machine Type");
        ExView1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, 84, -1));

        SaveButton.setText("Update");
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SaveButtonMousePressed(evt);
            }
        });
        ExView1.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 90, 30));

        CPanel2.add(ExView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 240, 250));

        Extract.setText("Extract");
        Extract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExtractMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExtractMousePressed(evt);
            }
        });
        CPanel2.add(Extract, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        M_IdU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_IdUActionPerformed(evt);
            }
        });
        CPanel2.add(M_IdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 63, -1));

        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("M_Id");
        CPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 43, -1));

        UpdatePanel.add(CPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        MP.add(UpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -2, 850, 700));

        DeletePanel.setBackground(new java.awt.Color(103, 111, 163));
        DeletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel3.setBackground(new java.awt.Color(103, 111, 163));
        CPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExView2.setBackground(new java.awt.Color(103, 111, 163));
        ExView2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Machine Type");
        ExView2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Brand");
        ExView2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, -1, -1));

        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Price");
        ExView2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 51, -1, -1));

        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("F_Id");
        ExView2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 125, -1, -1));
        ExView2.add(MTypeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 12, 70, -1));
        ExView2.add(PriceD, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 49, 70, -1));
        ExView2.add(BrandD, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 86, 70, -1));
        ExView2.add(F_IdD, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 123, 70, -1));

        DeleteRecord.setText("Drop");
        DeleteRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteRecordMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteRecordMousePressed(evt);
            }
        });
        ExView2.add(DeleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        CPanel3.add(ExView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 220, 210));

        Extract1.setText("Extract");
        Extract1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Extract1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Extract1MousePressed(evt);
            }
        });
        CPanel3.add(Extract1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        M_IdD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_IdDActionPerformed(evt);
            }
        });
        CPanel3.add(M_IdD, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 63, -1));

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("M_Id");
        CPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 43, -1));

        DeletePanel.add(CPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        MP.add(DeletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        Background.add(MP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 700));

        LP.setBackground(new java.awt.Color(103, 111, 163));
        LP.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                LPAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        LP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LPMouseClicked(evt);
            }
        });
        LP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoanNavPanel.setBackground(new java.awt.Color(255, 204, 255));
        LoanNavPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewButton2.setBackground(new java.awt.Color(153, 153, 255));
        ViewButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewButton2MousePressed(evt);
            }
        });
        ViewButton2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("View");
        ViewButton2.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ViewIcon.png"))); // NOI18N
        jLabel28.setPreferredSize(new java.awt.Dimension(42, 50));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        ViewButton2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        LoanNavPanel.add(ViewButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 97, 70));

        AddButton2.setBackground(new java.awt.Color(153, 153, 255));
        AddButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddButton2MousePressed(evt);
            }
        });
        AddButton2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Add");
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel81MousePressed(evt);
            }
        });
        AddButton2.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, 20));

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AddIcon.png"))); // NOI18N
        jLabel82.setPreferredSize(new java.awt.Dimension(42, 50));
        AddButton2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        LoanNavPanel.add(AddButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, -1));

        UpdateButton2.setBackground(new java.awt.Color(153, 153, 255));
        UpdateButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateButton2MousePressed(evt);
            }
        });
        UpdateButton2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Update");
        UpdateButton2.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/UpdateIcon.png"))); // NOI18N
        jLabel84.setPreferredSize(new java.awt.Dimension(42, 50));
        UpdateButton2.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        LoanNavPanel.add(UpdateButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 70));

        DeleteButton2.setBackground(new java.awt.Color(153, 153, 255));
        DeleteButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteButton2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteButton2MousePressed(evt);
            }
        });
        DeleteButton2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Delete");
        DeleteButton2.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 37, -1));

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DeleteIcon.png"))); // NOI18N
        jLabel86.setPreferredSize(new java.awt.Dimension(42, 50));
        DeleteButton2.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        LoanNavPanel.add(DeleteButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 70));

        LP.add(LoanNavPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 510, 90));

        LoanViewPanel.setBackground(new java.awt.Color(103, 111, 163));
        LoanViewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel8.setBackground(new java.awt.Color(103, 111, 163));
        CPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setText("Attribute");
        CPanel8.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan_Id", "Loan_Type", "Bank", "Interest", "Duration", "Total", "F_Id", "LStatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setOpaque(false);
        jTable3.setRowHeight(20);
        jTable3.setShowGrid(true);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        CPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 520, 320));

        FilVal2.setText("1");
        CPanel8.add(FilVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, 20));

        jLabel88.setText("Value");
        CPanel8.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        Search2.setText("Search");
        Search2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search2MouseClicked(evt);
            }
        });
        Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search2ActionPerformed(evt);
            }
        });
        CPanel8.add(Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        Refresh2.setText("Refresh");
        Refresh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Refresh2MouseClicked(evt);
            }
        });
        CPanel8.add(Refresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        FilAttr2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loan_Id", "Loan_Type", "Bank", "Interest", "Duration", "Total", "FId", "LStatus" }));
        FilAttr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilAttr2ActionPerformed(evt);
            }
        });
        CPanel8.add(FilAttr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        LoanViewPanel.add(CPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 560, 450));

        LP.add(LoanViewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, 850, 700));

        LoanAddPanel.setBackground(new java.awt.Color(103, 111, 163));
        LoanAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel9.setBackground(new java.awt.Color(103, 111, 163));
        CPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddRecord2.setText("Add Record");
        AddRecord2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRecord2MouseClicked(evt);
            }
        });
        AddRecord2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecord2ActionPerformed(evt);
            }
        });
        CPanel9.add(AddRecord2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));
        CPanel9.add(DurationA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 63, -1));
        CPanel9.add(InterestA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 63, -1));
        CPanel9.add(LoanTypeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 63, -1));

        LoanBankA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanBankAActionPerformed(evt);
            }
        });
        CPanel9.add(LoanBankA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 63, -1));

        LStatusA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LStatusAMouseClicked(evt);
            }
        });
        LStatusA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LStatusAActionPerformed(evt);
            }
        });
        CPanel9.add(LStatusA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 63, -1));

        jLabel101.setBackground(new java.awt.Color(0, 0, 0));
        jLabel101.setText("LStatus");
        CPanel9.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 60, -1));

        jLabel120.setText("Interest");
        CPanel9.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 43, -1));

        jLabel121.setText("Loan_Type");
        CPanel9.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 70, -1));

        jLabel122.setText("Bank");
        CPanel9.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 84, -1));

        jLabel102.setBackground(new java.awt.Color(0, 0, 0));
        jLabel102.setText("Duration");
        CPanel9.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 50, 10));

        jLabel103.setBackground(new java.awt.Color(0, 0, 0));
        jLabel103.setText("Total");
        CPanel9.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 43, -1));

        jLabel104.setBackground(new java.awt.Color(0, 0, 0));
        jLabel104.setText("Loan_Id");
        CPanel9.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 43, -1));

        jLabel105.setBackground(new java.awt.Color(0, 0, 0));
        jLabel105.setText("FId");
        CPanel9.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 43, -1));

        TotalA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAActionPerformed(evt);
            }
        });
        CPanel9.add(TotalA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 60, -1));

        LoanIDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoanIDAMouseClicked(evt);
            }
        });
        LoanIDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanIDAActionPerformed(evt);
            }
        });
        CPanel9.add(LoanIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 63, -1));

        LoanFIdA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoanFIdAMouseClicked(evt);
            }
        });
        LoanFIdA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanFIdAActionPerformed(evt);
            }
        });
        CPanel9.add(LoanFIdA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 63, -1));

        LoanAddPanel.add(CPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 520, 400));

        LP.add(LoanAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 850, 700));

        LoanUpdatePanel.setBackground(new java.awt.Color(103, 111, 163));
        LoanUpdatePanel.setPreferredSize(new java.awt.Dimension(850, 700));
        LoanUpdatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel10.setBackground(new java.awt.Color(103, 111, 163));
        CPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExView5.setBackground(new java.awt.Color(103, 111, 163));
        ExView5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ExView5.add(LStatusU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 69, -1));
        ExView5.add(InterestU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 63, -1));
        ExView5.add(Loan_TypeU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 63, -1));
        ExView5.add(BankU, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 22, 63, -1));

        jLabel89.setBackground(new java.awt.Color(0, 0, 0));
        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jLabel89.setText("LStatus");
        ExView5.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 60, -1));

        jLabel123.setForeground(new java.awt.Color(0, 0, 0));
        jLabel123.setText("Interest");
        ExView5.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 90, 43, -1));

        jLabel124.setForeground(new java.awt.Color(0, 0, 0));
        jLabel124.setText("Loan_Type");
        ExView5.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 55, 70, -1));

        jLabel125.setForeground(new java.awt.Color(0, 0, 0));
        jLabel125.setText("Bank");
        ExView5.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, 84, -1));

        SaveButton2.setText("Update");
        SaveButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SaveButton2MousePressed(evt);
            }
        });
        SaveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButton2ActionPerformed(evt);
            }
        });
        ExView5.add(SaveButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 90, 30));
        ExView5.add(DurationU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 69, -1));
        ExView5.add(TotalU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 69, -1));
        ExView5.add(Loan_IdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 69, -1));

        jLabel90.setBackground(new java.awt.Color(0, 0, 0));
        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setText("Duration");
        ExView5.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 10));

        jLabel91.setBackground(new java.awt.Color(0, 0, 0));
        jLabel91.setForeground(new java.awt.Color(0, 0, 0));
        jLabel91.setText("Total");
        ExView5.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 43, -1));

        jLabel92.setBackground(new java.awt.Color(0, 0, 0));
        jLabel92.setForeground(new java.awt.Color(0, 0, 0));
        jLabel92.setText("Loan_Id");
        ExView5.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 43, -1));
        ExView5.add(LoanF_IdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 69, -1));

        jLabel93.setBackground(new java.awt.Color(0, 0, 0));
        jLabel93.setForeground(new java.awt.Color(0, 0, 0));
        jLabel93.setText("F_IdU");
        ExView5.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 43, -1));

        CPanel10.add(ExView5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 310));

        Extract4.setText("Extract");
        Extract4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Extract4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Extract4MousePressed(evt);
            }
        });
        CPanel10.add(Extract4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        Loan_IdU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loan_IdU1ActionPerformed(evt);
            }
        });
        CPanel10.add(Loan_IdU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 63, -1));

        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setText("Loan_Id");
        CPanel10.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 43, -1));

        LoanUpdatePanel.add(CPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        LP.add(LoanUpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -2, 850, 700));

        LoanDeletePanel.setBackground(new java.awt.Color(103, 111, 163));
        LoanDeletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel11.setBackground(new java.awt.Color(103, 111, 163));
        CPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoanDelExtract.setText("Extract");
        LoanDelExtract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoanDelExtractMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoanDelExtractMousePressed(evt);
            }
        });
        CPanel11.add(LoanDelExtract, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        Loan_IdD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loan_IdD2ActionPerformed(evt);
            }
        });
        CPanel11.add(Loan_IdD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 63, -1));

        jLabel127.setBackground(new java.awt.Color(0, 0, 0));
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jLabel127.setText("Loan_Id");
        CPanel11.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 43, -1));

        ExView7.setBackground(new java.awt.Color(103, 111, 163));
        ExView7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ExView7.add(LStatusD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 69, -1));
        ExView7.add(InterestD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 63, -1));
        ExView7.add(Loan_TypeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 63, -1));
        ExView7.add(BankD, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 22, 63, -1));

        jLabel94.setBackground(new java.awt.Color(0, 0, 0));
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setText("LStatus");
        ExView7.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, -1));

        jLabel128.setForeground(new java.awt.Color(0, 0, 0));
        jLabel128.setText("Interest");
        ExView7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 90, 43, -1));

        jLabel129.setForeground(new java.awt.Color(0, 0, 0));
        jLabel129.setText("Loan_Type");
        ExView7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 55, 70, -1));

        jLabel130.setForeground(new java.awt.Color(0, 0, 0));
        jLabel130.setText("Bank");
        ExView7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, 84, -1));

        LoanDeleteRec.setText("Delete");
        LoanDeleteRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoanDeleteRecMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoanDeleteRecMousePressed(evt);
            }
        });
        LoanDeleteRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanDeleteRecActionPerformed(evt);
            }
        });
        ExView7.add(LoanDeleteRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 90, 30));
        ExView7.add(DurationD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 69, -1));
        ExView7.add(TotalD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 69, -1));
        ExView7.add(Loan_IdD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 69, -1));

        jLabel95.setBackground(new java.awt.Color(0, 0, 0));
        jLabel95.setForeground(new java.awt.Color(0, 0, 0));
        jLabel95.setText("Duration");
        ExView7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 10));

        jLabel96.setBackground(new java.awt.Color(0, 0, 0));
        jLabel96.setForeground(new java.awt.Color(0, 0, 0));
        jLabel96.setText("Total");
        ExView7.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 43, -1));

        jLabel97.setBackground(new java.awt.Color(0, 0, 0));
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jLabel97.setText("Loan_Id");
        ExView7.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 43, -1));
        ExView7.add(F_IdD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 69, -1));

        jLabel98.setBackground(new java.awt.Color(0, 0, 0));
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        jLabel98.setText("F_Id");
        ExView7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 43, -1));

        CPanel11.add(ExView7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 310));

        LoanDeletePanel.add(CPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 560, 450));

        LP.add(LoanDeletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));

        Background.add(LP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackgroundFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BackgroundFocusLost
       
    }//GEN-LAST:event_BackgroundFocusLost
    
    int x, y;
    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x,yy-y);
    }//GEN-LAST:event_BackgroundMouseDragged

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_BackgroundMousePressed

    private void StatusTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusTabMousePressed
        setColor(StatusTab);
        resetColor( FertilizersTab);
        resetColor(LoansTab);
        resetColor(MachinesTab);
        resetColor(SeedsTab);
        resetColor(AccountsTab);
    }//GEN-LAST:event_StatusTabMousePressed

    private void FertilizersTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FertilizersTabMousePressed
        setColor(FertilizersTab);
        resetColor(StatusTab);
        resetColor(LoansTab);
        resetColor(MachinesTab);
        resetColor(SeedsTab);
        resetColor(AccountsTab);
    }//GEN-LAST:event_FertilizersTabMousePressed

    private void SeedsTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedsTabMousePressed
        setColor(SeedsTab);
        resetColor(StatusTab);
        resetColor(LoansTab);
        resetColor(MachinesTab);
        resetColor(FertilizersTab);
        resetColor(AccountsTab);
    }//GEN-LAST:event_SeedsTabMousePressed

    private void StatusTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusTabMouseEntered

    }//GEN-LAST:event_StatusTabMouseEntered

    private void AccountsTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountsTabMouseEntered
       
    }//GEN-LAST:event_AccountsTabMouseEntered

    private void AccountsTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountsTabMousePressed
        setColor(AccountsTab);
        resetColor(StatusTab);
        resetColor(LoansTab);
        resetColor(MachinesTab);
        resetColor(SeedsTab);
        resetColor(FertilizersTab);
    }//GEN-LAST:event_AccountsTabMousePressed

    private void MachinesTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MachinesTabMousePressed
        setColor(MachinesTab);
        resetColor(StatusTab);
        resetColor(LoansTab);
        resetColor( FertilizersTab);
        resetColor(SeedsTab);
        resetColor(AccountsTab);
    }//GEN-LAST:event_MachinesTabMousePressed

    private void LoansTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoansTabMousePressed
        setColor(LoansTab);
        resetColor(StatusTab);
        resetColor( FertilizersTab);
        resetColor(MachinesTab);
        resetColor(SeedsTab);
        resetColor(AccountsTab);
    }//GEN-LAST:event_LoansTabMousePressed

    private void AccountsTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountsTabMouseExited

    }//GEN-LAST:event_AccountsTabMouseExited

    private void FertilizersTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FertilizersTabMouseEntered
        
    }//GEN-LAST:event_FertilizersTabMouseEntered

    private void FertilizersTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FertilizersTabMouseExited

    }//GEN-LAST:event_FertilizersTabMouseExited

    private void SeedsTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedsTabMouseEntered
       
    }//GEN-LAST:event_SeedsTabMouseEntered

    private void SeedsTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedsTabMouseExited

    }//GEN-LAST:event_SeedsTabMouseExited

    private void MachinesTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MachinesTabMouseEntered

    }//GEN-LAST:event_MachinesTabMouseEntered

    private void MachinesTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MachinesTabMouseExited

    }//GEN-LAST:event_MachinesTabMouseExited

    private void LoansTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoansTabMouseEntered

    }//GEN-LAST:event_LoansTabMouseEntered

    private void LoansTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoansTabMouseExited

    }//GEN-LAST:event_LoansTabMouseExited

    private void StatusTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusTabMouseExited

    }//GEN-LAST:event_StatusTabMouseExited
        
    private void AccountsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountsTabMouseClicked
        // TODO add your handling code here:
        AP.setVisible(true);
        FP.setVisible(false);
        LP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        ExitBox.setVisible(true);
        AccDelPanel.setVisible(false);
        AccUpdatePanel.setVisible(false);
        AccDisplayPanel.setVisible(true);
        AccAddPanel.setVisible(false);

    }//GEN-LAST:event_AccountsTabMouseClicked

    private void FertilizersTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FertilizersTabMouseClicked
        // TODO add your handling code here:
        AP.setVisible(false);
        FP.setVisible(true);
        LP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        ViewPanel_FP.setVisible(true);
        UpdatePanel_FP.setVisible(false);
        AddPanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(false);
        NavPanel_FP.setVisible(true);
        ExitBox.setVisible(true);
        

    }//GEN-LAST:event_FertilizersTabMouseClicked

    private void SeedsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedsTabMouseClicked
        // TODO add your handling code here:
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(true);
        LP.setVisible(false);
        SeedNavPanel.setVisible(true);
        SeedDisplayPanel.setVisible(true);
        SeedAddPanel.setVisible(false);
        SeedUpdatePanel.setVisible(false);
        SeedDelPanel.setVisible(false);
    }//GEN-LAST:event_SeedsTabMouseClicked

    private void MachinesTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MachinesTabMouseClicked
        // TODO add your handling code here:
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(true);
        SDP.setVisible(false);
        LP.setVisible(false);
        ExitBox.setVisible(true);
        ViewPanel.setVisible(true);
        UpdatePanel.setVisible(false);
        AddPanel.setVisible(false);
        DeletePanel.setVisible(false);
        NavPanel.setVisible(true);
    }//GEN-LAST:event_MachinesTabMouseClicked

    private void LoansTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoansTabMouseClicked
        // TODO add your handling code here:
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        LP.setVisible(true);
        LoanViewPanel.setVisible(true);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
        LoanNavPanel.setVisible(true);
    }//GEN-LAST:event_LoansTabMouseClicked

    private void StatusTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusTabMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"LOGOUT SUUCCESSFUL");
        System.exit(0);
        
    }//GEN-LAST:event_StatusTabMouseClicked

    private void AddRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRecordMouseClicked

    }//GEN-LAST:event_AddRecordMouseClicked

    private void AddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordActionPerformed
        int MId = Integer.parseInt(M_IdA.getText());
        String MType = MTypeA.getText();
        float Price = Float.parseFloat(PriceA.getText());
        String Brand = BrandA.getText();
        String F_Id = (F_IdA.getText());
        try {
            insertMachinesData(MId,MType,Price,Brand,F_Id);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadMachinesData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewPanel.setVisible(true);
        AddPanel.setVisible(false);
        UpdatePanel.setVisible(false);
        DeletePanel.setVisible(false);
    }//GEN-LAST:event_AddRecordActionPerformed

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        String attr = (String)FilAttr.getSelectedItem();
        String value = FilVal.getText();
        try {
            filterMachinesData(attr, value);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchMouseClicked

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
        try {
            loadMachinesData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RefreshMouseClicked

    private void M_IdUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_IdUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_M_IdUActionPerformed

    private void ExtractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExtractMouseClicked
        int MId = Integer.parseInt(M_IdU.getText());
        try {
            getMachinesData(MId);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView1.setVisible(true);
    }//GEN-LAST:event_ExtractMouseClicked

    private void ExtractMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExtractMousePressed

    }//GEN-LAST:event_ExtractMousePressed

    private void SaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseClicked
        int MId = Integer.parseInt(M_IdU.getText());
        String MType = MTypeU.getText();
        float Price = Float.parseFloat(PriceU.getText());
        String Brand = BrandU.getText();
        String F_Id = (F_IdU.getText());
        try {
            updateMachinesData(MId,MType,Price,Brand,F_Id);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadMachinesData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdatePanel.setVisible(false);
        AddPanel.setVisible(false);
        DeletePanel.setVisible(false);
        ViewPanel.setVisible(true);
        ExView1.setVisible(false);
    }//GEN-LAST:event_SaveButtonMouseClicked

    private void SaveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMousePressed

    }//GEN-LAST:event_SaveButtonMousePressed

    private void M_IdDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_IdDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_M_IdDActionPerformed

    private void Extract1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract1MouseClicked
        int MId = Integer.parseInt(M_IdD.getText());
        try {
            getMachinesData(MId);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }

        ExView2.setVisible(true);
    }//GEN-LAST:event_Extract1MouseClicked

    private void Extract1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Extract1MousePressed

    private void DeleteRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteRecordMouseClicked
        int MId = Integer.parseInt(M_IdD.getText());
        try {
            dropMachinesData(MId);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadMachinesData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView2.setVisible(false);
        DeletePanel.setVisible(false);
        ViewPanel.setVisible(true);
    }//GEN-LAST:event_DeleteRecordMouseClicked

    private void DeleteRecord2MouseClicked(java.awt.event.MouseEvent evt) {                                          
//        int Loan_Id = Integer.parseInt(Loan_IdD2.getText());
//        try {
//            dropMachinesData(Loan_Id);
//        } catch (Exception ex) {
//            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            loadLoansData();
//        } catch (Exception ex) {
//            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ExView7.setVisible(false);
//        DeletePanel2.setVisible(false);
//        ViewPanel2.setVisible(true);
    }
    private void DeleteRecordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteRecordMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteRecordMousePressed

    private void M_IdAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_IdAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_M_IdAMouseClicked

    private void M_IdAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_IdAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_M_IdAActionPerformed

    private void DeleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMousePressed

    }//GEN-LAST:event_DeleteButtonMousePressed

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        CPanel3.setVisible(true);
        ExitBox.setVisible(true);
        ViewPanel.setVisible(false);
        UpdatePanel.setVisible(false);
        AddPanel.setVisible(false);
        DeletePanel.setVisible(true);
        NavPanel.setVisible(true);
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void UpdateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMousePressed

    }//GEN-LAST:event_UpdateButtonMousePressed

    private void UpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMouseClicked
       CPanel2.setVisible(true);
       ExitBox.setVisible(true);
        ViewPanel.setVisible(false);
        AddPanel.setVisible(false);
        DeletePanel.setVisible(false);
        UpdatePanel.setVisible(true);
        NavPanel.setVisible(true);
        //        Extract.setVisible(true);
    }//GEN-LAST:event_UpdateButtonMouseClicked

    private void AddButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMousePressed

    }//GEN-LAST:event_AddButtonMousePressed

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        ViewPanel.setVisible(false);
        UpdatePanel.setVisible(false);
        ExitBox.setVisible(true);
        DeletePanel.setVisible(false);
        AddPanel.setVisible(true);
        NavPanel.setVisible(true);
    }//GEN-LAST:event_AddButtonMouseClicked

    private void jLabel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MousePressed

    }//GEN-LAST:event_jLabel31MousePressed

    private void ViewButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButtonMousePressed

    }//GEN-LAST:event_ViewButtonMousePressed

    private void ViewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButtonMouseClicked
        try {
            loadMachinesData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExitBox.setVisible(true);
        ViewPanel.setVisible(true);
        UpdatePanel.setVisible(false);
        AddPanel.setVisible(false);
        DeletePanel.setVisible(false);
        NavPanel.setVisible(true);
    }//GEN-LAST:event_ViewButtonMouseClicked

    private void CPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CPanelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_CPanelAncestorAdded

    private void ViewButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButton6MouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AccDelPanel.setVisible(false);
        AccUpdatePanel.setVisible(false);
        AccDisplayPanel.setVisible(true);
        AccAddPanel.setVisible(false);
    }//GEN-LAST:event_ViewButton6MouseClicked

    private void ViewButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButton6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewButton6MousePressed

    private void jLabel62MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel62MousePressed

    private void AddButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton6MouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AccDelPanel.setVisible(false);
        AccUpdatePanel.setVisible(false);
        AccDisplayPanel.setVisible(false);
        AccAddPanel.setVisible(true);

    }//GEN-LAST:event_AddButton6MouseClicked

    private void AddButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton6MousePressed

    private void UpdateButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton6MouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AccDelPanel.setVisible(false);
        AccUpdatePanel.setVisible(true);
        AccDisplayPanel.setVisible(false);
        AccAddPanel.setVisible(false);

    }//GEN-LAST:event_UpdateButton6MouseClicked

    private void UpdateButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButton6MousePressed

    private void DeleteButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton6MouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AccDelPanel.setVisible(true);
        AccUpdatePanel.setVisible(false);
        AccDisplayPanel.setVisible(false);
        AccAddPanel.setVisible(false);

    }//GEN-LAST:event_DeleteButton6MouseClicked

    private void DeleteButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButton6MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccapstone","root","5566");
            PreparedStatement pst;
            String fid  = inputFid.getText();
            String lid = inputLandid.getText();
            String name = inputName.getText();
            String add = inputAddress.getText();
            String area = inputArea.getText();
            String soil = inputSoil.getText();

            pst = con.prepareStatement("SELECT * from farmers WHERE FId = ?");
            pst.setString(1, fid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()==true){
                JOptionPane.showMessageDialog(this, "Username Already exists");
            }

            Statement stmt = con.createStatement();
            String dbop = "INSERT INTO farmers VALUES('"+fid+"', '"+lid+"', '"+name+"', '"+add+"', "+area+", '"+soil+"')";
            stmt.execute(dbop);
            JOptionPane.showMessageDialog(this, "Record Added Successfully!");
            stmt.close();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inputFidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFidActionPerformed

    private void inputLandidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLandidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLandidActionPerformed

    private void inputSoilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSoilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSoilActionPerformed

    private void DisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccapstone","root","5566");
            String query = "select * from farmers";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(table2.getRowCount() > 0){
                ((DefaultTableModel)table2.getModel()).removeRow(0);
            }

            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)table2.getModel()).insertRow(rs.getRow()-1, rows);
            }

            stmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_DisplayButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int row = table1.getSelectedRow();
        String fid = (String) model.getValueAt(row,0);
        String lid = (String) model.getValueAt(row, 1);
        String name = (String) model.getValueAt(row,2);
        String add = (String) model.getValueAt(row, 3);
        String la = (String) model.getValueAt(row,4);
        String soil = (String) model.getValueAt(row, 5);

        editFid.setText(fid);
        editLid.setText(lid);
        editName.setText(name);
        editAdd.setText(add);
        editLa.setText(la);
        editSoil.setText(soil);
    }//GEN-LAST:event_editButtonActionPerformed

    private void editNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editNameActionPerformed

    private void editSoilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSoilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editSoilActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:

        try{
            PreparedStatement pst;
            pst = con.prepareStatement("UPDATE farmers SET landID=?,name=?,address=?,landArea=?,soilType=? WHERE FId = ?");
            pst.setString(1,editLid.getText());
            pst.setString(2,editName.getText());
            pst.setString(3,editAdd.getText());
            pst.setString(4,editLa.getText());
            pst.setString(5,editSoil.getText());
            pst.setString(6,editFid.getText());

            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");

            refresh1.doClick();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh1ActionPerformed
        // TODO add your handling code here:

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccapstone","root","5566");
            String query = "select * from farmers";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(table1.getRowCount() > 0){
                ((DefaultTableModel)table1.getModel()).removeRow(0);
            }

            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)table1.getModel()).insertRow(rs.getRow()-1, rows);
            }

            stmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_refresh1ActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        // TODO add your handling code here:
        refresh1.doClick();
    }//GEN-LAST:event_ShowActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

        try{
            PreparedStatement pst;
            int row = table.getSelectedRow();
            String fid = (String) table.getValueAt(row,0);

            String delQuery = "DELETE FROM farmers WHERE FId = ?";
            pst = con.prepareStatement(delQuery);
            pst.setString(1, fid);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
            refresh.doClick();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        try{

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccapstone","root","5566");

            String query = "select * from farmers";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(table.getRowCount() > 0){
                ((DefaultTableModel)table.getModel()).removeRow(0);
            }

            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)table.getModel()).insertRow(rs.getRow()-1, rows);
            }

            stmt.close();
        }catch(Exception ex){
            //Logger.getLogger(databaseTest.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void ShowDelAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDelAccActionPerformed
        // TODO add your handling code here:
        refresh.doClick();
    }//GEN-LAST:event_ShowDelAccActionPerformed

    private void APMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APMouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AP.setVisible(true);
        FP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        LP.setVisible(false);
    }//GEN-LAST:event_APMouseClicked

    private void MPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPMouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(true);
        SDP.setVisible(false);
        LP.setVisible(false);
    }//GEN-LAST:event_MPMouseClicked

    private void ViewButton_FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButton_FPMouseClicked
        try {
            loadFNMData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewPanel_FP.setVisible(true);
        UpdatePanel_FP.setVisible(false);
        AddPanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(false);
        NavPanel_FP.setVisible(true);
        ExitBox.setVisible(true);

    }//GEN-LAST:event_ViewButton_FPMouseClicked

    private void ViewButton_FPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButton_FPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewButton_FPMousePressed

    private void jLabel175MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel175MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel175MousePressed

    private void AddButton_FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton_FPMouseClicked
        ViewPanel_FP.setVisible(false);
        UpdatePanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(false);
        AddPanel_FP.setVisible(true);
        NavPanel_FP.setVisible(true);
    }//GEN-LAST:event_AddButton_FPMouseClicked

    private void AddButton_FPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton_FPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton_FPMousePressed

    private void UpdateButton_FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton_FPMouseClicked
        ViewPanel_FP.setVisible(false);
        AddPanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(false);
        UpdatePanel_FP.setVisible(true);
        NavPanel_FP.setVisible(true);
    }//GEN-LAST:event_UpdateButton_FPMouseClicked

    private void UpdateButton_FPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton_FPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButton_FPMousePressed

    private void DeleteButton_FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton_FPMouseClicked
        ViewPanel_FP.setVisible(false);
        UpdatePanel_FP.setVisible(false);
        AddPanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(true);
        NavPanel_FP.setVisible(true);
    }//GEN-LAST:event_DeleteButton_FPMouseClicked

    private void DeleteButton_FPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton_FPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButton_FPMousePressed

    private void Search5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search5MouseClicked
        String attr = (String)FilAttr5.getSelectedItem();
        String value = FilVal5.getText();
        try {
            filterFNMData(attr, value);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Search5MouseClicked

    private void Refresh5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Refresh5MouseClicked
        try {
            loadFNMData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Refresh5MouseClicked

    private void AddRecord5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRecord5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddRecord5MouseClicked

    private void AddRecord5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecord5ActionPerformed
        String Category = CatBox.getText();
        String name = NameBox.getText();
        float Price = Float.parseFloat(PriceBox.getText());

        try {
            insertFNMData(Category, name, Price);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadFNMData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewPanel_FP.setVisible(true);
        AddPanel_FP.setVisible(false);
        UpdatePanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(false);
    }//GEN-LAST:event_AddRecord5ActionPerformed

    private void CatBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CatBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CatBoxMouseClicked

    private void CatBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatBoxActionPerformed

    private void Price_UpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Price_UpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Price_UpActionPerformed

    private void Update_FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update_FPMouseClicked
        String Category = Cat_Up.getText();
        String name = Name_Up.getText();
        float Price = Float.parseFloat(Price_Up.getText());

        try {
            updateFNMData(Category, name, Price);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadFNMData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdatePanel_FP.setVisible(false);
        AddPanel_FP.setVisible(false);
        DeletePanel_FP.setVisible(false);
        ViewPanel_FP.setVisible(true);
        ExView_FP_Up.setVisible(false);
    }//GEN-LAST:event_Update_FPMouseClicked

    private void Update_FPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update_FPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Update_FPMousePressed

    private void Extract10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract10MouseClicked
        String name = NameBox1.getText();
        try {
            getFNMData(name);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView_FP_Up.setVisible(true);
    }//GEN-LAST:event_Extract10MouseClicked

    private void Extract10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Extract10MousePressed

    private void NameBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameBox1ActionPerformed

    private void Drop_FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Drop_FPMouseClicked
        String name = NameBox2.getText();
        try {
            dropFNMData(name);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadFNMData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView_FP_del.setVisible(false);
        DeletePanel_FP.setVisible(false);
        ViewPanel_FP.setVisible(true);
    }//GEN-LAST:event_Drop_FPMouseClicked

    private void Drop_FPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Drop_FPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Drop_FPMousePressed

    private void Extract11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract11MouseClicked
        String name = NameBox2.getText();
        try {
            getFNMData(name);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }

        ExView_FP_del.setVisible(true);
    }//GEN-LAST:event_Extract11MouseClicked

    private void Extract11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract11MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Extract11MousePressed

    private void NameBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameBox2ActionPerformed

    private void SeedViewNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedViewNavMouseClicked
        // TODO add your handling code here:

        SeedNavPanel.setVisible(true);
        SeedDisplayPanel.setVisible(true);
        SeedAddPanel.setVisible(false);
        SeedUpdatePanel.setVisible(false);
        SeedDelPanel.setVisible(false);

    }//GEN-LAST:event_SeedViewNavMouseClicked

    private void SeedViewNavMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedViewNavMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeedViewNavMousePressed

    private void jLabel114MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel114MousePressed

    private void SeedAddNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedAddNavMouseClicked
        // TODO add your handling code here:
        SeedNavPanel.setVisible(true);
        SeedDisplayPanel.setVisible(false);
        SeedAddPanel.setVisible(true);
        SeedUpdatePanel.setVisible(false);
        SeedDelPanel.setVisible(false);
    }//GEN-LAST:event_SeedAddNavMouseClicked

    private void SeedAddNavMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedAddNavMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeedAddNavMousePressed

    private void SeedUpdateNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedUpdateNavMouseClicked
        // TODO add your handling code here:
        SeedNavPanel.setVisible(true);
        SeedDisplayPanel.setVisible(false);
        SeedAddPanel.setVisible(false);
        SeedUpdatePanel.setVisible(true);
        SeedDelPanel.setVisible(false);
    }//GEN-LAST:event_SeedUpdateNavMouseClicked

    private void SeedUpdateNavMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedUpdateNavMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeedUpdateNavMousePressed

    private void SeedDelNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedDelNavMouseClicked
        // TODO add your handling code here:
        SeedNavPanel.setVisible(true);
        SeedDisplayPanel.setVisible(false);
        SeedAddPanel.setVisible(false);
        SeedUpdatePanel.setVisible(false);
        SeedDelPanel.setVisible(true);
    }//GEN-LAST:event_SeedDelNavMouseClicked

    private void SeedDelNavMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeedDelNavMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeedDelNavMousePressed

    private void DisplaySeedsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplaySeedsActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tableModel = (DefaultTableModel) SeedDisp.getModel();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcCapstone","root","5566");
            String query = "select * from SEEDS";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(SeedDisp.getRowCount() > 0){
                ((DefaultTableModel)SeedDisp.getModel()).removeRow(0);
            }

            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)SeedDisp.getModel()).insertRow(rs.getRow()-1, rows);
            }

            stmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_DisplaySeedsActionPerformed

    private void InsertSeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertSeedActionPerformed
        // TODO add your handling code here:
        try{

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcCapstone","root","5566");
            PreparedStatement pst;
            String stype  = inputSeedType.getText();
            float price = Float.parseFloat(inputSeedPrice.getText());
            float quant = Float.parseFloat(inputSeedQuantity.getText());
            String grade = inputSeedGrade.getText();

            pst = con.prepareStatement("SELECT * from SEEDS WHERE Type = ?");
            pst.setString(1, stype);
            ResultSet rs = pst.executeQuery();
            if(rs.next()==true){
                JOptionPane.showMessageDialog(this, "SeedType Already exists");
            }

            Statement stmt = con.createStatement();
            String dbop = "INSERT INTO SEEDS VALUES('"+stype+"', "+price+", "+quant+", '"+grade+"')";
            stmt.execute(dbop);
            JOptionPane.showMessageDialog(this, "Record Added Successfully!");
            stmt.close();

        }catch(Exception ex){
            System.out.println(ex);
        }

    }//GEN-LAST:event_InsertSeedActionPerformed

    private void inputSeedTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSeedTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSeedTypeActionPerformed

    private void inputSeedPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSeedPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSeedPriceActionPerformed

    private void SeedUpEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeedUpEditActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) SeedUpTable.getModel();
        int row = SeedUpTable.getSelectedRow();
        String stype = (String) model.getValueAt(row,0);
        String price = (String) model.getValueAt(row, 1).toString();
        String quant = (String) model.getValueAt(row,2).toString();
        String grade = (String) model.getValueAt(row, 3);

        editStype.setText(stype);
        editPrice.setText(price);
        editQuantity.setText(quant);
        editGrade.setText(grade);
    }//GEN-LAST:event_SeedUpEditActionPerformed

    private void editQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editQuantityActionPerformed

    private void SeedUpUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeedUpUpdateActionPerformed
        // TODO add your handling code here:

        try{
            PreparedStatement pst;
            pst = con.prepareStatement("UPDATE SEEDS SET Price=?,Quantity=?,Grade=? WHERE type = ?");

            pst.setFloat(1,Float.parseFloat(editPrice.getText()));
            pst.setFloat(2,Float.parseFloat(editQuantity.getText()));
            pst.setString(3,editGrade.getText());
            pst.setString(4,editStype.getText());

            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");

            SeedUpShow.doClick();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_SeedUpUpdateActionPerformed

    private void SeedUpRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeedUpRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeedUpRefreshActionPerformed

    private void SeedUpShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeedUpShowActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) SeedUpTable.getModel();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcCapstone","root","5566");
            String query = "select * from SEEDS";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(SeedUpTable.getRowCount() > 0){
                ((DefaultTableModel)SeedUpTable.getModel()).removeRow(0);
            }

            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)SeedUpTable.getModel()).insertRow(rs.getRow()-1, rows);
            }

            stmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_SeedUpShowActionPerformed

    private void DeleteSeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSeedActionPerformed
        // TODO add your handling code here:

        try{
            PreparedStatement pst;
            int row = SeedDelTable.getSelectedRow();
            String stype = (String) SeedDelTable.getValueAt(row,0);

            String delQuery = "DELETE FROM SEEDS WHERE TYPE = ?";
            pst = con.prepareStatement(delQuery);
            pst.setString(1, stype);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
            ShowDelSeed.doClick();

        }catch(Exception ex){
            System.out.println(ex);
        }

    }//GEN-LAST:event_DeleteSeedActionPerformed

    private void RefreshDelSeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshDelSeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshDelSeedActionPerformed

    private void ShowDelSeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDelSeedActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tableModel = (DefaultTableModel) SeedDelTable.getModel();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcCapstone","root","5566");
            String query = "select * from SEEDS";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(SeedDelTable.getRowCount() > 0){
                ((DefaultTableModel)SeedDelTable.getModel()).removeRow(0);
            }

            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] rows = new Object[col];
                for(int i=1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)SeedDelTable.getModel()).insertRow(rs.getRow()-1, rows);
            }

            stmt.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_ShowDelSeedActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void ViewButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButton2MouseClicked
        // TODO add your handling code here:
        LoanViewPanel.setVisible(true);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
        LoanNavPanel.setVisible(true);
        //ExitBox.setVisible(true);
        try {
            loadLoansData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ViewButton2MouseClicked

    private void ViewButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewButton2MousePressed

    private void jLabel81MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel81MousePressed

    private void AddButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton2MouseClicked
        // TODO add your handling code here:
        LoanViewPanel.setVisible(false);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(true);
        LoanDeletePanel.setVisible(false);
        LoanNavPanel.setVisible(true);
        //ExitBox.setVisible(true);
    }//GEN-LAST:event_AddButton2MouseClicked

    private void AddButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton2MousePressed

    private void UpdateButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton2MouseClicked
        // TODO add your handling code here:
        LoanViewPanel.setVisible(false);
        LoanUpdatePanel.setVisible(true);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
        ExView5.setVisible(false);
        LoanNavPanel.setVisible(true);
        //ExitBox.setVisible(true);
    }//GEN-LAST:event_UpdateButton2MouseClicked

    private void UpdateButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButton2MousePressed

    private void DeleteButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton2MouseClicked
        // TODO add your handling code here:
        LoanViewPanel.setVisible(false);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(true);
        LoanNavPanel.setVisible(true);
        ExView7.setVisible(false);
        //ExitBox.setVisible(true);
    }//GEN-LAST:event_DeleteButton2MouseClicked

    private void DeleteButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButton2MouseEntered

    private void DeleteButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButton2MousePressed

    private void Search2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search2MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        String attr = (String)FilAttr2.getSelectedItem();
        String value = FilVal2.getText();
        boolean incorrect = true;
        //        while(incorrect){
            //        try{Double.parseDouble(value);incorrect = false;}
            //        catch(NumberFormatException nfe){
                //           amtRentIn=JOptionPane.showInputDialog("Invalid input. Please "+
                    //                   "enter your rent: ");
                //         }
            //
            //        }
        try {
            filterLoansData(attr, value);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Search2MouseClicked

    private void Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search2ActionPerformed

    }//GEN-LAST:event_Search2ActionPerformed

    private void Refresh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Refresh2MouseClicked
        // TODO add your handling code here:
        try {
            loadLoansData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Refresh2MouseClicked

    private void FilAttr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilAttr2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilAttr2ActionPerformed

    private void AddRecord2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRecord2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddRecord2MouseClicked

    private void AddRecord2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecord2ActionPerformed
        int Loan_Id = Integer.parseInt(LoanIDA.getText());
        String Loan_Type = LoanTypeA.getText();
        String LStatus = LStatusA.getText();
        String Bank = LoanBankA.getText();
        float Interest = Float.parseFloat(InterestA.getText());
        int Duration = Integer.parseInt(DurationA.getText());
        float Total = Float.parseFloat(TotalA.getText());
        String FId = LoanFIdA.getText();
        try {
            insertLoansData(Loan_Id, Loan_Type, Bank, Interest, Duration, Total, FId, LStatus);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadLoansData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoanViewPanel.setVisible(true);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
        LoanNavPanel.setVisible(true);
        //ExitBox.setVisible(true);
        LoanViewPanel.setVisible(true);
        LoanAddPanel.setVisible(false);
        LoanUpdatePanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
    }//GEN-LAST:event_AddRecord2ActionPerformed

    private void LoanBankAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanBankAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanBankAActionPerformed

    private void LStatusAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LStatusAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LStatusAMouseClicked

    private void LStatusAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LStatusAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LStatusAActionPerformed

    private void TotalAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAActionPerformed

    private void LoanIDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoanIDAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanIDAMouseClicked

    private void LoanIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanIDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanIDAActionPerformed

    private void LoanFIdAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoanFIdAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanFIdAMouseClicked

    private void LoanFIdAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanFIdAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanFIdAActionPerformed

    private void SaveButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButton2MouseClicked
        // TODO add your handling code here:
        int Loan_Id = Integer.parseInt(Loan_IdU.getText());
        String Loan_Type = Loan_TypeU.getText();
        String LStatus = LStatusU.getText();
        String Bank = BankU.getText();
        float Interest = Float.parseFloat(InterestU.getText());
        int Duration = Integer.parseInt(DurationU.getText());
        int Total = Integer.parseInt(TotalU.getText());
        String FId = LoanF_IdU.getText();
        try {
            updateLoanData(Loan_Id,Loan_Type,Bank,Interest,Duration,Total,FId,LStatus);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadLoansData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoanViewPanel.setVisible(true);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
        LoanNavPanel.setVisible(true);
        //ExitBox.setVisible(true);
        //        UpdatePanel.setVisible(false);
        //        AddPanel.setVisible(false);
        //        DeletePanel.setVisible(false);
        //        ViewPanel.setVisible(true);
        ExView5.setVisible(false);
    }//GEN-LAST:event_SaveButton2MouseClicked

    private void SaveButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButton2MousePressed

    private void SaveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButton2ActionPerformed

    private void Extract4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract4MouseClicked
        // TODO add your handling code here:
        int Loan_Id = Integer.parseInt(Loan_IdU1.getText());
        try {
            getLoanData(Loan_Id);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView5.setVisible(true);
    }//GEN-LAST:event_Extract4MouseClicked

    private void Extract4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Extract4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Extract4MousePressed

    private void Loan_IdU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loan_IdU1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Loan_IdU1ActionPerformed

    private void LoanDelExtractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoanDelExtractMouseClicked
        // TODO add your handling code here:
        int Loan_Id = Integer.parseInt(Loan_IdD2.getText());
        try {
            getLoanData(Loan_Id);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView7.setVisible(true);
    }//GEN-LAST:event_LoanDelExtractMouseClicked

    private void LoanDelExtractMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoanDelExtractMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanDelExtractMousePressed

    private void Loan_IdD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loan_IdD2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Loan_IdD2ActionPerformed

    private void LoanDeleteRecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoanDeleteRecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanDeleteRecMouseClicked

    private void LoanDeleteRecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoanDeleteRecMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoanDeleteRecMousePressed

    private void LoanDeleteRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanDeleteRecActionPerformed
        int Loan_Id = Integer.parseInt(Loan_IdD2.getText());
        try {
            dropLoansData(Loan_Id);
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadLoansData();
        } catch (Exception ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExView7.setVisible(false);
        LoanDeletePanel.setVisible(false);
        LoanViewPanel.setVisible(true);
        LoanViewPanel.setVisible(true);
        LoanUpdatePanel.setVisible(false);
        LoanAddPanel.setVisible(false);
        LoanDeletePanel.setVisible(false);
        LoanNavPanel.setVisible(true);
        //ExitBox.setVisible(true);
    }//GEN-LAST:event_LoanDeleteRecActionPerformed

    private void LPAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_LPAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_LPAncestorAdded

    private void CloseIcon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseIcon1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseIcon1MousePressed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
        this.setExtendedState(Accounts.ICONIFIED);
    }//GEN-LAST:event_jLabel13MousePressed

    private void LPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPMouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        LP.setVisible(true);
    }//GEN-LAST:event_LPMouseClicked

    private void FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FPMouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        LP.setVisible(true);
    }//GEN-LAST:event_FPMouseClicked

    private void SDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SDPMouseClicked
        // TODO add your handling code here:
        ExitBox.setVisible(true);
        AP.setVisible(false);
        FP.setVisible(false);
        MP.setVisible(false);
        SDP.setVisible(false);
        LP.setVisible(true);
    }//GEN-LAST:event_SDPMouseClicked
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Accounts().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AP;
    private javax.swing.JPanel AccAddPanel;
    private javax.swing.JPanel AccDelPanel;
    private javax.swing.JPanel AccDisplayPanel;
    private javax.swing.JPanel AccUpdatePanel;
    private javax.swing.JPanel AccountsTab;
    private javax.swing.JPanel AddButton;
    private javax.swing.JPanel AddButton2;
    private javax.swing.JPanel AddButton6;
    private javax.swing.JPanel AddButton_FP;
    private javax.swing.JPanel AddPanel;
    private javax.swing.JPanel AddPanel_FP;
    private javax.swing.JButton AddRecord;
    private javax.swing.JButton AddRecord2;
    private javax.swing.JButton AddRecord5;
    private javax.swing.JPanel Background;
    private javax.swing.JTextField BankD;
    private javax.swing.JTextField BankU;
    private javax.swing.JTextField BrandA;
    private javax.swing.JTextField BrandD;
    private javax.swing.JTextField BrandU;
    private javax.swing.JPanel CPanel;
    private javax.swing.JPanel CPanel1;
    private javax.swing.JPanel CPanel10;
    private javax.swing.JPanel CPanel11;
    private javax.swing.JPanel CPanel2;
    private javax.swing.JPanel CPanel20;
    private javax.swing.JPanel CPanel21;
    private javax.swing.JPanel CPanel22;
    private javax.swing.JPanel CPanel23;
    private javax.swing.JPanel CPanel3;
    private javax.swing.JPanel CPanel8;
    private javax.swing.JPanel CPanel9;
    private javax.swing.JTextField CatBox;
    private javax.swing.JTextField Cat_Up;
    private javax.swing.JTextField Cat_del;
    private javax.swing.JLabel CloseIcon1;
    private javax.swing.JButton Delete;
    private javax.swing.JPanel DeleteButton;
    private javax.swing.JPanel DeleteButton2;
    private javax.swing.JPanel DeleteButton6;
    private javax.swing.JPanel DeleteButton_FP;
    private javax.swing.JPanel DeletePanel;
    private javax.swing.JPanel DeletePanel_FP;
    private javax.swing.JButton DeleteRecord;
    private javax.swing.JButton DeleteSeed;
    private javax.swing.JButton DisplayButton;
    private javax.swing.JButton DisplaySeeds;
    private javax.swing.JButton Drop_FP;
    private javax.swing.JTextField DurationA;
    private javax.swing.JTextField DurationD;
    private javax.swing.JTextField DurationU;
    private javax.swing.JPanel ExView1;
    private javax.swing.JPanel ExView2;
    private javax.swing.JPanel ExView5;
    private javax.swing.JPanel ExView7;
    private javax.swing.JPanel ExView_FP_Up;
    private javax.swing.JPanel ExView_FP_del;
    private javax.swing.JPanel ExitBox;
    private javax.swing.JButton Extract;
    private javax.swing.JButton Extract1;
    private javax.swing.JButton Extract10;
    private javax.swing.JButton Extract11;
    private javax.swing.JButton Extract4;
    private javax.swing.JPanel FP;
    private javax.swing.JTextField F_IdA;
    private javax.swing.JTextField F_IdD;
    private javax.swing.JTextField F_IdD3;
    private javax.swing.JTextField F_IdU;
    private javax.swing.JPanel FertilizersTab;
    private javax.swing.JComboBox<String> FilAttr;
    private javax.swing.JComboBox<String> FilAttr2;
    private javax.swing.JComboBox<String> FilAttr5;
    private javax.swing.JTextField FilVal;
    private javax.swing.JTextField FilVal2;
    private javax.swing.JTextField FilVal5;
    private javax.swing.JButton InsertSeed;
    private javax.swing.JTextField InterestA;
    private javax.swing.JTextField InterestD;
    private javax.swing.JTextField InterestU;
    private javax.swing.JPanel LP;
    private javax.swing.JTextField LStatusA;
    private javax.swing.JTextField LStatusD;
    private javax.swing.JTextField LStatusU;
    private javax.swing.JPanel LoanAddPanel;
    private javax.swing.JTextField LoanBankA;
    private javax.swing.JButton LoanDelExtract;
    private javax.swing.JPanel LoanDeletePanel;
    private javax.swing.JButton LoanDeleteRec;
    private javax.swing.JTextField LoanFIdA;
    private javax.swing.JTextField LoanF_IdU;
    private javax.swing.JTextField LoanIDA;
    private javax.swing.JPanel LoanNavPanel;
    private javax.swing.JTextField LoanTypeA;
    private javax.swing.JPanel LoanUpdatePanel;
    private javax.swing.JPanel LoanViewPanel;
    private javax.swing.JTextField Loan_IdD;
    private javax.swing.JTextField Loan_IdD2;
    private javax.swing.JTextField Loan_IdU;
    private javax.swing.JTextField Loan_IdU1;
    private javax.swing.JTextField Loan_TypeD;
    private javax.swing.JTextField Loan_TypeU;
    private javax.swing.JPanel LoansTab;
    private javax.swing.JPanel MP;
    private javax.swing.JTextField MTypeA;
    private javax.swing.JTextField MTypeD;
    private javax.swing.JTextField MTypeU;
    private javax.swing.JTextField M_IdA;
    private javax.swing.JTextField M_IdD;
    private javax.swing.JTextField M_IdU;
    private javax.swing.JPanel MachinesTab;
    private javax.swing.JTextField NameBox;
    private javax.swing.JTextField NameBox1;
    private javax.swing.JTextField NameBox2;
    private javax.swing.JTextField Name_Up;
    private javax.swing.JTextField Name_del;
    private javax.swing.JPanel NavPanel;
    private javax.swing.JPanel NavPanel6;
    private javax.swing.JPanel NavPanel_FP;
    private javax.swing.JTextField PriceA;
    private javax.swing.JTextField PriceBox;
    private javax.swing.JTextField PriceD;
    private javax.swing.JTextField PriceU;
    private javax.swing.JTextField Price_Up;
    private javax.swing.JTextField Price_del;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Refresh2;
    private javax.swing.JButton Refresh5;
    private javax.swing.JButton RefreshDelSeed;
    private javax.swing.JPanel SDP;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SaveButton2;
    private javax.swing.JButton Search;
    private javax.swing.JButton Search2;
    private javax.swing.JButton Search5;
    private javax.swing.JPanel SeedAddNav;
    private javax.swing.JPanel SeedAddPanel;
    private javax.swing.JPanel SeedDelNav;
    private javax.swing.JPanel SeedDelPanel;
    private javax.swing.JTable SeedDelTable;
    private javax.swing.JTable SeedDisp;
    private javax.swing.JPanel SeedDisplayPanel;
    private javax.swing.JPanel SeedNavPanel;
    private javax.swing.JButton SeedUpEdit;
    private javax.swing.JButton SeedUpRefresh;
    private javax.swing.JButton SeedUpShow;
    private javax.swing.JTable SeedUpTable;
    private javax.swing.JButton SeedUpUpdate;
    private javax.swing.JPanel SeedUpdateNav;
    private javax.swing.JPanel SeedUpdatePanel;
    private javax.swing.JPanel SeedViewNav;
    private javax.swing.JPanel SeedsTab;
    private javax.swing.JButton Show;
    private javax.swing.JButton ShowDelAcc;
    private javax.swing.JButton ShowDelSeed;
    private javax.swing.JPanel StatusTab;
    private javax.swing.JTextField TotalA;
    private javax.swing.JTextField TotalD;
    private javax.swing.JTextField TotalU;
    private javax.swing.JPanel UpdateButton;
    private javax.swing.JPanel UpdateButton2;
    private javax.swing.JPanel UpdateButton6;
    private javax.swing.JPanel UpdateButton_FP;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JPanel UpdatePanel_FP;
    private javax.swing.JButton Update_FP;
    private javax.swing.JPanel ViewButton;
    private javax.swing.JPanel ViewButton2;
    private javax.swing.JPanel ViewButton6;
    private javax.swing.JPanel ViewButton_FP;
    private javax.swing.JPanel ViewPanel;
    private javax.swing.JPanel ViewPanel_FP;
    private javax.swing.JTextField editAdd;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField editFid;
    private javax.swing.JTextField editGrade;
    private javax.swing.JTextField editLa;
    private javax.swing.JTextField editLid;
    private javax.swing.JTextField editName;
    private javax.swing.JTextField editPrice;
    private javax.swing.JTextField editQuantity;
    private javax.swing.JTextField editSoil;
    private javax.swing.JTextField editStype;
    private javax.swing.JTextField inputAddress;
    private javax.swing.JTextField inputArea;
    private javax.swing.JTextField inputFid;
    private javax.swing.JTextField inputLandid;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputSeedGrade;
    private javax.swing.JTextField inputSeedPrice;
    private javax.swing.JTextField inputSeedQuantity;
    private javax.swing.JTextField inputSeedType;
    private javax.swing.JTextField inputSoil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable6;
    private javax.swing.JButton refresh;
    private javax.swing.JButton refresh1;
    private javax.swing.JPanel side_window;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
